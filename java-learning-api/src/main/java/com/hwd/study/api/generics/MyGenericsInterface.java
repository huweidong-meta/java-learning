package com.hwd.study.api.generics;

/**
 * 泛型接口：
 * 语法：接口名<T>
 */
public interface MyGenericsInterface<T> {

    String name = "小小";

    T get(T t);
}
