package Polymorphism;

import java.util.ArrayList;
import java.util.List;

/**
 * 目的：
 *  练习使用Instanceof来判断类，接口，对象的实例
 * 运算符简介:
 *  instanceof 是 Java 中的一个双目运算符，由于它是由字母组成的，所以也是 Java 的保留关键字。
 *  在 Java 中可以使用 instanceof 关键字判断一个对象是否为一个类（或接口、抽象类、父类）的实例
 */

public class InstanceOf_Test {
    public static void main(String[]args){
        //创建一个对象
        Object oj = new Object();

        //判断类型
        System.out.println( oj instanceof Object);

        //判断继承的类,这个时候的object是object定义的，没有使用向上转型
        System.out.println(oj instanceof InstanceOf_Test);//false

        //判断接口
        ArrayList arrayList = new ArrayList();
        System.out.println(arrayList instanceof List);
        //反过来
      List array = new ArrayList();//这里使用了向上转型，true
        System.out.println( array instanceof ArrayList );

        //与null比
      //  Integer i = 1;
      //  System.out.println(i instanceof null);无法编译，null与任何比较都是false

        //必须为引用类型， 编译器会检查 obj 能否转换成右边的 class 类型，如果不能转换则直接报错，如果不能确定类型，则通过编译。
        //int l = 9;
       //System.out.println(l instanceof  Integer);
        InstanceOf_Test in = new InstanceOf_Test();
        System.out.print(in.toString());//打印出类的信息
        //System.out.print(in instanceof String);//但是无法转化为String

    }
}
