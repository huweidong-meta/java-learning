package com.hwd.study.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set 是 Collection 的子接口
 * 特点：1、无序，没有下标 2、不能重复
 */
public class Study7_Set {

    public static void main(String[] args) {
        // 创建集合
        Set<String> set = new HashSet<>();

        // 1、添加元素
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        System.out.println(set);
        System.out.println("元素的个数："+ set.size());
        System.out.println(set);

        // 2、删除
        set.remove("d");
        System.out.println("元素的个数："+ set.size());
        System.out.println(set);

        // 3、增强for遍历
        System.out.println("增强for遍历:");
        for (String s: set) {
            System.out.println(s);
        }

        // 4、迭代器遍历
        System.out.println("迭代器遍历:");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // 5、判断
        System.out.println(set.contains("a"));
        System.out.println(set.isEmpty());
    }
}
