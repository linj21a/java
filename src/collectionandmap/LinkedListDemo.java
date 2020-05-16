package collectionandmap;

/*
演示LinkedListDemo的用法
 */

import java.util.LinkedList;
import java.util.HashSet;
import java.util.ListIterator;

public class LinkedListDemo {
    public static void main(String[]args){
        LinkedList linkedList = new LinkedList<String>();
        linkedList.add("abc");
        linkedList.add("def");
        linkedList.add("hij");
        linkedList.clear();

        ListIterator iterator = linkedList.listIterator();
        iterator.add("klnm");//采用了迭代器来修改

        Object top = linkedList.pop();//返回栈顶元素，集合操作
        System.out.println(top.toString());
        //iterator.add(new Integer(123));//又进行迭代器的修改，导致发生并发修改异常
        linkedList.add(123);
        top = linkedList.pop();
        if(top instanceof  Integer)
            System.out.println(top.toString());
        else
            System.out.println("nnonn");

    }
}
