package com.hwd.study.sourcecode;

import java.util.ArrayList;

/**
 *  源码分析：ArrayList
 *
 *  默认容量大小：  int DEFAULT_CAPACITY = 10
 *  存放元素的数组：Object[] elementData
 *  实际元素的个数：int size
 */
public class Source1_ArrayList {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
/*
        实例化的时候，存放元素的数组为空数组，所以【没有添加任何元素的时候，容量是 0】
        public ArrayList() {
            this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        }
*/
        list.add("java");
/*
        添加元素的时候，第一步进行了数组扩容，第二步进行了元素赋值
        public boolean add(E e) {
            ensureCapacityInternal(size + 1);  // Increments modCount!!
            elementData[size++] = e;
            return true;
        }

        对第一步进行拆解，此时参数 minCapacity=1，因为上个方法中实际元素的个数由初始值0增加1变成了1
        private void ensureCapacityInternal(int minCapacity) {
            ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
        }

        继续拆解，此时参数 elementData 为空数组，minCapacity 为1，进入if条件中，拿默认容量10与传参1比较，最后返回了最大值 10
        private static int calculateCapacity(Object[] elementData, int minCapacity) {
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            }
            return minCapacity;
        }

        继续拆解，此时的入参 minCapacity 为上一步的最大值 10，然后 modCount 自增 它表示此列表在结构上被修改的次数，这是迭代器需要关注的，本次分析忽略
        10 - 0 > 0 ，容量大小 大于 存放元素数组的大小，进入扩容的核心方法中
        private void ensureExplicitCapacity(int minCapacity) {
            modCount++;

            // overflow-conscious code
            if (minCapacity - elementData.length > 0)
                grow(minCapacity);
        }

        进入扩容的核心方法中，入参为 minCapacity = 10，然后 oldCapacity = 0，newCapacity = 0
        newCapacity - minCapacity = 0 - 10 < 0 成立，newCapacity = 10，然后把 newCapacity新容量10复制给数组的容量
        private void grow(int minCapacity) {
            // overflow-conscious code
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0)
                newCapacity = minCapacity;
            if (newCapacity - MAX_ARRAY_SIZE > 0)
                newCapacity = hugeCapacity(minCapacity);
            // minCapacity is usually close to size, so this is a win:
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
        到这我们知道，【添加第一个元素的时候容量变成了 10】
*/

        /**
         * 当list元素大于10，怎么办？
         */
/*
        当list元素大于10，从头分析我们发现，当执行到方法 ensureExplicitCapacity 中 if (minCapacity - elementData.length > 0)
        11 - 10 > 0，条件成立所以进行扩容，然后我们重点看扩容方法 grow(int minCapacity)，入参 minCapacity = 11，oldCapacity = 10，
        newCapacity = 10 + 10 >> 1 = 15，右移1位相当于除以2，最后新数组的容量就变成了 15

        【结论：扩容后的容量大小每次为原来的1.5倍】

 */
    }

}
