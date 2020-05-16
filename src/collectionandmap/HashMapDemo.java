package collectionandmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map是存放键值对的集合，属于双列集合而
 * Collection是单列集合，存放一个元素
 *
 * Map是键值对，键必须保证唯一，而值可以不唯一。
 * 方法：
 * 1.添加
 * value put(key,value)
 *  设置指定的key对于的值，同时返回该key之前的值，没有则返回null
 * 2.删除
 * value remove(key)删除指定key的值，并返回该值
 * void clear()清空map
 * 3.判断
 * boolean containsKey(key);
 * boolean containsValue(value);
 * boolean isEmpty();
 * 4.查询
 * Value get(Key);
 *
 * Map与Collection是不同的，它没有继承Iterator，即没有实现迭代器
 * 但是提供了一些api以及内部接口类来供我们遍历Map的元素。
 *
 * Set<T> KeySet();返回键的集合对象set（之所以是set类型，因为key是不允许重复的），我们就能使用迭代器和get（key）方法来遍历操作元素了
 *
 * 方法二：
 * Map.EntrySet<K,V>
 *     内部接口定义了
 *      -getValue
 *      -getKey
 *      -setValue等方法。
 *
 * 方法是Set<Map.EntrySet<K,V>> EntrySet()方法，返回一个set，集合对象是是Map.EntrySet<K,v>
 *
 * Map的常用的子类实现
 *  --HashTable——数据结构是哈希表，jdk1.0版本，线程安全的，同步。
 *      --Properties 用来存放键值对类型的配置文件信息
 *  --HashMap——HashSet实际上就是由HashMap的一个特殊实例实现的，内部结构是哈希表。其是HashTable的改进版本，不同步。
 *  --TreeMap——二叉树、红黑树数据结构，数据有序的，实际上TreeSet就是由TreeMap的一个特殊实例实现的。
 *
 *
 */

public class HashMapDemo {
    public static void main(String[]args){
        Map<Integer,String> map = new HashMap<>();
        map.put(23,"zhanwang");
        map.put(22,"sjfslf");
        map.put(22,"xiugai");
        Set<Integer> set = map.keySet();
        for(Iterator<Integer>it=set.iterator();it.hasNext();){
            Integer i = it.next();
            System.out.println("名字是："+map.get(i)+"年龄是："+i);
        }

    }
}
