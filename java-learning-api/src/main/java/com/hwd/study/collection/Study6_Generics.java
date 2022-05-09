package com.hwd.study.collection;

import com.hwd.study.collection.generics.MyGenerics;
import com.hwd.study.collection.generics.MyGenericsImpl;
import com.hwd.study.collection.generics.MyGenericsImpl2;
import com.hwd.study.collection.generics.MyGenericsMethod;

/**
 * 使用范型类 MyGenerics
 *
 * 注意：
 * 1、泛型只能使用引用类型     2、不同泛型对象不能相互复制
 */
public class Study6_Generics<T> {

    public static void main(String[] args) {
        // 泛型类
        MyGenerics<String> myGenerics = new MyGenerics();
        myGenerics.show("hello");
        myGenerics.t = "world";
        System.out.println(myGenerics.getT());

        MyGenerics<Integer> myGenerics2 = new MyGenerics();
        myGenerics2.show(2);
        myGenerics2.t = 3;
        System.out.println(myGenerics2.getT());

        // 泛型接口
        MyGenericsImpl impl = new MyGenericsImpl();
        impl.get("新年");

        MyGenericsImpl2 impl2 = new MyGenericsImpl2();
        impl2.get("快乐");
        impl2.get(200);

        // 泛型方法
        MyGenericsMethod method = new MyGenericsMethod();
        method.show("happy");
        method.show(200);
        method.show(5.21);
        /**
         * 泛型的好处：1、好处提高代码重用性(不需要再写重载) 2、防止类型转换异常，提升代码的安全性
         */

    }
}
