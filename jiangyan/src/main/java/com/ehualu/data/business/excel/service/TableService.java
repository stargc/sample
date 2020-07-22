package com.ehualu.data.business.excel.service;

import com.ehualu.data.business.excel.model.TableInfoBean;
import com.ehualu.data.business.resource.dao.ColumnMapper;
import com.ehualu.data.business.resource.dao.DictMapper;
import com.ehualu.data.business.resource.dao.TableMapper;
import com.ehualu.data.business.resource.dao.TestValueMapper;
import com.ehualu.data.business.resource.model.Column;
import com.ehualu.data.business.resource.model.Table;
import com.ehualu.data.business.resource.model.TestValue;
import com.ehualu.data.common.util.CheckUtil;
import com.ehualu.data.common.util.DesensitizedUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author created by guanchen on 2020/5/21 14:16
 */
@Service
@Slf4j
public class TableService {
    @Autowired
    private TableMapper tableMapper;
    @Autowired
    private ColumnMapper columnMapper;
    @Autowired
    private DictMapper dictMapper;
    @Autowired
    private TestValueMapper testValueMapper;

    @Transactional(rollbackFor = Exception.class)
    public void addData(List<TableInfoBean> beanList) {

        for (int i = 0; i < 2000000; i++) {
            TestValue test = new TestValue();
            test.setText1(String.valueOf(UUID.randomUUID().hashCode()));
            testValueMapper.insert(test);
        }



//        if (beanList.isEmpty()) return;
//        beanList.forEach(bean -> {
//            log.info("insert ==" + bean.getResourceName());
//            Table table = new Table();
//            table.setCount(bean.getCurCount());
//            table.setResourceCode(bean.getResourceCode());
//            table.setResourceName(bean.getResourceName());
//            table.setResourceTableCode(bean.getResourceTableCode());
//            table.setResourceTableName(bean.getResourceTableName());
//            table.setTablePhysicalName(bean.getTablePhysicalName());
//            tableMapper.insert(table);
//
//            Map<String, Column> columnMap = new HashMap<>();
//            bean.getItemList().forEach(item -> {
//                Column column = new Column();
//                column.setResourceName(table.getResourceName());
//                column.setResourceTableCode(table.getResourceTableCode());
//                column.setResourceTableName(table.getResourceTableName());
//
//                column.setName(item.getResourceItemName());
//                column.setDes(item.getColumnRemark());
//                column.setType(item.getDataItemType());
//                column.setLength(item.getLength());
//
//                column.setDictGroupName(item.getDictGroupValue());
//                column.setDictTableCode(item.getDictTableCode());
//                column.setDictTableName(item.getDictTableName());
//
//                columnMap.put(column.getName(), column);
//            });
//
//            AtomicInteger i = new AtomicInteger(1);
//
//            Optional.ofNullable(bean.getSampleData()).ifPresent(sampleData -> {
//                sampleData.forEach(sample -> {
//                    sample.forEach((k, v) -> {
//                        Column column = columnMap.get(k);
//                        if (CheckUtil.isPhone(v)) {
//                            v = DesensitizedUtils.mobilePhone(v);
//                        } else if (CheckUtil.isIdNum(v)) {
//                            v = DesensitizedUtils.idCardNum(v);
//                        } else if (CheckUtil.isBigText(v)){
//                            v = DesensitizedUtils.bigText(v);
//                        } else if (CheckUtil.isName(v)){
//                            v = DesensitizedUtils.chineseName(v);
//                        } else {
//                            v = DesensitizedUtils.desensitized(v);
//                        }
//                        if (column == null) return;
//                        switch (i.get()) {
//                            case 1:
//                                column.setSampleData1(v);
//                                break;
//                            case 2:
//                                column.setSampleData2(v);
//                                break;
//                            case 3:
//                                column.setSampleData3(v);
//                                break;
//                            case 4:
//                                column.setSampleData4(v);
//                                break;
//                            case 5:
//                                column.setSampleData5(v);
//                                break;
//                            case 6:
//                                column.setSampleData6(v);
//                                break;
//                            case 7:
//                                column.setSampleData7(v);
//                                break;
//                            case 8:
//                                column.setSampleData8(v);
//                                break;
//                            case 9:
//                                column.setSampleData9(v);
//                                break;
//                            case 10:
//                                column.setSampleData10(v);
//                                break;
//                            default:
//                                break;
//                        }
//                    });
//                    i.getAndIncrement();
//                });
//            });
//            columnMap.values().forEach(column -> columnMapper.insert(column));
//        });
    }
}
