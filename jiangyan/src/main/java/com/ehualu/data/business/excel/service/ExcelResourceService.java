package com.ehualu.data.business.excel.service;

import com.alibaba.fastjson.JSONObject;
import com.ehualu.data.business.excel.model.InfoBean;
import com.ehualu.data.business.excel.model.SampleBean;
import com.ehualu.data.business.excel.model.TableInfoBean;
import com.ehualu.data.common.util.CheckUtil;
import com.ehualu.data.common.util.DesensitizedUtils;
import lombok.extern.slf4j.Slf4j;
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
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author created by guanchen on 2020/5/18 17:46
 */

@Service
@Slf4j
public class ExcelResourceService {
    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";

    /**
     * 读取Excel文件内容
     *
     * @param fileName 要读取的Excel文件所在路径
     * @return 读取结果列表，读取失败时返回null
     */
    public List<TableInfoBean> readExcel(InputStream inputStream, String fileName) {
        List<TableInfoBean> result = new ArrayList<>();
        Workbook workbook = null;
        try {
            // 获取Excel后缀名
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            workbook = getWorkbook(inputStream, fileType);
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                // 读取excel中的数据
                Sheet sheet = workbook.getSheetAt(i);
                log.info("do ==" + sheet.getSheetName());
                String infoStr = getInfoValue(sheet);
                String sampleStr = getSampleValue(sheet);

                if ("警务基础平台接警信息表".equals(sheet.getSheetName())){
                    log.debug("test");
                }
                InfoBean info = JSONObject.parseObject(infoStr, InfoBean.class);
                if (StringUtils.isNotBlank(sampleStr)) {
                    SampleBean sample = JSONObject.parseObject(sampleStr, SampleBean.class);
                    info.getData().setSampleData(sample.getData());
                }
                result.add(info.getData());
            }
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return Collections.emptyList();
        } finally {
            try {
                if (null != workbook) {
                    workbook.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (Exception e) {
                log.error("关闭数据流出错！错误信息：" + ExceptionUtils.getStackTrace(e));
            }
        }
        return result;
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

    public String getSampleValue(Sheet sheet) {
        Row row = sheet.getRow(2);
        if(row == null) return null;
        Cell cell = row.getCell(0);
        if (cell == null) return null;
        return cell.getStringCellValue();
    }

    public String getInfoValue(Sheet sheet) {
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i < 9; i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;
            Cell cell = row.getCell(0);
            if (cell == null) continue;
            sb.append(cell.getStringCellValue());

        }
        return sb.toString();
    }

}
