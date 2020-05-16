package collectionandmap;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * 演示可变长数组arrayList——不同步的vector
 * 演示vector的迭代方法——jdk1.0 Enumeration<E>接口 （1.2以后改进的Iterator）
 *
 */

public class ArrayListDemo {
    public static void main(String[]args){
        ArrayList<String>al = new ArrayList<>(5);
        al.add("aa");
        al.add("bb");
        al.add("bb");
        al.add("ccc");
        Iterator<String> it = al.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        Vector<String> vc = new Vector<>(5);
        vc.add("aa");
        vc.add("a3a");
        vc.add("aa4");
        vc.add("aa5");
        vc.add("aa7");
        vc.add("aa9");
        Enumeration<String> enumeration = vc.elements();
        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }


    }
}
