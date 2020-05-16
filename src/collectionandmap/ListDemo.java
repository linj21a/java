package collectionandmap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * List是Collection的子接口，是存储有序序列的接口
 * 允许重复的元素，则允许多个null
 * 每个元素都有索引角标
 *
 * 对比set接口——无序的序列（可能碰巧是有序）、不允许重复，深度贴合了集合的定义
 * 则最多只含有一个null
 *
 * 除了继承Collection的共有方法，List的特有方法：
 * 1.添加
 * void add(index,element);
 * boolean addAll(index,Collection<? extends E> c)
 * 2.删除
 * Object remove(index)
 * 3.替换
 * Object set(index,element)//指定角标元素——替换为element
 * 4.获取
 * int indexOf(Object o)
 * int lastIndex(Object o)
 * E get(index)//返回指定角标的元素
 * List subList(from , to)
 *
 * 5.迭代器
 * Iterator<E> iterator()——因为存在局限性不允许并发修改，即我们获得的迭代器对象长度一定，iterator不允许在迭代里边修改集合
 *
 * 特有迭代器——List才有，允许使用该迭代器修改元素集合
 * ListIterator<E> lstIterator
 * void add(E e)
 * 将指定的元素插入到列表中（可选操作）。
 * boolean hasNext()
 * 返回 true如果列表迭代器具有更多的元素时，正向遍历列表。
 * boolean hasPrevious()
 * 返回 true如果列表迭代器具有更多的元素时，逆向遍历列表。
 * E next()
 * 返回列表中的下一个元素，并推进光标位置。
 * int nextIndex()
 * 返回的元素，将返回的后续调用 next()指数。
 * E previous()
 * 返回列表中的前一个元素，并向后移动光标位置。
 * int previousIndex()
 * 返回的元素，将返回的后续调用 previous()指数。
 * void remove()
 * 从列表中删除最后一个元素是由 next()或 previous()返回（可选操作）。
 * void set(E e)
 * 取代过去的元素返回 next()或 previous()与指定的元素（可选操作）。
 *
 */

public class ListDemo {
    public static void main(String[]args){
        List list = new ArrayList();

        //使用Collection的方法
        list.add("123");
        list.add("456");
        list.add("789");
        System.out.println(list);//[123, 456, 789]

        //特有方法——添加
        list.add(2,"abc");
        System.out.println(list);//[123, 456, abc, 789]
        //替换——set
        list.set(3,"ggg");
        System.out.println(list);//[123, 456, abc, ggg]

        //删除
        list.remove(1);
        System.out.println(list);//[123, abc, ggg]
        list.clear();

        //获取
        Object o = list.get(2);
        System.out.println(o.toString());//ggg
        System.out.println(list.lastIndexOf("123"));//角标对应0
        System.out.println(list.indexOf("ggg"));//角标对应2

        //迭代器
       // Iterator it = list.iterator();
//        while(it.hasNext()){
//            Object obj = it.next();
//            if(obj.equals("123")){
//                list.add("55");//Exception in thread "main" java.util.ConcurrentModificationException,不允许并发修改
//            }
//            //System.out.println(it.next());
//        }//123_abc_ggg

        //特有迭代器
        ListIterator it_new = list.listIterator();
        while(it_new.hasNext()){
            /*
            public boolean hasNext() {
            return cursor != size;//角标不移动
        }
             */
            Object obj = it_new.next();
            if(obj.equals("123")){
               // list.add("55");//Exception in thread "main" java.util.ConcurrentModificationException,不允许并发修改
                it_new.add("55");
            }
            System.out.println(obj.toString());//这里角标会移动
            //注意，则
           // System.out.println(it_new.nextIndex());//角标不移动，则——无限循环
            /*
             public int nextIndex() {
                return cursor;
                }
             */
        }
        System.out.println(list);//[123, 55, abc, ggg]


    }
}
