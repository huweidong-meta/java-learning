package com.hwd.study.collection.generics;

/**
 * 泛型方法
 * 语法：<T>返回值类型
 */
public class MyGenericsMethod {

    /**
     * 泛型方法
     * @param t
     * @param <T>
     */
    public <T> void show(T t){
        System.out.println(t);
    }

    public <T> T show2(T t){
        System.out.println(t);
        return t;
    }

    public <T> T show3(T t){
        T t1 = t;
        System.out.println(t1);
        return t1;
    }
}
