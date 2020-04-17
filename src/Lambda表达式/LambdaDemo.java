package Lambda表达式;
public class LambdaDemo {
    // 实例成员变量
    private int value = 10;
    // 静态成员变量
    private static int staticValue = 5;
    // 静态方法，进行加法运算
    public static Caculation add() {
        // 局部变量
        int localValue = 20;
        Caculation result = (int a, int b) -> {
            //localValue++;重赋值编译器则认为不是final型
            // 编译错误
            int c = a + b + localValue;
            return c;
        };
        return result;
    }
    // 实例方法，进行减法运算
    public Caculation sub() {
        // final局部变量
        final int localValue = 20;
        Caculation result = (int a, int b) -> {
            // localValue = c;重赋值编译器则认为不是final型
            // 编译错误
            return a - b - staticValue - this.value;
        };
        return result;
    }
}