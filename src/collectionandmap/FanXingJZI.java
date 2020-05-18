package collectionandmap;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 检验泛型机制的擦除机制——为了兼容以前的类装载器，jdk5.0加入的泛型机制添加了擦除
 * 仅在编译器的编译时加入泛型控制，编译出的类文件是没有具体的泛型参数的，如String等是没有的
 * 运行时，使用泛型和使用Object所产生的字节码是相同的。因此，泛型是在编译期对代码进行检查的。
 *
 * 但是在运行的时候加入了补偿机制——即在使用该泛型元素时，会使用反射获取其class信息确定其类型
 * 通过引用类型参数来对擦除进行补偿。即显式地传递该类型的class对象。
 */

public class FanXingJZI {
    public static void main(String[]args){
        ArrayList<String> t1= new ArrayList<>();
        ArrayList<Integer> t2= new ArrayList<>();
        Class<? >c1 = t1.getClass();
        Class<?>c2 = t2.getClass();
        System.out.println(c1==c2);//true，说明编译时的类文件确实是一致的，String与Integer类型参数被擦除。

        //演示补偿机制
        t1.add("aaaa");
        t2.add(666);
        Iterator<?> t= t1.iterator();
        String s = t1.get(0);
        Integer a = t2.get(0);//我们并不需要加强转，这就是加入泛型机制的好处之一。提高了安全性
        //这里实际上会加入补偿，就虽然擦除了类型，但是运行时会 String s = (String)t1.get(0);


    }

}
