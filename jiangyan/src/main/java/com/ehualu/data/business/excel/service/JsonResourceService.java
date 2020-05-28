package com.ehualu.data.business.excel.service;

import com.alibaba.fastjson.JSONObject;
import com.ehualu.data.business.excel.model.InfoBean;
import com.ehualu.data.business.excel.model.JsonBean;
import com.ehualu.data.business.excel.model.TableInfoBean;
import com.ehualu.data.business.resource.dao.ColumnMapper;
import com.ehualu.data.business.resource.dao.TableMapper;
import com.ehualu.data.business.resource.model.Column;
import com.ehualu.data.business.resource.model.Table;
import com.ehualu.data.business.resource.model.TableExample;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author created by guanchen on 2020/5/25 16:33
 */
@Service
@Slf4j
public class JsonResourceService {
    @Autowired
    private TableMapper tableMapper;
    @Autowired
    private ColumnMapper columnMapper;

    @SneakyThrows
    public void readJson(){
        List<String> stringList = Files.lines(Paths.get("D:\\test.json"))
                .collect(java.util.stream.Collectors.toList());
        StringBuilder sb = new StringBuilder();
        stringList.forEach(str -> sb.append(str));

        List<JsonBean> infoBeanList = JSONObject.parseArray(sb.toString(),JsonBean.class);
        log.info(infoBeanList.size() + "");
        infoBeanList.forEach(infoBean -> add(infoBean.getBean().getData()));
    }
    public void add(TableInfoBean bean){
        TableExample te = new TableExample();
        te.createCriteria().andResourceCodeEqualTo(bean.getResourceCode()).andLevelEqualTo("1");
        List<Table> tables = tableMapper.selectByExample(te);
        if (!tables.isEmpty()){
            log.error(String.format("资源表《%s》已经存在",bean.getResourceName()) );
            return;
        }
        log.info("insert ==" + bean.getResourceName());
        Table table = new Table();
        table.setCount(bean.getCurCount());
        table.setResourceCode(bean.getResourceCode().trim());
        table.setResourceName(bean.getResourceName());
        table.setResourceTableCode(bean.getResourceTableCode().trim());
        table.setResourceTableName(bean.getResourceTableName());
        table.setTablePhysicalName(bean.getTablePhysicalName());
        table.setLevel("1");
        tableMapper.insert(table);

        Map<String, Column> columnMap = new HashMap<>();
        bean.getItemList().forEach(item -> {
            Column column = new Column();
            column.setResourceName(table.getResourceName());
            column.setResourceTableCode(table.getResourceTableCode().trim());
            column.setResourceTableName(table.getResourceTableName());
            column.setLevel("1");
            column.setName(item.getResourceItemName());
            column.setDes(item.getColumnRemark());
            column.setType(item.getDataItemType());
            column.setLength(item.getLength());
//            String dictGroupName = StringUtils.isBlank(item.getDataMetaName()) ?
//                    item.getDictGroupValue() : item.getDataMetaName();
//            column.setDictGroupCode(item.getDictGroupValue());
            column.setDictGroupName(item.getDictGroupValue());
            column.setDictTableCode(item.getDictTableCode());
            column.setDictTableName(item.getDictTableName());

            columnMapper.insert(column);
        });
    }
}
