package com.hwd.study.collection;

import com.hwd.study.collection.pojo.Teacher;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * HashMap 的使用，接口Map的实现类
 *
 * 储存结构：数组+链表+红黑树
 */
public class Study11_HashMap {

    public static void main(String[] args) {
        // 创建集合
        HashMap<Teacher, String> teachers = new HashMap<>();
        Teacher t1 = new Teacher("郭富城", 56);
        Teacher t2 = new Teacher("黎明", 57);
        Teacher t3 = new Teacher("张学友", 58);
        Teacher t4 = new Teacher("刘德华", 59);
        // 添加元素
        teachers.put(t1, "香港");
        teachers.put(t2, "香港");
        teachers.put(t3, "台湾");
        teachers.put(t4, "上海");
        teachers.put(t4, "广州");
        System.out.println("元素的个数："+teachers.size());
        System.out.println(teachers.toString());
        // 遍历
        System.out.println("使用keySet()遍历");
        Set<Teacher> keySet = teachers.keySet();
        for (Teacher t: keySet) {
            System.out.println(t.toString() + ":" + teachers.get(t));
        }

        System.out.println("使用enTrySet()遍历");
        Set<Map.Entry<Teacher, String>> entrySet = teachers.entrySet();
        for (Map.Entry<Teacher, String> entry: entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // 判断
        System.out.println(teachers.containsKey(t1));
        System.out.println(teachers.containsValue("上海"));
    }
}
