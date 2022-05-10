package com.hwd.study.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap 的使用
 */
public class Study14_ConcurrentHashMap {

    public static void main(String[] args) {
        Map<String, String> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("key", "value");

    }
}
