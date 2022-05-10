package com.hwd.study.sourcecode;

import java.util.HashMap;
import java.util.Map;

/**
 * 源码分析：HashMap
 *
 * 1、刚创建的时候容量为null，为了节省空间，当添加第一个元素的时候，容量调整为16
 * 2、当元素个数大于阈值（16 * 0.75 = 12）时，会进行扩容，扩容大小为原来的2倍，目的是减少元素调整的个数
 * 3、jdk1.8当链表长度大于8，并且集合元素大于等于64链表调整为红黑树，目的是提高执行效率
 * 4、jdk1.8当链表长度小于6，红黑树调整成链表
 * 5、jdk1.8以前链表是头插入，jdk1.8以后是尾插入
 */
public class Source3_HashMap {

    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
/*
        刚创建HashMap的时候，table = null，size = 0，目的节省空间
 */
/*
        static final int DEFAULT_INITIAL_CAPACITY = 16; //  默认初始容量
        static final int MAXIMUM_CAPACITY = 1073741824; //  数组最大容量  2<<30
        static final float DEFAULT_LOAD_FACTOR = 0.75F; //  默认扩容系数
        static final int TREEIFY_THRESHOLD = 8;     //  jdk1.8当链表长度大于8，并且集合元素大于等于64调整为红黑树
        static final int UNTREEIFY_THRESHOLD = 6;   //  jdk1.8当链表长度小于6，调整成链表
        static final int MIN_TREEIFY_CAPACITY = 64; //  jdk1.8当链表长度大于8，并且集合元素大于等于64调整为红黑树
        transient HashMap.Node<K, V>[] table;       //  哈希表中的数组
        transient int size;                         //  元素个数
        int threshold;                              //
 */

        hashMap.put("a",1);
/*
    1、首先，进入 put 方法
        public V put(K key, V value) {
            return this.putVal(hash(key), key, value, false, true);
        }

    2、接着，进入 putVal 方法，由于方法比较大，先【关键】标记一些关键的代码
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
            HashMap.Node[] tab;
            int n;
            if ((tab = this.table) == null || (n = tab.length) == 0) {
                n = (tab = this.resize()).length;       // 【关键】用于扩容的方法，往下看 map 扩容的方法 resize()
            }

            Object p;
            int i;
            if ((p = tab[i = n - 1 & hash]) == null) {
                tab[i] = this.newNode(hash, key, value, (HashMap.Node)null);     // 【关键】在hash运算判断出位置是否为空之后进行
            } else {
                Object e;
                Object k;
                if (((HashMap.Node)p).hash == hash && ((k = ((HashMap.Node)p).key) == key || key != null && key.equals(k))) {
                    e = p;
                } else if (p instanceof HashMap.TreeNode) {
                    e = ((HashMap.TreeNode)p).putTreeVal(this, tab, hash, key, value);
                } else {
                    int binCount = 0;

                    while(true) {
                        if ((e = ((HashMap.Node)p).next) == null) {
                            ((HashMap.Node)p).next = this.newNode(hash, key, value, (HashMap.Node)null);
                            if (binCount >= 7) {
                                this.treeifyBin(tab, hash);
                            }
                            break;
                        }

                        if (((HashMap.Node)e).hash == hash && ((k = ((HashMap.Node)e).key) == key || key != null && key.equals(k))) {
                            break;
                        }

                        p = e;
                        ++binCount;
                    }
                }

                if (e != null) {
                    V oldValue = ((HashMap.Node)e).value;
                    if (!onlyIfAbsent || oldValue == null) {
                        ((HashMap.Node)e).value = value;
                    }

                    this.afterNodeAccess((HashMap.Node)e);
                    return oldValue;
                }
            }

            ++this.modCount;
            if (++this.size > this.threshold) {
                this.resize();
            }

            this.afterNodeInsertion(evict);
            return null;
        }

*/
        /**
         * map 扩容的方法 resize()
         */
/*
        final HashMap.Node<K, V>[] resize() {
            HashMap.Node<K, V>[] oldTab = this.table;
            int oldCap = oldTab == null ? 0 : oldTab.length;
            int oldThr = this.threshold;
            int newThr = 0;
            int newCap;
            if (oldCap > 0) {
                if (oldCap >= 1073741824) {
                    this.threshold = 2147483647;
                    return oldTab;
                }

                if ((newCap = oldCap << 1) < 1073741824 && oldCap >= 16) {
                    newThr = oldThr << 1;
                }
            } else if (oldThr > 0) {
                newCap = oldThr;
            } else {
                newCap = 16;
                newThr = 12;
            }

            if (newThr == 0) {
                float ft = (float)newCap * this.loadFactor;
                newThr = newCap < 1073741824 && ft < 1.07374182E9F ? (int)ft : 2147483647;
            }

            this.threshold = newThr;
            HashMap.Node<K, V>[] newTab = new HashMap.Node[newCap];
            this.table = newTab;
            if (oldTab != null) {
                for(int j = 0; j < oldCap; ++j) {
                    HashMap.Node e;
                    if ((e = oldTab[j]) != null) {
                        oldTab[j] = null;
                        if (e.next == null) {
                            newTab[e.hash & newCap - 1] = e;
                        } else if (e instanceof HashMap.TreeNode) {
                            ((HashMap.TreeNode)e).split(this, newTab, j, oldCap);
                        } else {
                            HashMap.Node<K, V> loHead = null;
                            HashMap.Node<K, V> loTail = null;
                            HashMap.Node<K, V> hiHead = null;
                            HashMap.Node hiTail = null;

                            HashMap.Node next;
                            do {
                                next = e.next;
                                if ((e.hash & oldCap) == 0) {
                                    if (loTail == null) {
                                        loHead = e;
                                    } else {
                                        loTail.next = e;
                                    }

                                    loTail = e;
                                } else {
                                    if (hiTail == null) {
                                        hiHead = e;
                                    } else {
                                        hiTail.next = e;
                                    }

                                    hiTail = e;
                                }

                                e = next;
                            } while(next != null);

                            if (loTail != null) {
                                loTail.next = null;
                                newTab[j] = loHead;
                            }

                            if (hiTail != null) {
                                hiTail.next = null;
                                newTab[j + oldCap] = hiHead;
                            }
                        }
                    }
                }
            }

            return newTab;
        }
*/



    }
}
