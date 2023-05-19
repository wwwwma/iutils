package com.wei.iutils.string;

public class IStringUtils extends org.apache.commons.lang3.StringUtils{

    /**
     * 非空判断
     * @param s 判断字符串
     */
    public static boolean notEmpty(String s) {
        return null != s && !s.trim().equals("");
    }

    /**
     *  去除空格
     * @param s 目标字符串
     */
    public static String trim(String s)
    {
        return (s == null ? "" : s.trim());
    }

    /**
     * 如果字符串为空就替换成默认字符串
     * @param s 目标字符串
     * @param defaultStr 默认字符串
     */
    public static String emptyToDefaultStr(String s, String defaultStr) {
        return notEmpty(s) ? s : defaultStr;
    }

}
