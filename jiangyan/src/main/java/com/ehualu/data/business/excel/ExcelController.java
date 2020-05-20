package com.ehualu.data.business.excel;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author created by guanchen on 2020/5/20 15:48
 */
@RestController
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @SneakyThrows
    @PostMapping("add")
    public String doExcel(){
        File file = new File("D:\\数据项整理.xls");
        FileOutputStream fout = new FileOutputStream("D:\\数据项整理1.xls");
        excelService.fillExcel(new FileInputStream(file.getPath()),file.getName(),fout);
        return "SUCCESS";
    }
}
