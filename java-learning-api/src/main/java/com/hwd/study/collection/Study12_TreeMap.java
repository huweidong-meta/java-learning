package com.hwd.study.collection;

import com.hwd.study.collection.pojo.Person;
import com.hwd.study.collection.pojo.Teacher;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * TreeMap 的使用
 *
 * 1.Comparable:
 * 集合的使用要求元素实现接口Comparable，否则会报异常 java.lang.ClassCastException
 *
 * 2.Comparator:
 * 也可以使用比较器实现定制比较
 */
public class Study12_TreeMap {

    public static void main(String[] args) {
        // 1.Comparable:
        // 创建集合
        TreeMap<Person, Integer> treeMap = new TreeMap();
        // 添加元素
        Person p1 = new Person("c", 20);
        Person p2 = new Person("a", 30);
        Person p3 = new Person("b", 10);
        treeMap.put(p1, 3);
        treeMap.put(p2, 1);
        treeMap.put(p3, 2);
        System.out.println("元素的个数为："+ treeMap.size());
        System.out.println(treeMap.toString());
        // 删除元素
        treeMap.remove(p1);
        System.out.println("元素的个数为："+ treeMap.size());
        System.out.println(treeMap.toString());

        System.out.println("使用keySet()遍历");
        Set<Person> keySet = treeMap.keySet();
        for (Person t: keySet) {
            System.out.println(t.toString() + ":" + treeMap.get(t));
        }

        System.out.println("使用enTrySet()遍历");
        Set<Map.Entry<Person, Integer>> entrySet = treeMap.entrySet();
        for (Map.Entry<Person, Integer> entry: entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // 判断
        System.out.println(treeMap.containsKey(p2));
        System.out.println(treeMap.containsValue(1));



        // 2.Comparator:
        // 创建集合
        TreeMap<Teacher, Integer> treeMapComparator = new TreeMap(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher t1, Teacher t2) {
                // 先比较年龄再比较名字
                int r1 = t1.getAge().compareTo(t2.getAge());
                int r2 = t1.getName().compareTo(t2.getName());
                return r1 == 0 ? r2 : r1;
            }
        });
        Teacher t1 = new Teacher("c", 20);
        Teacher t2 = new Teacher("a", 30);
        Teacher t3 = new Teacher("b", 10);
        treeMapComparator.put(t1, 20);
        treeMapComparator.put(t2, 30);
        treeMapComparator.put(t3, 10);
        System.out.println("元素的个数为："+ treeMapComparator.size());
        System.out.println(treeMapComparator.toString());
    }
}
