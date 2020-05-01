package 面试题;

/**
 * 构造代码块给对象的初始化
 * 构造函数是使用来给针对的对象属性初始化
 */

public class StructCode {
    {
        System.out.println("哈哈");//构造代码块每创建一个对象就执行一次
    }

    public StructCode(int i) {//构造函不能写类型，默认返回值void
        System.out.println("构造函数");
    }


    public static void main(String[] args) {//先加载类，一加载就会执行静态代码块，而且只运行一次，然后找main函数入口。

        new StructCode(10);//有对象就会执行构造代码块，然后执行构造函数，
        new StructCode(10);//有对象就会执行构造代码块，然后执行构造函数，
        //构造代码块每创建一个对象就执行一次
    }
}
