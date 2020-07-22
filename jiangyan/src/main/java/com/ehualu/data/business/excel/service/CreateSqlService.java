package com.ehualu.data.business.excel.service;

import com.ehualu.data.business.excel.model.CreateSQLTableEnum;
import com.ehualu.data.business.resource.dao.ColumnMapper;
import com.ehualu.data.business.resource.dao.TableMapper;
import com.ehualu.data.business.resource.model.Column;
import com.ehualu.data.business.resource.model.ColumnExample;
import com.ehualu.data.business.resource.model.Table;
import com.ehualu.data.business.resource.model.TableExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author created by guanchen on 2020/6/9 15:16
 */
@Service
@Slf4j
public class CreateSqlService {

    @Autowired
    private TableMapper tableMapper;
    @Autowired
    private ColumnMapper columnMapper;


    public String createSql(){
        TableExample tableExample = new TableExample();


        List<String> resourceNameList = Arrays.stream(CreateSQLTableEnum.values()).map(CreateSQLTableEnum::getResourceName).collect(Collectors.toList());
        log.info(String.format("查询表数量 %d",resourceNameList.size()));

        StringBuilder sql = new StringBuilder();
        resourceNameList.stream().forEach(resourceName -> {
            ColumnExample example = new ColumnExample();
            example.createCriteria().andResourceNameEqualTo(resourceName).andLevelEqualTo("0");
            List<Column> columnList = columnMapper.selectByExample(example);
            if (columnList.isEmpty()) {
                ColumnExample example1 = new ColumnExample();
                example1.createCriteria().andResourceNameEqualTo(resourceName).andLevelEqualTo("1");
                columnList = columnMapper.selectByExample(example1);
                if (columnList.isEmpty()) {
                    log.info(String.format("资源 %s  没有找到",resourceName));
                    return;
                }
            }

            sql.append(System.lineSeparator());
            sql.append("-- " + CreateSQLTableEnum.getIndexByResource(resourceName) + "." + CreateSQLTableEnum.getTableNameByResource(resourceName));
            sql.append(System.lineSeparator());
            sql.append("create table if not exists ").append(CreateSQLTableEnum.getNameByResource(resourceName))
                    .append( "(") .append(System.lineSeparator());

            columnList.stream().forEach(column -> {
                String type = "";
                if (StringUtils.isBlank(column.getType())){
                    type = "STRING";
                } else if (column.getType().indexOf("DATE") > 0
                        || column.getType().indexOf("date") > 0
                        || column.getType().indexOf("TIME") > 0
                        || column.getType().indexOf("time") > 0 ){
                    type = "TIMESTAMP ";
                } else if (column.getType().indexOf("INT") > 0
                        || column.getType().indexOf("FLOAT") > 0
                        || column.getType().indexOf("int") > 0
                        || column.getType().indexOf("NUMBER") > 0
                        || column.getType().indexOf("numeric") > 0){
                    type = "INT";
                } else {
                    type = "STRING";
                }
                String des = column.getDes();
                if (StringUtils.isBlank(des) || "null".equals(des)){
                    des = "";
                }
                sql.append("  ").append(column.getName()).append(" ").append(type).append(" comment '").append(des).append("',");
                sql.append(System.lineSeparator());
            });
            sql.deleteCharAt(sql.length()-3);

            sql.append(")").append(System.lineSeparator());
            sql.append("row format delimited").append(System.lineSeparator());
            sql.append("fields terminated by '\\t'").append(System.lineSeparator());
            sql.append("lines terminated by '\\n';").append(System.lineSeparator());
        });



        log.info(sql.toString());


        return "SUCCESS";
    }
}