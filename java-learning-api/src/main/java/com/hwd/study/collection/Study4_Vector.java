package com.hwd.study.collection;

import java.util.Enumeration;
import java.util.Objects;
import java.util.Vector;

/**
 * Vector 是 List 接口的实现类
 * 存储结构：数组
 * 从Java 2平台v1.2，这个类被改造为实现List接口，和ArrayList不同的是，Vector是线程安全的。
 */
public class Study4_Vector {

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector();
        // 1、添加元素
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        System.out.println("元素个数为:"+ vector.size());
        System.out.println(vector);

        // 2、删除元素
        vector.remove(1);   // 按索引删除第1个元素
        vector.remove((Object) 4);   // 按元素删除
        System.out.println("删除元素后，元素个数为："+ vector.size());
        System.out.println(vector);
//        vector.clear();   // 清空元素

        // 3、遍历
        System.out.println("使用枚举器遍历：");
        Enumeration<Integer> enumeration = vector.elements();
        while (enumeration.hasMoreElements()){
            Integer o = enumeration.nextElement();
            System.out.println(o);
        }

        // 4、判断
        System.out.println(vector.contains(1));
        System.out.println(vector.isEmpty());

        // 5、查找
        System.out.println("元素3在列表中的位置："+ vector.indexOf(3));

        // 6、其他方法
        System.out.println("vector.elementAt(0) == vector.get(0)："+ Objects.equals(vector.elementAt(0) , vector.get(0)));
        System.out.println("第一个元素："+ vector.firstElement());
        System.out.println("最后一个元素："+ vector.lastElement());
    }
}
