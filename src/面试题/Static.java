package 面试题;

/**
 * 用途：给一些不能实例化的类（通常全是静态成员，此时我们约定默认的构造函数是私有的，那就不能实例化了。）的初始化。
 */

public class Static {

    public static void main(String[]args){//先加载类，一加载就会执行静态代码块，而且只运行一次，然后找main函数入口。
        System.out.println("呵呵");
        System.out.println(new Static().toString());//这里也加载了类，但是静态代码块只运行一次
    }

    static{
        System.out.println("大家好！");
    }
}
