package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;//权限修饰符也被封装为对象了。

/**
 * 通过反射获取类的所有的方法：
 *
 * Class的方法：
 * 1、Method	getDeclaredMethod​(String name, Class<?>... parameterTypes)
 * 返回一个方法对象，该对象反映由该类对象表示的类或接口的指定声明方法。
 * 通过method.invoke();可以调用该方法对象指向的方法。
 * 2、 Method[]	getDeclaredMethods()——不包含继承方法，但可以获取私有方法
 * 返回一个包含对象方法的Method对象数组，该方法对象反映由这个类对象表示的类或接口的所有声明方法，包括公共、受保护、默认(包)访问和私有方法，
 * ！！1但不包括继承的方法。
 *
 * 3、Method[]	getMethods()、——包含继承方法，但只能获取共有方法
 * 返回一个包含方法对象的数组，该方法对象反映由该类对象表示的类或接口的所有公共方法，包括由类或接口声明的方法以及从超类和超接口继承的方法。
 * 4、Method	getMethod​(String name, Class<?>... parameterTypes
 * 返回一个方法对象，该对象反映由该类对象表示的类或接口的指定公共成员方法。
 */

public class Practice2_GetMethod {
    public static void main(String[] args) {
        try {
            //getStringMethod();//使用getDeclareMethods（）获取私有和公共方法，不包含继承。
            System.out.println("________________________________");
            getPersonMethod();
        } catch (ClassNotFoundException | NoSuchMethodException |
                InvocationTargetException | IllegalAccessException | InstantiationException e) {
            System.out.println("找不到指定类");
        }
    }

    private static void getPersonMethod()
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName("classandobject.Person");
        //获取无参的方法getAge
        Method method = clazz.getMethod("show");//第一个参数是要获取的方法名，第二个是该方法的参数列表,当为空时可以不写。

        //下面开始调用该方法
        //Constructor<?>constructor1 = clazz.getConstructor();//这个默认获取无参构造器，当没有无参构造器会抛出错误。
        //Object b1 = constructor1.newInstance();//Person没有无参构造器这里报错了，被捕抓
        Constructor<?> constructor = clazz.getConstructor(String.class,int.class);//获取其有参的构造器（String，int）；
        Object b = constructor.newInstance("小明",33);//创建一个Person实例，使用多态

        //先打印以下该方法
        System.out.println(method);
        method.invoke(b);//第一个是调用的对象，第二个参数是该方法传入的参数列表，当空时可以不写。

        //下面获取有参的方法
        Method method1 = clazz.getMethod("say",String.class);//获取say方法，方法的参数String
        method1.invoke(b,"我是有参的方法1");//调用有参方法 say(String s){}


    }

    public static void getStringMethod() throws ClassNotFoundException {
        // 动态加载xx类的运行时对象，其中的参数是类全名字符串，如果在类路径中找不到这个类则抛出 ClassNotFoundException 异常
        Class<?> c = Class.forName("java.lang.String");
        // 获取成员方法集合
        Method[] methods = c.getDeclaredMethods();//这个方法可以获取全部的方法，无论是私有还是共有。注意不包含继承的方法。
        //Method[] methods = c.getMethods();//只能获取共有的方法。
        // 遍历成员方法集合
        for (Method method : methods) {
            // 打印权限修饰符，如public、protected、private，是 int 类型，Modifier.toString(int)方法转换为字符串
            System.out.print(Modifier.toString(method.getModifiers()));
            // 打印返回值类型名称
            System.out.print(" " + method.getReturnType().getName() + " ");
            // 打印方法名称
            System.out.println(method.getName() + "();");
        }
    }
}
