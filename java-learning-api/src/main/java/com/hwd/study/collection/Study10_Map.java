package com.hwd.study.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map 接口的使用
 * 特点：1、存储健值队   2、 健不能重复    3、无序
 */
public class Study10_Map {

    public static void main(String[] args) {
        //  创建Map集合
        Map<String, String> map = new HashMap();
        //  1、添加元素
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        map.put("d","4");
        map.put("a","5");
        System.out.println("元素的个数："+ map.size());
        System.out.println(map.toString());

        //  2、删除元素
        map.remove("d");
        System.out.println("元素的个数："+ map.size());
        System.out.println(map.toString());

        //  3、遍历
        System.out.println("使用keySet()遍历");
//        Set<String> keySet = map.keySet();
        for (String s: map.keySet()) {
            System.out.println(s + ":" + map.get(s));
        }

        System.out.println("使用entrySet()遍历");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
