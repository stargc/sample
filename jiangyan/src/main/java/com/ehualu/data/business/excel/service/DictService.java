package com.ehualu.data.business.excel.service;

import com.ehualu.data.business.resource.dao.DictMapper;
import com.ehualu.data.business.resource.dao.DictTestMapper;
import com.ehualu.data.business.resource.model.Dict;
import com.ehualu.data.business.resource.model.DictTest;
import com.ehualu.data.business.resource.model.DictTestExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author created by guanchen on 2020/6/10 18:29
 */
@Service
@Slf4j
public class DictService {

    @Autowired
    private DictMapper dictMapper;
    @Autowired
    private DictTestMapper dictTestMapper;

    public void doDict(){
        DictTestExample testExample = new DictTestExample();
        List<DictTest> testList = dictTestMapper.selectByExampleWithBLOBs(testExample);

        testList.stream().forEach(test -> {
            Map<String,String> dictMap = getDictMap(test.getText());
            dictMap.forEach((k,v) -> {
                Dict dict = new Dict();
                dict.setTableName(test.getTableName());
                dict.setDictGroupName(test.getDictGroupName());
                dict.setDictGroupCode(test.getDictGroupCode());
                dict.setDictCode(k);
                dict.setDictValue(v);
                dictMapper.insert(dict);
            });
        });
    }

    private Map<String,String> getDictMap(String str){
        List<String> list = Arrays.asList(str.split(""));
        Map<String,String> dict = new LinkedHashMap<>();
        StringBuilder code = new StringBuilder();
        StringBuilder value = new StringBuilder();
        AtomicBoolean start = new AtomicBoolean(false);
        list.stream().forEach(s -> {
            if (isNumberAndEngilish(s)){
                if (start.get()){
                    dict.put(code.toString(),value.toString());
                    code.delete( 0, code.length());
                    value.delete( 0, value.length());
                    start.set(false);
                }
                code.append(s);
            } else {
                start.set(true);
                value.append(s);
            }

        });
        dict.put(code.toString(),value.toString());
        code.delete( 0, code.length());
        value.delete( 0, value.length());
        start.set(false);

        return dict;
    }

    private boolean isNumberAndEngilish(String str){
        String regEx = "^[A-Za-z0-9]{1}";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }
}
