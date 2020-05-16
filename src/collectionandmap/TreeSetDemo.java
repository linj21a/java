package collectionandmap;

import ComparatorClass.ComparatorDemo;
import classandobject.Person;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet——基于 TreeMap NavigableSet实现,是通过红黑树来存储元素，保证元素有序的是comparable或者comparator两个接口
 * <p>
 * 此实现不同步
 * <p>
 * 演示TreeSet的使用及其排序的两种方式
 * 方式一：调用无参构造器时，存储对象要实现了comparable接口，规定了自然排序的方法，否则报错
 * 方式二：创建了带比较器的TreeSet，自己写的比较器实现了comparator接口。comparator.compare(e1, e2)
 * 必须任何一个元素 e1和 e2类型限制。否则发生集合中的 ClassCastException。如果用户试图违反此约束的集合添加一个元素，该 add称将 ClassCastException。
 * 开发推荐使用方式二。
 * <p>
 * 构造器有四个_
 * 1、TreeSet()
 * 构造一个新的、空的树集，根据其元素的自然排序进行排序。
 * 2、TreeSet(Collection<? extends E> c)
 * 构造一个新的树集包含在指定集合的元素，根据其元素的自然排序排序。
 * 3、TreeSet(Comparator<? super E> comparator)
 * 构造一个新的、空的树集，根据指定的比较器进行排序。
 * 4、TreeSet(SortedSet<E> s)
 * 构造一个包含相同元素的新树集，并使用相同的排序作为指定的排序集。
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        //方式一，传入的person实现了comparable接口。
        System.out.println("####方式一####");
        TreeSet<Person> ts1 = new TreeSet();
        ts1.add(new Person("zhangsan", 14));
        ts1.add(new Person("Lisi", 15));
        ts1.add(new Person("Xiaowu", 44));
        ts1.add(new Person("zhousan", 4));
        ts1.add(new Person("zhouwan", 14));
        Iterator it = ts1.iterator();
        while (it.hasNext()) {
            Person p = (Person) it.next();
            System.out.println(p.getName() + ".." + p.getAge());
        }
        System.out.println("____方式二____");
        //方式二：使用了自定义的比较器——comparatorDemo,因为string里面是按字典顺序排序的compareTo，
        //假设我们现在要先比较长度，长度相同才比较字典顺序。
        TreeSet<String> ts2 = new TreeSet(new ComparatorDemo());
        ts2.add("aaa");
        ts2.add("bbb");
        ts2.add("ccccc");
        ts2.add("qqqqqqqqq");
        ts2.add("ggggggggg");
        ts2.add("gggggaggg");//长度相同，字典顺序不同
        it = ts2.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        //演示类型不满足比较器的约束
       // ts2.add(new Person("li",33));
        /*
        Exception in thread "main" java.lang.ClassCastException: 不满足类型约束，类型错误
        at ComparatorClass.ComparatorDemo.compare(ComparatorDemo.java:9)
	    at java.base/java.util.TreeMap.put(TreeMap.java:550)
	    at java.base/java.util.TreeSet.add(TreeSet.java:255)
	    at collectionandmap.TreeSetDemo.main(TreeSetDemo.java:60)
         */


    }
}
