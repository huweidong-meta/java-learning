package com.hwd.study.collection;

import com.hwd.study.collection.pojo.Person;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * TreeSet 集合的使用
 * 存储结构：红黑树
 *
 * 1.Comparable:
 * 集合的使用要求元素实现接口Comparable，否则会报异常 java.lang.ClassCastException
 *
 * 2.Comparator:
 * 也可以使用比较器实现定制比较
 */
public class Study9_TreeSet {

    public static void main(String[] args) {
        Person p1 = new Person("a", 36);
        Person p2 = new Person("d", 47);
        Person p3 = new Person("e", 59);
        Person p4 = new Person("d", 20);

        // 集合的使用要求元素实现接口Comparable
        TreeSet<Person> treeSetComparable = new TreeSet<>();
        treeSetComparable.add(p1);
        treeSetComparable.add(p2);
        treeSetComparable.add(p3);
        treeSetComparable.add(p4);
        System.out.println(treeSetComparable);

        // 也可以使用比较器实现定制比较
        TreeSet<Person> treeSetComparator = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                // 先比较年龄再比较名字
                int r1 = p1.getAge().compareTo(p2.getAge());
                int r2 = p1.getName().compareTo(p2.getName());
                return r1 == 0 ? r2 : r1;
            }
        });
        treeSetComparator.add(p1);
        treeSetComparator.add(p2);
        treeSetComparator.add(p3);
        treeSetComparator.add(p4);
        System.out.println(treeSetComparator);
    }
}
