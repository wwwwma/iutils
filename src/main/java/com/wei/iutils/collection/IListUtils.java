package com.wei.iutils.collection;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class IListUtils {

    /**
     * 获取集合中对象的某一个属性的集合
     * @param list 参数集合
     * @param action 具体执行方法
     * @param <I> 参数类型
     * @param <T> 目标类型
     * @return 目标类型集合
     */
    public static <I,T> List<T> attributeList(List<I> list, Function<I,T> action){
        ArrayList<T> res = new ArrayList<>();
        if (null == list || list.size() == 0) return res;
        for (I o : list) {
            if (o != null) res.add(action.apply(o));
        }
        return res;
    }

    public static <I,T> Set<T> attributeSet(List<I> list, Function<I,T> action){
        Set<T> res = new HashSet<>();
        if (null == list || list.size() == 0) return res;
        for (I o : list) {
            if (o != null) res.add(action.apply(o));
        }
        return res;
    }

//    public static <T,R extends Comparable<R>> boolean attributeContain(List<T> list, Function<T,Boolean> action){
//
//    }

}
