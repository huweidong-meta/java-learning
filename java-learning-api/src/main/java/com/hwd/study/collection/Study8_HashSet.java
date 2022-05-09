package com.hwd.study.collection;

import com.hwd.study.collection.pojo.Person;

import java.util.HashSet;

/**
 * HashSet集合的使用
 * 储存结构：哈希表（数组列表+链表+红黑树1.8开始）
 * 储存过程：
 * 1、根据hashcode计算保存的位置，如果位置为空直接保存，如果不为空执行第二步
 * 2、再执行equals方法，如果equals方法为true，则为重复，否则形成链表
 */
public class Study8_HashSet {

    public static void main(String[] args) {
        // 创建集合，添加元素
        HashSet<Person> hashSet = new HashSet<>();
        Person s1 = new Person("小明", 20);
        Person s2 = new Person("小红", 21);
        Person s3 = new Person("小李", 22);
        Person s4 = new Person("小张", 23);
        hashSet.add(s1);
        hashSet.add(s2);
        hashSet.add(s3);
        hashSet.add(s4);
        System.out.println(hashSet.size());
        System.out.println(hashSet);

        // 根据 HashSet 的存储过程，重写了hashcode与equals方法，才能保证不重复
        hashSet.add(new Person("小张", 23));
        System.out.println(hashSet.size());
        System.out.println(hashSet);
    }
}
