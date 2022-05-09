package com.hwd.study.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * List 是 Collection 的子接口
 * 特点：1、有序 有下标  2、元素可重复
 */
public class Study2_List {

    public static void main(String[] args) {
        // 创建集合对象
        List<String> list = new ArrayList();

        // 1、添加元素
        list.add("linux");
        list.add("windows");
        list.add("mac");
        list.add(0, "android"); // 添加元素并且顺序为第一位
        list.add(1, "ios");
        System.out.println("元素的个数：" + list.size());
        System.out.println(list);

        // 2、删除元素
        list.remove("ios");
        System.out.println("删除之后元素的个数：" + list.size());
        System.out.println(list);

        Object remove = list.remove(0); // 把第一个元素给删除，返回被删除的元素
        System.out.println("删除之后元素的个数：" + list.size());
        System.out.println("被删除的元素为：" + remove);
        System.out.println(list);

        // 3、遍历
        System.out.println("使用for循环遍历：");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("使用增强for循环遍历：");
        for (Object obj : list) {
            System.out.println(obj);
        }

        System.out.println("使用迭代器遍历：");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }


        System.out.println("使用列表迭代器：");
        ListIterator listIterator = list.listIterator();

        System.out.println("使用列表迭代器从前往后：");
        while (listIterator.hasNext()) { // 返回 true如果遍历正向列表，列表迭代器有多个元素。
            System.out.println(listIterator.nextIndex());   // 返回随后调用 next()返回的元素的索引。
            System.out.println(listIterator.next());    // 返回列表中的下一个元素，并且前进光标位置。
        }

        System.out.println("使用列表迭代器从后往前：");
        while (listIterator.hasPrevious()) { // 返回 true如果遍历反向列表，列表迭代器有多个元素。
            System.out.println(listIterator.previousIndex());   // 返回由后续调用 previous()返回的元素的索引。
            System.out.println(listIterator.previous());    // 返回列表中的上一个元素，并向后移动光标位置。
        }

        // 4、判断
        System.out.println("是否包含ios：" + list.contains("ios") + "；是否包含mac：" + list.contains("mac"));
        System.out.println("集合是否为空：" + list.isEmpty());

        // 5、查找索引
        System.out.println("获取mac的位置：" + list.indexOf("mac"));


        // 6、补充：删除异常
        List<Integer> list2 = new ArrayList();
        list2.add(40);
        list2.add(50);
        list2.add(60);
        list2.add(70);
        list2.add(80);
        list2.add(90);
        System.out.println(list.toString());
//        IndexOutOfBoundsException: 索引越界异常
//        list.remove(20);
        list.remove((Object) 80);
        list.remove(new Integer(90));
        System.out.println(list.toString());

        // 7、补充：subList
        List subList = list.subList(0, 2);  // 返回此列表中指定的 fromIndex（含）和 toIndex（不含）之间的列表。
        System.out.println(subList);
    }
}
