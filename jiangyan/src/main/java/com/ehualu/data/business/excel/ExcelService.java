package com.ehualu.data.business.excel;

import com.alibaba.fastjson.JSONObject;
import com.ehualu.data.common.util.CheckUtil;
import com.ehualu.data.common.util.DesensitizedUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author created by guanchen on 2020/5/18 17:46
 */

@Service
public class ExcelService {
    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";

    /**
     * 读取Excel文件内容
     *
     * @param fileName 要读取的Excel文件所在路径
     * @return 读取结果列表，读取失败时返回null
     */
    public Workbook fillExcel(InputStream inputStream, String fileName, FileOutputStream fout) {

        Workbook workbook = null;

        try {
            // 获取Excel后缀名
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            workbook = getWorkbook(inputStream, fileType);

            // 读取excel中的数据
            for (int j = 0; j < 55; j++) {
                Sheet sheet = workbook.getSheetAt(j);
                System.out.println("do ==" + sheet.getSheetName());
                Map<String, Integer> map = getRowNumberMap(sheet);
                String json = getValue(sheet);
                if (StringUtils.isBlank(json)) continue;
                Bean bean = JSONObject.parseObject(json, Bean.class);
                AtomicInteger i = new AtomicInteger();
                Map<String, Integer> finalMap = map;
                bean.getData().forEach(data -> {
                    if (i.get() > 3) return;
                    data.forEach((k, v) -> {
                        Integer rowNumber = finalMap.get(k);
                        if (rowNumber == null || rowNumber < 0) {
                            return;
                        }
                        Row row = sheet.getRow(rowNumber);
                        Cell cell = row.createCell(i.get() + 2);
                        if (CheckUtil.isPhone(v)) {
                            v = DesensitizedUtils.mobilePhone(v);
                        } else if (CheckUtil.isIdNum(v)) {
                            v = DesensitizedUtils.idCardNum(v);
                        }
                        cell.setCellValue(new HSSFRichTextString(v));
                    });
                    i.getAndIncrement();
                });

                System.out.println("done == ");
            }

            workbook.write(fout);
        } catch (Exception e) {
            System.out.println(ExceptionUtils.getStackTrace(e));
        } finally {
            try {
                if (null != workbook) {
                    workbook.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
                if (null != fout) {
                    fout.close();
                }
            } catch (Exception e) {
                System.out.println("关闭数据流出错！错误信息：" + e.getMessage());
            }
        }
        return workbook;
    }

    /**
     * 根据文件后缀名类型获取对应的工作簿对象
     *
     * @param inputStream 读取文件的输入流
     * @param fileType    文件后缀名类型（xls或xlsx）
     * @return 包含文件数据的工作簿对象
     * @throws IOException
     */
    private Workbook getWorkbook(InputStream inputStream, String fileType) throws IOException {
        Workbook workbook = null;
        if (fileType.equalsIgnoreCase(XLS)) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (fileType.equalsIgnoreCase(XLSX)) {
            workbook = new XSSFWorkbook(inputStream);
        }
        return workbook;
    }

    public String getValue(Sheet sheet) {
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(2);
        if (cell == null) return null;
        return cell.getStringCellValue();
    }

    public Map<String, Integer> getRowNumberMap(Sheet sheet) {

        // 获取第一行数据
        int firstRowNum = sheet.getFirstRowNum();
        Row firstRow = sheet.getRow(firstRowNum);
        if (null == firstRow) {
            return Collections.emptyMap();
        }
        // 解析每一行的数据，构造数据对象
        int rowStart = firstRowNum;
        int rowEnd = sheet.getPhysicalNumberOfRows();
        Map<String, Integer> map = new HashMap<>();
        for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
            Row row = sheet.getRow(rowNum);

            if (row != null && row.getCell(1) != null) {
                map.put(row.getCell(1).getStringCellValue(), row.getRowNum());
            }
        }
        return map;
    }
}
