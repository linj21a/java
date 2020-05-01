package Reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Practice2 {
    public static void main(String[] args) {
        try {
            // 动态加载xx类的运行时对象，其中的参数是类全名字符串，如果在类路径中找不到这个类则抛出 ClassNotFoundException 异常
            Class c = Class.forName("java.lang.String");
            // 获取成员方法集合
            Method[] methods = c.getDeclaredMethods();
            // 遍历成员方法集合
            for (Method method : methods) {
                // 打印权限修饰符，如public、protected、private，是 int 类型，Modifier.toString(int)方法转换为字符串
                System.out.print(Modifier.toString(method.getModifiers()));
                // 打印返回值类型名称
                System.out.print(" " + method.getReturnType().getName() + " ");
                // 打印方法名称
                System.out.println(method.getName() + "();");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("找不到指定类");
        }
    }
}
