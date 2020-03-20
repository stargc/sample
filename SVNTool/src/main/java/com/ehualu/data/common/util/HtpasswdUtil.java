package com.ehualu.data.common.util;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.net.URL;

/**
 * @author created by guanchen on 2020/3/17 17:10
 */
@Slf4j
public class HtpasswdUtil {
    private static HtpasswdUtil mInstance;
    private static ScriptEngine script;
    private static final String JS_PATH = "static/js/htpasswd.js";

    @SneakyThrows
    private HtpasswdUtil(){
        URL xmlpath = this.getClass().getClassLoader().getResource(JS_PATH);
        System.out.println(xmlpath);
        ScriptEngineManager manager = new ScriptEngineManager();
        script = manager.getEngineByName("javascript");
        FileReader reader = new FileReader(xmlpath.getPath());
        script.eval(reader);//执行js,但是可能文件中有多个函数
    }

    public static HtpasswdUtil getInstance(){
        if (mInstance == null) {
            mInstance = new HtpasswdUtil();
        }
        return mInstance;
    }

    public String getHtpasswd(String userName,String password){
        String result = "";
        if (script instanceof Invocable) {
            Invocable invoke = (Invocable) script;
            try {
                result = (String) invoke.invokeFunction("htpasswd", userName, password, 2);//执行js文件中的指定函数
            } catch (ScriptException e) {
                log.error(ExceptionUtils.getStackTrace(e));
            } catch (NoSuchMethodException e) {
                log.error(ExceptionUtils.getStackTrace(e));
            }
        }
        return result;
    }
}

