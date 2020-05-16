package collectionandmap;

import classandobject.Person;

import java.util.HashSet;
import java.util.Iterator;

/**
 * HshSet是基于哈希表的数据结构实现的（一个HashMap实例）
 * set，无序的不重复元素的允许null元素
 *
 * 有序的实现子类——LinkedHashSet
 * 所以存储的对象必须实现equals和hashCode方法
 */

public class HashSetDemo {
    public static void main(String[]args){
        HashSet<Person> ha = new HashSet<>();
        Person p1 = new Person("jier",14);
        ha.add(new Person("zhansan",23));
        ha.add(new Person("wanwu",24));
        ha.add(new Person("lisi",25));
        //重复元素,调用equals和hashCode方法，重复就不添加。
        ha.add(new Person("lisi",25));
        ha.add(p1);
        p1 = new Person("jier",33);
        ha.add(p1);

        //Iterator<Person> it = ha.iterator();

        //使用迭代器的第二种方式，开发推荐
        for(Iterator<Person> it=ha.iterator();it.hasNext();){
            Person p = (Person)it.next();
            System.out.println(p.getName()+"..."+p.getAge());
        }
    }
}
