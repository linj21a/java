package Reflect;

        import javax.swing.*;
        import java.util.Date;

public class ObjectFactory {

    public static <T> T getInstance(Class<T> cls) {//使用静态量 xxx.class
        try {
            return cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        // 获取实例后无须类型转换
        Date d = ObjectFactory.getInstance(Date.class);
        JFrame f = ObjectFactory.getInstance(JFrame.class);
    }
}
