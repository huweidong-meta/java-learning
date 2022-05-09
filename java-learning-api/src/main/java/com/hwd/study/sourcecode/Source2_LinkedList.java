package com.hwd.study.sourcecode;

import java.util.LinkedList;

/**
 *  源码分析：LinkedList
 *
 *  默认容量大小：  int size = 0;
 *  指向第一个节点的指针：Node<E> first;
 *  指向最后一个节点的指针：Node<E> last;
 */
public class Source2_LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
/*
        实例化的时候，linkedList对象有三个属性，其中两个都为Node对象 first和last，且都为null
        在 Node 构造方法中，pre存放前一个Node对象、element存放添加进来的元素、next存放后一个Node对象，
        前一个元素指向后一个元素，后一个元素指向前一个元素，这就形成了一个双向指针
        private static class Node<E> {
            E item;
            Node<E> next;
            Node<E> prev;

            Node(Node<E> prev, E element, Node<E> next) {
                this.item = element;
                this.next = next;
                this.prev = prev;
            }
        }
 */

        linkedList.add("java");
/*
        添加元素的add方法
        public boolean add(E e) {
            linkLast(e);
            return true;
        }

        添加第一个元素的时候，l = last = null，根据构造方法new Node<>(l, e, null)，所以新的Node对象前一个和后一个都指向了null
        根据 last = newNode; first = newNode ，所以first和last都指向了newNode[prev = null, item = "java", next = null]
        void linkLast(E e) {
            final Node<E> l = last;
            final Node<E> newNode = new Node<>(l, e, null);
            last = newNode;
            if (l == null)
                first = newNode;
            else
                l.next = newNode;
            size++;
            modCount++;
        }
        添加第二个元素时，l = last = Node[prev = null, item = "java", next = null]，
        根据 Node<E> newNode = new Node<>(l, e, null)，所以新对象的 pre = l，next = null，新对象的前一个指向了l(前对象)，后一个指向了null
        根据 last = newNode，所以 last指向了新对象，根据 l.next = newNode，所以l也就是前对象的后一个指向了新对象




 */

    }

}
