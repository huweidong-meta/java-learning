package com.hwd.study.collection;

import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList 是 List接口的实现类
 * 存储结构：双向链表【增删快，查找遍历慢】
 */
public class Study5_LinkedList {

    public static void main(String[] args) {
        // 创建集合
        List linkedList = new LinkedList();

        // 1、添加元素
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");
        System.out.println("元素个数："+ linkedList.size());
        System.out.println(linkedList.toString());

        // 2、删除元素
        linkedList.remove("e");
        System.out.println("删除后元素个数："+ linkedList.size());
        System.out.println(linkedList.toString());

        // 3、遍历
        System.out.println("可以使用for循环遍历。");
        System.out.println("可以使用增强for遍历。");
        System.out.println("可以使用迭代器遍历。");
        System.out.println("可以使用列表迭代器从前往后。");
        System.out.println("可以使用列表迭代器从后往前。");

        // 4、判断
        System.out.println(linkedList.contains("b"));
        System.out.println(linkedList.isEmpty());

    }
}
