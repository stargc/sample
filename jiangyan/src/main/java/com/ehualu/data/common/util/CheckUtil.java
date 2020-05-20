package com.ehualu.data.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author created by guanchen on 2020/4/3 12:12
 */
public class CheckUtil {


    public static boolean isPhone(String str) {
        if (StringUtils.isBlank(str)) return true;
        Pattern pat = Pattern.compile("^[1][345678][0-9]{9}$");
        Matcher mat = pat.matcher(str);
        return mat.find();
    }

    public static boolean isIdNum(String str) {
        if (StringUtils.isBlank(str)) return true;
        Pattern pat = Pattern.compile("(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)");
        Matcher mat = pat.matcher(str);
        return mat.find();
    }
}
