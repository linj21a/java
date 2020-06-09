package Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 利用反射来获取类的字段——类修饰符、等
 *
 * 使用Class中的方法：
 * Field[]	getFields()获取共有的成员字段、包含继承的
 * Field	getField​(String name)获取指定的成员字段
 *
 * Field[]	getDeclaredFields()获取共有的、私有的成员字段、不包含继承的
 * Field	getDeclaredField​(String name)获取指定的成员字段。
 *
 *   myfield = clazz.getDeclaredField("age");//获取私有的
 *  //虽然现在获取得到了age这个字段，但是我们是无法访问的。因为private
 *         //class Reflect.Practice2_GetField cannot access a member of class classandobject.Person with modifiers "private"
 *
 *         //解决方案：将权限检测去除
 *         myfield.setAccessible(true);
 */
public class Practice2_GetField {
    public static void main(String[]args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException,
            IllegalAccessException, InstantiationException, InvocationTargetException {
        getFieldsDemo1();
    }

    private static void getFieldsDemo1() throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        //第一，先获取字节码对象
        Class<?> clazz = Class.forName("classandobject.Person");
        Field[] fields = clazz.getFields();//获取共有的，包含继承的字段
        for(Field f:fields){
            System.out.println(f);//空，person里边的全是私有的
        }
        System.out.println("______________");
        fields = clazz.getDeclaredFields();//获取所有的字段，但是不包含继承的。
        for(Field f:fields){
            System.out.println(f);//空，person里边的全是私有的
            //1、序列化ID，隐藏的private static final long classandobject.Person.serialVersionUID
            //2、nameprivate java.lang.String classandobject.Person.name
            //3、ageprivate int classandobject.Person.age
        }
        System.out.println("______________");

        //获取指定的字段
        Field myfield;
        //= clazz.getField("age");//可能会抛异常，这里age是私有的,报错NoSuchFieldException
        //System.out.println(myfield);
        //先去除访问权限的修饰
        System.out.println("______________");
        Object b = clazz.getConstructor(String.class,int.class).newInstance("李四",35);

        myfield = clazz.getDeclaredField("age");//获取私有的

        //虽然现在获取得到了age这个字段，但是我们是无法访问的。因为private
        //class Reflect.Practice2_GetField cannot access a member of class classandobject.Person with modifiers "private"

        //解决方案：将权限检测去除
        myfield.setAccessible(true);
        //myfield.get(b);//获取b对象中的age
        System.out.println(myfield.get(b));





    }

}
