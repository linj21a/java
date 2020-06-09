package Reflect;

import java.lang.reflect.Constructor;
import java.util.Date;

public class ObjectFactory {

    public static <T> T getInstance(Class<T> cls) {//使用静态量 xxx.class
        try {
            Constructor<T> constructor = cls.getConstructor();//因为cls.newInstance过时了。
            return constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // 获取实例后无须类型转换
        Date d = ObjectFactory.getInstance(Date.class);
        System.out.println(d);

    }
}
