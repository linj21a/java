package Reflect;

/**
 * 反射的练习1：
 * 每一种类型包括类和接口等，都有一个 class 静态变量可以获得 Class 实例。
 * 另外，每一个对象都有 getClass() 方法可以获得 Class 实例，该方法是由 Object 类提供的实例方法。
 *
 */

public class Practice1 {
    public static void main(String[]args){
        //形式1new一个，使用getClass方法
        String str = "jello";
        //使用静态量class,使用Class定义的话，就可以使用对应的api
        Class s = String.class;
        System.out.println(str.getClass()+" "+s);

        System.out.println("s类名称：" + s.getName());
        System.out.println("s是否为接口：" + s.isInterface());//对比instanceOf
        System.out.println("s是否为数组对象：" + s.isArray());
        System.out.println("s父类名称：" + s.getSuperclass().getName());

        System.out.println("s是否为基本类型：" + s.isPrimitive());
    }
}
