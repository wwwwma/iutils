package com.wei.iutils.exception;

import com.wei.iutils.exception.vo.IException;

public class Assert {

    public static void isTrue(boolean b, String message) {
        if (!b) throw new IException(message);
    }

    public static void isFalse(boolean b, String message) {
        isTrue(!b,message);
    }
}
