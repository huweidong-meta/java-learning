1.说一下集合的了解？
有三个重要接口List、Set、Map
List和Set都是collection接口的子接口
List和Set区别在于list的元素是有序的、可重复的；set的元素是无序的、不可重复的。
List有三个重要的实现类：ArrayList、LinkedList、Vector
ArrayList、Vector都是以数组作为存储结构，不同在于ArrayList是线程不安全的，Vector是线程安全的，ArrayList比Vector执行效率高
LinkedList是以链表作为存储结构

Set有两个重要的实现类：HashSet、TreeSet
HashSet的存储结构是哈希表，TreeSet的储存结构是红黑树，使用TreeSet要求元素实现Comparable或者使用比较器Comparator

Map的重要实现类比较多选几个：HashMap、Hashtable、TreeMap
HashMap、Hashtable的存储结构都是哈希表。
区别是
(1)HashMap是线程不安全的，Hashtable是线程安全的；
(2)两者继承的父类不同；
(3)put方法HashMap允许key和value为null，如果key为null计算的下标是0，Hashtable中key和value都不允许为null，如果传null会报空指针异常；
(4)Hashtable默认容量是11，调用构造方法的时候就初始化了数组，HashMap默认容量是16，且put第一个元素的时候才进行初始化；
(5)达到阈值时HashMap每次扩容为原来的2倍，Hashtable每次扩容为原来的2倍+1；
(6)两者计算hash的方法不同，Hashtable是直接对数组的长度取余，HashMap通过取hash值并通过高位向右移，进行异或运算得到的hash值
TreeMap的存储结构是红黑树。

ArrayList源码分析：
添加第一个元素的时候容量变成了10；
扩容后的容量每次为原容量的1.5倍
LinkedList源码分析：
对象有三个属性，默认的容量是0，两个Node对象，代表头节点、尾节点，Node存放了三个属性，前指针、元素、后指针

HashMap源码分析：
刚创建的时候容量为null，为了节省空间
添加第一个元素时，容量为默认值16
当元素大于阈值（16*扩容系数0.75）12时，进行扩容，扩容大小为原来容量的2倍，目的是减少元素调整的个数
JDK1.8当链表长度大于8，数组长度>=64时，链表调整为红黑树，目的是提高执行效率
JDK1.8当链表长度小于6，红黑树调整为链表
JDK1.8之前链表是头插入、之后是尾插入

HashSet源码分析：
创建对象时，其实内部new了一个HashMap，添加元素时，其实是将元素当成Map的Key存入。
