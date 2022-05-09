package com.hwd.study.collection;

import com.hwd.study.collection.pojo.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * ArrayList 是 List 接口的实现类
 * 存储结构：数组【查找遍历速度快，增删慢】
 */
public class Study3_ArrayList {

    public static void main(String[] args) {
        List<Student> arrayList = new ArrayList();
        Student s1 = new Student("刘德华", 65);
        Student s2 = new Student("刘耕宏", 51);
        Student s3 = new Student("陈赫", 37);
        Student s4 = new Student("小明", 12);
        // 1、添加元素
        arrayList.add(s1);
        arrayList.add(s2);
        arrayList.add(s3);
        arrayList.add(s4);
        System.out.println("元素个数为："+ arrayList.size());
        System.out.println(arrayList.toString());

        // 2、删除元素
        arrayList.remove(new Student("小明", 12));
        System.out.println("删除元素后，元素个数为："+ arrayList.size());
        System.out.println(arrayList.toString());
//        arrayList.clear();    // 清空元素

        // 3、遍历
        ListIterator<Student> iterator = arrayList.listIterator();
        System.out.println("开始正序遍历：");
        while (iterator.hasNext()){
            System.out.println(iterator.nextIndex());
            System.out.println(iterator.next());
        }
        System.out.println("开始逆序遍历：");
        while (iterator.hasPrevious()){
            System.out.println(iterator.previousIndex());
            System.out.println(iterator.previous());
        }

        // 4、判断
        System.out.println(arrayList.contains(s2));
        System.out.println(arrayList.contains(new Student("刘耕宏", 51)));
        System.out.println(arrayList.isEmpty());

        // 5、查找
        System.out.println("陈赫在列表中的位置："+ arrayList.indexOf(s3));
        System.out.println("小明在列表中的位置："+ arrayList.indexOf(s4));
        System.out.println("刘耕宏在列表中的位置："+ arrayList.indexOf(new Student("刘耕宏", 51)));
    }
}
