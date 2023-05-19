package com.wei.iutils.exception;

import com.wei.iutils.exception.vo.IException;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class IAssert {

    public static void isTrue(boolean b, String message) {
        if (!b) throw new IException(message);
    }

    public static void isFalse(boolean b, String message) {
        isTrue(!b,message);
    }

    public static void notNull(Object o, String message) {
        if (null == o) throw new IException(message);
    }

    public static void notEmpty(Object o, String message) {
        if (null == o) throw new IException(message);
    }

    public static void notEmpty(List o, String message) {
        if (null == o || o.size() == 0) throw new IException(message);
    }

    public static void notEmpty(String o, String message) {
        if (null == o || o.trim().equals("")) throw new IException(message);
    }

    public static void notEmpty(Object[] o, String message) {
        if (null == o || o.length == 0) throw new IException(message);
    }

    public static void notEmpty(Map o, String message) {
        if (null == o || o.size() == 0) throw new IException(message);
    }


}
