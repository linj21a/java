package 内置包装类的Test;

class Test {
    //该类默认继承Object类
}

public class Object_ThreeStaff {
    /**
     * 需求：演示Object类的三个常用的成员方法
     * 1.toString；2。
     */
    public static void main(String[] args) {
        Test test = new Test();//默认构造方法
        System.out.println("不加toString：" + test);
        System.out.println("加了toString：" + test.toString());
    }
}
