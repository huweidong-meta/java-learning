package com.hwd.study.api.generics;

/**
 * 实现类也做成泛型
 * @param <T>
 */
public class MyGenericsImpl2<T> implements MyGenericsInterface<T> {
    @Override
    public T get(T t) {
        System.out.println(t);
        return t;
    }
}
