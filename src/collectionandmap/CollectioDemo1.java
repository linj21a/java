package collectionandmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**集合的含义：
 * 是用来存储对象的容器对象，Collection是根接口
 * 长度可变，存储的数据为对象，不能是基本数据类型。
 * 位于工具类包——java.util包
 *
 * 目的：演示根接口的使用方法
 * //jdk1.4以前就是Object——E e;
 * 1.添加
 * boolean add(Object o)
 * boolean addAll(collection<? extends E> c)
 * 2.删除
 * boolean remove(Object o)
 * boolean removeAll(collection<? extends E> c)
 * void clear();//清空集合容器
 * 3.判断
 * boolean equals()
 * boolean equalsAll()
 * boolean contains()
 * boolean containsAll()
 * boolean isEmpty()
 * 4.其他
 * boolean retain()
 * boolean retain(collection<? extends E> c)//取交集
 * Object[] toArray()//集合转化为数组
 *
 */

public class CollectioDemo1 {
    public static void main(String[]args){
        Collection coll1 = new ArrayList();//创建一个可变长数组类型集合
        Collection coll2 = new ArrayList();


        //1.添加方法
        coll1.add("abc1");
        coll1.add("45");

        coll2.add("dfg");
        coll2.add("iii");
        coll1.addAll(coll2);

        System.out.println(coll1);//本来会打印哈希值，但是coll进行了封装，使得打印出来的是字符串[abc1, 45, dfg, iii]
        System.out.println(coll2);//本来会打印哈希值，但是coll进行了封装，使得打印出来的是字符串[dfg, iii]

        //coll1.retainAll(coll2);//在coll1中保留交集 coll1 = [dfg, iii]=coll2

        //2.删除方法
        coll1.remove("abc1");
        System.out.println(coll1);//[45, dfg, iii]
        coll1.removeAll(coll2);
        System.out.println(coll1);//[45]
        coll2.clear();
        System.out.println(coll2.isEmpty());//true

        //3.判断方法
        System.out.println(coll1.contains("45"));//true
        System.out.println(coll1.containsAll(coll2));//false,注意当coll2是空，就像现实的集合一样，判断为包含true。
        System.out.println(coll1.equals("45"));
        /*
        public boolean equals(Object o) {
        if (o == this) {
         */

        //4.使用迭代器访问 对象的值
        //方式一：用过以后的it对象指向空，所以失去了作用，但是方式一it还存在，浪费空间
        Iterator it = coll1.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //方式2——使用临时变量,开发推荐，当然如果我们还需要迭代器对象就使用方式一。
        for (Object o : coll1) {//for each语法遍历
            System.out.println(o);
        }
        for(Iterator it2= coll1.iterator();it2.hasNext();){
            System.out.println(it2.next());
        }


    }
}
