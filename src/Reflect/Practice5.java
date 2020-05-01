package Reflect;

import java.lang.reflect.Field;

/**
 * 通过反射访问成员变量
 * <p>
 * 通过下列任意一个方法访问成员变量时将返回 Field 类型的对象或数组。
 * getFields()
 * getField(String name)
 * getDeclaredFields()
 * getDeclaredField(String name)
 * <p>
 * 上述方法返回的 Field 对象代表一个成员变量。
 */

class Book2 {
    String name;
    public int id;
    private float price;
    protected boolean isLoan;
}

public class Practice5 {
    public static void main(String[] args) {
        Book2 book = new Book2();
        // 获取动态类Book2
        Class class1 = book.getClass();
        // 获取Book2类的所有成员
        Field[] declaredFields = class1.getDeclaredFields();
        // 遍历所有的成员
        for (int i = 0; i < declaredFields.length; i++) {
            // 获取类中的成员变量
            Field field = declaredFields[i];
            System.out.println("成员名称为：" + field.getName());
            Class fieldType = field.getType();
            System.out.println("成员类型为：" + fieldType);
            boolean isTurn = true;
            while (isTurn) {
                try {
                    // 如果该成员变量的访问权限为private，则抛出异常
                    isTurn = false;
                    System.out.println("修改前成员的值为：" + field.get(book));
                    // 判断成员类型是否为int
                    if (fieldType.equals(int.class)) {
                        System.out.println("利用setInt()方法修改成员的值");
                        field.setInt(book, 100);
                    } else if (fieldType.equals(float.class)) {
                        // 判断成员变量类型是否为float
                        System.out.println("利用setFloat()方法修改成员的值");
                        field.setFloat(book, 29.815f);
                    } else if (fieldType.equals(boolean.class)) {
                        // 判断成员变量是否为boolean
                        System.out.println("利用setBoolean()方法修改成员的值");
                        field.setBoolean(book, true);
                    } else {
                        System.out.println("利用set()方法修改成员的值");
                        field.set(book, "Java编程");
                    }
                    System.out.println("修改后成员的值为：" + field.get(book));
                } catch (Exception e) {
                    System.out.println("在设置成员变量值时抛出异常，下面执行setAccessible()方法");
                    field.setAccessible(true);
                    isTurn = true;
                }
            }
            System.out.println("=============================\n");
        }
    }
}
