package CollectionDemoandArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 演示集合框架工具类的方法——将集合转化为同步集合
 */

public class SynchronizedDemo implements Runnable {
    int count=10;
     ArrayList<Integer> al;
    List<Integer> l;
    {
        al = new ArrayList<>();
        int i=0;
        while(i<10){
            al.add(i);
            i++;
        }
        System.out.println(al);
        l = Collections.synchronizedList(al);
    }
    public static void main(String[]args){
        SynchronizedDemo test = new SynchronizedDemo();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        while(true&&l.size()>0){
         l.add(1);
         l.remove(1);

        }

    }
}
