package com.ehualu.data.business.excel.service;

import com.ehualu.data.business.resource.dao.ColumnMapper;
import com.ehualu.data.business.resource.dao.TableMapper;
import com.ehualu.data.business.resource.model.Column;
import com.ehualu.data.business.resource.model.ColumnExample;
import com.ehualu.data.business.resource.model.Table;
import com.ehualu.data.business.resource.model.TableExample;
import com.ehualu.data.common.util.DesensitizedUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author created by guanchen on 2020/5/21 17:52
 */
@Service
@Slf4j
public class ExcelExportService {
    @Autowired
    private TableMapper tableMapper;
    @Autowired
    private ColumnMapper columnMapper;

    @SneakyThrows
    public void doExport(FileOutputStream fout,int pageNum,int pageSize) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        createSummaryTable(workbook,pageNum,pageSize);
        workbook.write(fout);
        workbook.close();
    }

    private void createSummaryTable(HSSFWorkbook workbook,int pageNum,int pageSize) {
        TableExample tableExample = new TableExample();
        tableExample.createCriteria().andLevelEqualTo("1");
        int start = (pageNum -1 ) * pageSize;
        tableExample.setStartRow(start);
        tableExample.setPageSize(pageSize);

        List<Table> tables = tableMapper.selectByExample(tableExample);
        HSSFSheet sheet = workbook.createSheet("概览信息");
        String[] headers = {"序号", "表名称", "数据量", "数据来源系统", "数据来源方式", "表中文名称"
                , "自增字段", "主键字段"};
        addHeader(sheet, headers);

        AtomicInteger rowIndex = new AtomicInteger(1);
        tables.forEach(table -> {
            log.info("export table == " + table.getResourceName());
            HSSFRow row = sheet.createRow(rowIndex.get());
            AtomicInteger cellIndex = new AtomicInteger(0);
            setCellValue(row.createCell(cellIndex.getAndIncrement()), rowIndex.get());
            setCellValue(row.createCell(cellIndex.getAndIncrement()), table.getResourceName());
            setCellValue(row.createCell(cellIndex.getAndIncrement()), table.getCount());
            rowIndex.getAndIncrement();

            ColumnExample columnExample = new ColumnExample();
            columnExample.createCriteria().andResourceNameEqualTo(table.getResourceName()).andLevelEqualTo("1");
            List<Column> columnList = columnMapper.selectByExample(columnExample);
            addColumnInfo(workbook,table,columnList);
        });
    }

    private void addHeader(HSSFSheet sheet, String[] headers) {
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
    }

    private void addColumnHeader(HSSFSheet sheet) {
        HSSFRow row = sheet.createRow(0);
        String[] headers = {"字段名称", "中文字段名称", "数据类型", "字典编码", "样例数据1", "样例数据2"
                , "样例数据3"};
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
    }

    private void addColumnInfo(HSSFWorkbook workbook,Table table,List<Column> columnList){
        String resourceName = StringUtils.isBlank(table.getResourceName()) ? table.getResourceTableName() : table.getResourceName();
        HSSFSheet sheet = workbook.createSheet(DesensitizedUtils.replaceSymbol(resourceName));
        addColumnHeader(sheet);
        AtomicInteger rowIndex = new AtomicInteger(1);
        columnList.forEach(column -> {
            HSSFRow row = sheet.createRow(rowIndex.get());
            AtomicInteger cellIndex = new AtomicInteger(0);
            setCellValue(row.createCell(cellIndex.getAndIncrement()), column.getName());
            setCellValue(row.createCell(cellIndex.getAndIncrement()), column.getDes());
            setCellValue(row.createCell(cellIndex.getAndIncrement()), column.getType() + "(" + column.getLength()+")");
            setCellValue(row.createCell(cellIndex.getAndIncrement()), column.getDictGroupName());
            setCellValue(row.createCell(cellIndex.getAndIncrement()), column.getSampleData1());
            setCellValue(row.createCell(cellIndex.getAndIncrement()), column.getSampleData2());
            setCellValue(row.createCell(cellIndex.getAndIncrement()), column.getSampleData3());
            rowIndex.getAndIncrement();
        });
    }

    private void setCellValue(Cell cell, Object value) {
        if (value instanceof Date) {
            cell.setCellValue(DateFormatUtils.format((Date) value, "YYYY-MM-dd"));
        } else if (value instanceof Float) {
            cell.setCellValue(((Float) value).floatValue());
        } else if (value instanceof Double) {
            cell.setCellValue(((Double) value).doubleValue());
        } else if (value instanceof Integer) {
            cell.setCellValue(((Integer) value).intValue());
        } else if (value instanceof Long) {
            cell.setCellValue(((Long) value).longValue());
        } else {
            if (StringUtils.isBlank((String) value)) {
                cell.setCellValue("");
            } else {
                cell.setCellValue((String) value);
            }
        }
    }


}
