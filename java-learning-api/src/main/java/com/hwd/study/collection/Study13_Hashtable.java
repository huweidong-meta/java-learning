package com.hwd.study.collection;

import java.util.Hashtable;
import java.util.Map;

/**
 * Hashtable 的使用，接口Map的实现类
 *
 * 使用同 HashMap 一样，不同之处在于 Hashtable 方法都加了关键字synchronized
 *
 */
public class Study13_Hashtable {

    public static void main(String[] args) {
        // 创建集合
        Map<String, String> hashtable = new Hashtable<>();
        hashtable.put("a","a");
/*
        HashMap、Hashtable的存储结构都是哈希表。
        区别是
        (1)HashMap是线程不安全的，Hashtable是线程安全的；
        (2)两者继承的父类不同；
        (3)put方法HashMap允许key和value为null，如果key为null计算的下标是0，Hashtable中key和value都不允许为null，如果传null会报空指针异常；
        (4)Hashtable默认容量是11，调用构造方法的时候就初始化了数组，HashMap默认容量是16，且put第一个元素的时候才进行初始化；
        (5)达到阈值时HashMap每次扩容为原来的2倍，Hashtable每次扩容为原来的2倍+1；
 */
    }

}

