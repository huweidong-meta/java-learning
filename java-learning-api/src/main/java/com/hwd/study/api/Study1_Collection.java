package com.hwd.study.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection 接口的使用
 * 1、添加元素
 * 2、删除元素
 * 3、遍历元素
 * 4、判断
 */
public class Study1_Collection {

    public static void main(String[] args) {
        // 创建集合
        Collection collection = new ArrayList();//可实例化的对象

        // 1、添加元素
        collection.add("java");
        collection.add("C");
        collection.add("C++");
        collection.add("python");
        collection.add("go");
        System.out.println("添加元素后的集合：" + collection);

        // 2、删除元素
        collection.remove("go");
        System.out.println("删除元素后的集合：" + collection);

        // 4、判断
        System.out.println("判断集合中是否包含java：" + collection.contains("java"));
        System.out.println("判断集合中是否包含go：" + collection.contains("go"));
        System.out.println("判断集合是否为空：" + collection.isEmpty());

        // 3、遍历元素
        System.out.println("使用增强for循环遍历元素：");
        for (Object obj : collection) {
            System.out.println(obj);
        }

        System.out.println("使用迭代器遍历元素：");
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){ // 如果仍有元素可以迭代返回true
            String str = (String) iterator.next(); // 返回迭代的下一个元素
            System.out.println(str);
//            ConcurrentModificationException：使用迭代器时不能使用集合的删除方法否则发生 并发修改异常
//            collection.remove(str);
//            要使用迭代器提供的删除方法
            iterator.remove();
        }

        System.out.println("使用迭代器删除之后的元素的大小：" + collection.size());
        System.out.println("判断集合是否为空：" + collection.isEmpty());
    }

}
