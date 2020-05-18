package collectionandmap;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * TreeMap数据结构是红黑树（二叉树），能对数据排序，TreeSet就是基于一个TreeMap实例
 * 基本是方法与TreeSet类似，只不过没有迭代器，存储的是键值对。——Map与Collection的区别
 *
 */

public class TreeMapDemo {
    public static void main(String[]args){
        TreeMap<String,Integer> treeMap = new TreeMap<>();
        treeMap.put("zhansan",22);
        treeMap.put("liu",22);
        //treeMap.put(null,null);//TreeMap允许值是空，键不能为空
        treeMap.put("",null);

        Set<String> set = treeMap.keySet();
        for(Iterator<String>it=set.iterator();it.hasNext();){
            String s = it.next();
            System.out.println(s+":::"+treeMap.get(s));
        }

    }
}
