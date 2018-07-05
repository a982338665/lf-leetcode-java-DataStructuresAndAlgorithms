# DataStructuresAndAlgorithms
数据结构--算法相关

**数组**
    
    1.引用数据类型,是一块连续的内存空间
    2.初始化数组后（int [] arr=new Int[]{1,2,3}）,在内存中所占空间才会被固定-数组长度不可变
    3.数组创建后，不能改变
    4.数组只能存储一种类型的数据 
    5.增加、删除元素效率慢 
    6.按照索引查询元素速度快,可存储大量数据
    7.java数组用int做引索,理论值是Integer.MAX_VALUE个，但实际是依赖jvm内存
    
**ArrayList**

    1.ArrayList底层的数据结构为数组，元素类型为Object ,Arraylist可存放null元素
    2.有序，可重复，线程不安全
    3.ArrayList插入有移位操作，故插入，移除效率低
    4.可以按索引读取， 所以读取效率高
    5.jdk1.6 new对象时，初始容量=10 copyof扩容为原来的1.5倍+1,即16
      jdk1.7 new对象时，初始容量=0 ,真正添加时分配容量,copyof扩容为原来的1.5倍
    6.ArrayList遍历时移除元素的问题及陷阱：
       * 正确方式：
       *  1.倒叙fori
       *  2.迭代器遍历-迭代器-remove
       * 错误方式：-ConcurrentModificationException（fail-fast机制-多线程下的问题）
       *  1.正序fori
       *  2.增强for(迭代器遍历-list-remove)
    7.线程安全的ArrayList的替代：java.util.concurrent -->
       * List<String> list = new CopyOnWriteArrayList<String>();
       
**LinkList**

    1.LinkedList底层使用的双向链表结构,可从头后从尾开始遍历
    2.LinkList插入或删除只需要改变前后节点指向即可，所以效率快
    3.由于LinkedList查询只能从头结点开始逐步查询的，可以使用 iterator 的方式，
      就不用每次都从头结点开始访问，
      因为它会缓存当前结点的前后结点。实测查询效率与ArrayList没有太大差别
      
**LinkList与ArrayList的效率比较：**

    1. LinkedList add cost time :35
       LinkedList get fori--> cost time :2886
       LinkedList get foreach--> cost time :31
       LinkedList get iterator--> cost time :6
       LinkedList remove cost time :7
       --------------------------------------------------------
       ArrayList add cost time :294
       ArrayList get fori--> cost time :1
       ArrayList get foreach--> cost time :5
       ArrayList get iterator--> cost time :1
       ArrayList remove cost time :530
    2.综上：
       1.ArrayList读取数据效率：fori=iterator > foreach
       2.LinkList读取数据效率：iterator>foreach>fori(切不可使用fori读取LinkList)
       3.插入删除效率比较：LinkList>ArrayList
       4.综合选用：
        ·读：ArrayList
        ·写：LinkList
        
**HashMap:**

    1.HashMap的key和value可为null,线程不安全
    2.HashMap底层实现数组+链表即Entry<K,V>[],
      jdk1.8后采用红黑树优化，当链表长度>8时，转换为红黑树
    3.默认初始容量:16 装载因子：0.75f 当真实数据达到0.75*16=12时，扩容为原来两倍2*16
    4.HashMap的容量必须为2的指数倍，最大容量为2^30,Entry是一个单向链表
    5.相同的HashCode，相同的key，在put时，新值覆盖旧值，并返回旧值,不会存在链表中
    6.相同的hashcode，不同的key，Hash冲突,Hash冲突后，那么HashMap的单个bucket
      里存储的不是一个 Entry，而是一个 Entry链
    7.线程安全的替代物：
        ·Map map = Collections.synchronizedMap(new HashMap());
        ·new ConcurrentHashMap<String, String>();
        ·HashTable的性能要比以上两种差，以上两种用了分段锁
    8.加载因子越大,填满的元素越多，空间利用率提高,hash冲突概率增大，查询效率降低（时-空抉择）
    9.扩容是需要进行数组复制的，复制数组是非常消耗性能的操作,那么预设元素的个数能够有效的提高HashMap的性能。
    10.在HashMap数组扩容之后,最消耗性能的点：原数组中的数据必须重新计算其在新数组中的位置，
      并放进去，这就是resize
    11.hash表的容量一定为2的整数次幂的原因：
        ·length为2的整数次幂时，h&(length-1)就相当于对length取模，这样便保证了散列的均匀，
         同时也提升了效率改用h&(length-1)而不是h%length是为了提高效率（相比于hashTable的优化）
        ·length为2的整数次幂时，length-1为奇数，奇数的二进制最后一位为1，那么&运算后的结果可能为0或1
         若length-1偶数，则最后一位为0，那么&运算后的结果只能为0，即数组会浪费一半的空间

**j**
    