package Exception_use;
/*
演示无限递归导致的堆栈溢出
 */

public class StackOverflow {
    public static void test(int i) {
        if (i == 0) {
            return;
        }
        test(i++);
    }

    public static void main(String[] args) {
        StackOverflow.test(5);//通过类名调用静态方法。

    }
}
