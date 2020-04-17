package 内置包装类的Test;

public class Demo类 {
    public static void printClassInfo(Object obj) {
        // 获取类名
        System.out.println("类名：" + obj.getClass().getName());
        // 获取父类名
        System.out.println("父类：" + obj.getClass().getSuperclass().getName());
        System.out.println("实现的接口有：");
        // 获取实现的接口并输出
        for (int i = 0; i < obj.getClass().getInterfaces().length; i++) {
            System.out.println(obj.getClass().getInterfaces()[i]);
        }
    }
    public static void main(String[] args) {
        String strObj = new String();
        printClassInfo(strObj);//静态方法在类定义时就已经分配内存了，可以直接调用。
    }
}
