package Reflect;

import classandobject.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * new 对象的原理：
 * 早期：先根据类的名称寻找该类的字节码文件，然后加载进入内存。
 * 并创建该字节码文件对象。接着创建该字节码文件对象的对应类。
 * 如：
 * Person p = new Person("ls",90);
 *
 * 现在：利用了反射
 * String s = "包..Person"
 * Class clazz = Class.forName(s);
 * Object b = clazz.newInstance();//这个方法已经过时。
 *
 * 获取构造器：
 * 1、有参——需要指定参数的类型字节码文件
 * 2、无参——不需要指定。
 * getConstructor（）+—返回类型是反射包里边的Constructor对象
 *
 */
public class Practice2_GetConstructor {
    public static void main(String[]args) throws ClassNotFoundException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {

        getConstructor1();
    }

    private static void getConstructor1() throws ClassNotFoundException, IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class<?>clazz = Class.forName("classandobject.Person");

        //Constructor<?> constructor = clazz.getConstructor();//获取无参构造器，报错，因为我们person没有无参构造器。
        Constructor<?>constructor1 = clazz.getConstructor(String.class,int.class);//获取有参构造器。

        //利用构造器构造对象
        Object b1 = constructor1.newInstance("李四",34);//它会调用我们的无参构造器

        System.out.println(b1.hashCode());//因为我的person覆写了hashcode方法。

    }

}
