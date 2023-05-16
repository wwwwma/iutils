package com.wei.iutils.array;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class IArrayUtils {

    /**
     * 获取对象数组中的某一个属性的数组类型
     * @param array 参数数组
     * @param target 目标类型数组
     * @param action 具体的执行方法
     * @param <I> 参数类型
     * @param <T> 目标类型
     * @return
     */
    public static <I,T> T[] attributeArray(I[] array, T[] target, Function<I,T> action){
        ArrayList<T> res = new ArrayList<>();
        if (null == array || array.length == 0) return res.toArray(target);
        for (I o : array) {
            if (o != null) res.add(action.apply(o));
        }
        return res.toArray(target);
    }


}
