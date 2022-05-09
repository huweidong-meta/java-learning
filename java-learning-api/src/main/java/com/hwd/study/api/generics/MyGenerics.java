package com.hwd.study.api.generics;

/**
 * 范型类
 * 语法：类名<T>
 * T是类型占位符，表示一种引用类型，如果编写多个用逗号隔开
 */
public class MyGenerics<T> {
    // 使用泛型
    /**
     * 1、创建变量
     */
    public T t;

    /**
     * 2、作为方法的参数
     * @param t
     */
    public void show(T t){
        System.out.println(t);
    }

    /**
     * 3、泛型作为方法的返回值
     * @return T
     */
    public T getT(){
        return t;
    }
}
