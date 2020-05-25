package com.ehualu.data.common.util;

import org.apache.commons.lang3.StringUtils;


/**
 * @Title: DesensitizedUtils
 */
public class DesensitizedUtils {

    /**
     * 【中文姓名】只显示第一个汉字，其他隐藏为2个星号，比如：李**
     *
     * @param fullName
     * @return
     */
    public static String chineseName(String fullName) {
        if (StringUtils.isBlank(fullName)) {
            return "";
        }
        String name = StringUtils.left(fullName, 1);
        return StringUtils.rightPad(name, StringUtils.length(fullName), "*");
    }

    /**
     * 【身份证号】显示最后四位，其他隐藏。共计18位或者15位，比如：120100*********000
     *
     * @param id
     * @return
     */
    public static String idCardNum(String id) {
        if (StringUtils.isBlank(id)) {
            return "";
        }
        String start = StringUtils.left(id, 6);
        int num = id.length() - 3;
        String end = StringUtils.right(id,3);
        return StringUtils.rightPad(start,num, "*").concat(end);
    }

    /**
     * 【固定电话 后四位，其他隐藏，比如1234
     *
     * @param num
     * @return
     */
    public static String fixedPhone(String num) {
        if (StringUtils.isBlank(num)) {
            return "";
        }
        return StringUtils.leftPad(StringUtils.right(num, 4), StringUtils.length(num), "*");
    }

    /**
     * 【手机号码】前三位，后四位，其他隐藏，比如135******10
     *
     * @param num
     * @return
     */
    public static String mobilePhone(String num) {
        if (StringUtils.isBlank(num)) {
            return "";
        }
        return StringUtils.left(num, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(num, 4), StringUtils.length(num), "*"), "***"));
    }


    /**
     * 【地址】只显示到地区，不显示详细地址，比如：北京市海淀区****
     *
     * @param address
     * @param sensitiveSize 展示信息长度
     * @return
     */
    public static String address(String address, int sensitiveSize) {
        if (StringUtils.isBlank(address)) {
            return "";
        }
        int length = StringUtils.length(address);
        return StringUtils.rightPad(StringUtils.left(address, sensitiveSize), length, "*");
    }

    /**
     * 【电子邮箱 邮箱前缀仅显示第一个字母，前缀其他隐藏，用星号代替，@及后面的地址显示，比如：d**@126.com>
     *
     * @param email
     * @return
     */
    public static String email(String email) {
        if (StringUtils.isBlank(email)) {
            return "";
        }
        int index = StringUtils.indexOf(email, "@");
        if (index <= 1) {
            return email;
        } else {
            return StringUtils.rightPad(StringUtils.left(email, 1), index, "*").concat(StringUtils.mid(email, index, StringUtils.length(email)));
        }
    }
    /**
     * 【银行卡号】前六位，后四位，其他用星号隐藏每位1个星号，比如：6222600**********1234>
     *
     * @param cardNum
     * @return
     */
    public static String bankCard(String cardNum) {
        if (StringUtils.isBlank(cardNum)) {
            return "";
        }
        return StringUtils.left(cardNum, 6).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(cardNum, 4), StringUtils.length(cardNum), "*"), "******"));
    }

    /**
     * 【密码】密码的全部字符都用*代替，比如：******
     *
     * @param password
     * @return
     */
    public static String password(String password) {
        if (StringUtils.isBlank(password)) {
            return "";
        }
        String pwd = StringUtils.left(password, 0);
        return StringUtils.rightPad(pwd, StringUtils.length(password), "*");
    }

    /**
     * 【车牌号】前两位后一位，比如：苏M****5
     *
     * @param carNumber
     * @return
     */
    public static String carNumber(String carNumber) {
        if (StringUtils.isBlank(carNumber)) {
            return "";
        }
        return StringUtils.left(carNumber, 2).
                concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(carNumber, 1), StringUtils.length(carNumber), "*"), "**"));

    }
    /**
     * 长字符传 脱敏。 保留前200个字符
     *
     * @param bigText
     * @return
     */
    public static String bigText(String bigText) {
        if (StringUtils.isBlank(bigText)) {
            return "";
        }
        if (bigText.length() < 200) return bigText;
        String text = StringUtils.left(bigText, 200);
        return text.concat("***");
    }

    public static String desensitized(String str){
        if (StringUtils.isBlank(str)) return str;
        if (str.length() > 9){
            String start = StringUtils.left(str, 6);
            int num = str.length() - 3;
            String end = StringUtils.right(str,3);
            return StringUtils.rightPad(start,num, "***").concat(end);
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(bigText("15122201963"));
        System.out.println(bigText("我局在侦查施全雷控告朱某职务侵占、挪用资金案中发现，在2014年8月29日农武安置小区二期土建工程招标过程中朱雨兴、施全雷同时挂靠三家公司进行投标，并共同筹措缴纳三家投标公司保证金每家580万元，最终由二人挂靠的江苏荣泽建筑工程有限公司中标。朱雨兴、施全雷涉嫌串通投标罪。我局在侦查施全雷控告朱某职务侵占、挪用资金案中发现，在2014年8月29日农武安置小区二期土建工程招标过程中朱雨兴、施全雷同时挂靠三家公司进行投标，并共同筹措缴纳三家投标公司保证金每家580万元，最终由二人挂靠的江苏荣泽建筑工程有限公司中标。朱雨兴、施全雷涉嫌串通投标罪。"));
    }
}

