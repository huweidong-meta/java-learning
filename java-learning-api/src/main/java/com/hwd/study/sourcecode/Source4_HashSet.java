package com.hwd.study.sourcecode;

import java.util.HashSet;
import java.util.Set;

/**
 * 源码分析：HashSet
 *
 * HashSet 存储结构使用了HashMap
 *
 * 同样地
 * TreeSet 存储结构使用了TreeMap
 *
 */
public class Source4_HashSet {

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
/*
    创建 HashSet 的时候其实是new了一个 HashMap
        public HashSet() {
            this.map = new HashMap();
        }
*/

        hashSet.add("1");
/*
    添加元素的时候其实也是将元素当成map的key存入
        public boolean add(E e) {
            return this.map.put(e, PRESENT) == null;
        }
*/

    }
}
