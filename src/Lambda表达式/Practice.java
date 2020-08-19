package Lambda表达式;

public class Practice {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 5;
        // 打印加法计算结果
        display(Integer::sum, n1, n2);
        // display((a, b) -> a + b, n1, n2);
        // 打印减法计算结果
        display((a, b) -> a - b, n1, n2);
    }

    /**
     * 打印计算结果
     *
     * @param calc Lambda表达式,因为时函数式接口，这个参数即可以接收实现 Calculable 接口的对象，也可以接收 Lambda 表达式
     * @param n1   操作数1
     * @param n2   操作数2
     */
    public static void display(Caculation calc, int n1, int n2) {
        System.out.println(calc.caculationInt(n1, n2));
    }
}
