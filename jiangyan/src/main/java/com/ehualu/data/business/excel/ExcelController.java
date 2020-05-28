package com.ehualu.data.business.excel;

import com.ehualu.data.business.excel.model.InfoBean;
import com.ehualu.data.business.excel.model.JsonBean;
import com.ehualu.data.business.excel.service.*;
import com.ehualu.data.business.excel.test.Entity;
import com.ehualu.data.business.excel.test.TestParam;
import com.ehualu.data.business.excel.test.bean;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author created by guanchen on 2020/5/20 15:48
 */
@RestController
@Slf4j
public class ExcelController {

    @Autowired
    private ExcelService excelService;
    @Autowired
    private ExcelResourceService excelResourceService;
    @Autowired
    private TableService tableService;
    @Autowired
    private ExcelExportService exportService;
    @Autowired
    private JsonResourceService jsonResourceService;

    @SneakyThrows
    @PostMapping("doExcel")
    public String doExcel(){
        File file = new File("D:\\数据项整理.xls");
        tableService.addData(
                excelResourceService.readExcel(new FileInputStream(file.getPath()),file.getName()));
        return "SUCCESS";
    }

    @PostMapping("doExcel1")
    public String doExcel1(){
        jsonResourceService.readJson();
        return "SUCCESS";
    }

    @SneakyThrows
    @GetMapping("export")
    public String export(String path,int pageNum,int pageSize){
        FileOutputStream fout = new FileOutputStream(path);
        exportService.doExport(fout,pageNum,pageSize);
        return "SUCCESS";
    }

    @PostMapping("test")
    public TestParam test(@RequestBody TestParam param){
        log.info(param.toString());
        List<bean> list = new ArrayList<>();
        bean a = new bean("aaa");
        bean b = new bean("bbb");
        bean c = new bean("ccc");
        list.add(a);
        list.add(b);
        list.add(c);
        Entity e = new Entity();
        e.setList(list);


        List<bean> list1 = new ArrayList<>();
        bean a1 = new bean("aaa1");
        bean b1 = new bean("bbb1");
        bean c1 = new bean("ccc1");
        list1.add(a1);
        list1.add(b1);
        list1.add(c1);
        Entity e1 = new Entity();
        e1.setList(list1);

        List<Entity> entities = new ArrayList<>();
        entities.add(e);
        entities.add(e1);
        param.setList(entities);
        return param;
    }
}
