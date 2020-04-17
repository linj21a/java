package Abstract_Interface;

/**
 * 接口没有构造方法，抽象类具有构造方法；
 * 接口中的成员域默认是具有public、static、final属性的，而抽象类中的成员域要看自己是怎么定义的~
 * 接口，多态，弥补单继承
 *
 * 现在接口和抽象类越来越相似了，现在不同点也就剩下：继承1个和实现多个的区别了。
 *
 * 此外，值得注意的是：面向对象中，java只是支持单继承，不支持多继承，一个类只能继承一个类，
 * 　　（1）如果多个接口定义了同样的静态方法，
 * 　　        即使存在实现类，同时实现多个接口，仍然是不可使用实现类名调用接口的方法
 * 　　（2）如果多个接口定义了同样的默认方法
 * 　　    实现类实现多个接口时，必须重写掉默认方法，否则编译失败。
 * 　　在接口中可以定义实现的方法体是java8的一大特性，可以定义多个静态或者默认的方法，静态必须加上static，默认方法必须加上default关键字。
 *  接口是对行为的抽象。接口是对类局部（行为）进行抽象。
 */

public interface Circle_Interface {
    //必须实现的常量,默认属性  public static final
    float pai = 3.14f;

    //定义方法体，在之前是不允许的，后来才加上——java8环境下
    // 方法的声明不需要其他修饰符，在接口中声明的方法，将隐式地声明为公有的（public）和抽象的（abstract）。

    //1.静态方法，可以有函数体，默认public
     static double Volume(){
        System.out.println("Circle_Interface的静态方法");
        return 1;
    }
    //抽象方法
    double getArea();//只要是抽象方法都无法拥有函数体，只能在继承的类或者实现该接口的类重写

    //普通方法的定义
    default double getLength(){
        System.out.println("Circle_Interface的普通方法");
        return 0;
    }


}
/*
4. 使用接口的原因：
(1).没有接口，可插入性就没有保证。因为Java是单继承的。
(2).在一个类等级结构中的任何一个类都可以实现一个接口，如果这个类实现了这个接口那么将会影响到此类的所有子类，但是不会影响到此类的所有父类。
(3).一个类最多有一个父类，但是可以同时实现几个接口。

！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
如果一个抽象类不包含任何抽象方法，为何还要设计为抽象类？
个人理解：
抽象类目的是用来继承的，在定义上，可以没有抽象方法，只是用abstract修饰是没有语法错误的，
但是没有哦实际意义。抽象类中的抽象方法是让子类继承抽象类，来实现抽象类中的抽象方法，根据子类的需求分别来实现不同的功能。

 */
