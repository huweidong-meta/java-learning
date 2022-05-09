package com.hwd.study.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Set 是 Collection 的子接口
 * 特点：1、无序，没有下标 2、不能重复
 */
public class Study7_Set {

    public static void main(String[] args) {
        // 创建集合，添加元素
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        System.out.println(set);
        // 和List使用一致
        // 删除
        // 增强for遍历
        // 迭代器遍历
        // 判断
    }
}
