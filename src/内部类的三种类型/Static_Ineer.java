package 内部类的三种类型;

public class Static_Ineer {

    static class Inner {//静态内部类
        int a = 0;    // 实例变量a
        static int b = 3;    // 静态变量 b
    }

    class OtherClass {//实例内部类，非静态内部类

        Static_Ineer.Inner oi = new Static_Ineer.Inner();//不用创建外部类实例，通过类名创建内部类
        int a2 = oi.a;    // 访问实例成员
        int b2 = Static_Ineer.Inner.b;    // 访问静态成员
        int b3 = oi.b;
    }
}
 /*
 在创建静态内部类的实例时，不需要创建外部类的实例。

 静态内部类可以直接访问外部类的静态成员，如果要访问外部类的实例成员，则需要通过外部类的实例去访问。

 静态内部类中可以定义静态成员和实例成员。外部类以外的其他类需要通过完整的类名访问静态内部类中的静态成员，
 如果要访问静态内部类中的实例成员，则需要通过静态内部类的实例。
  */