package Lambda表达式;

//定义一个函数式接口
@FunctionalInterface
interface Displayable {
    // 定义一个抽象方法和默认方法
    void display();

    default int add1(int a, int b) {
        return a + b;
    }
}

public class LambdaAndNei {

    private int age = 12;
    private static String name = "演示Lambda与匿名内部类联系";

    public void test() {
        int local_value = 4;//局部变量不会默认初始化，这里默认为final变量
        Displayable dis = new Displayable() {

            @Override
            public void display() {
                // 访问的局部变量
                System.out.println("local_value 局部变量为:" + local_value);
                // 访问外部类的实例变量和类变量
                System.out.println("外部类的 age 实例变量为：" + age);
                System.out.println("外部类的 name 类变量为：" + name);

                System.out.println(add1(1, 2));

            }
        };
        dis.display();
    }

    public static void main(String[] args) {
        LambdaAndNei lambda = new LambdaAndNei();
        lambda.test();
    }

}
