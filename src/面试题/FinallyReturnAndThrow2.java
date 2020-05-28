package 面试题;


/**
 * finally块中使用return会抑制异常的冒泡传输
 */

public class FinallyReturnAndThrow2 {
    public static void main(String[] args) {
        displayTest();

    }

    private static void displayTest() {
        try {
            div();
        } catch (Exception e) {
            System.out.println("displayTest's catch");
        } finally {
            System.out.println("displayTest's finally");
        }
    }

    private static int div() {
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            System.out.println("div's catch");
            throw e;
        } finally {
            System.out.println("div's finally");
            return 2;
        }
    }
}
