package com.hwd.study.collection.generics;

/**
 * 实现的时候指定类型
 */
public class MyGenericsImpl implements MyGenericsInterface<String> {

    @Override
    public String get(String s) {
        System.out.println(s);
        return s;
    }
}
