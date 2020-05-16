package collectionandmap;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 演示有序的HashSet——LinkedHashSet的使用
 *
 */

public class LinkedHashSetDemo {
    public static void main(String[]args){
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("aa");
        lhs.add("ab");
        lhs.add("aaaaa");
        lhs.add("lagslaj");

        Iterator<String>it = lhs.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }



    }

}
