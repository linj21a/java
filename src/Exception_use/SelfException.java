package Exception_use;

public class SelfException extends RuntimeException {
    SelfException() {
    }

    SelfException(String msg) {
        super(msg);
    }
}

class PrintStackTraceTest {
    public static void main(String[] args) {
        firstMethod();
    }

    public static void firstMethod() {
        secondMethod();
    }

    public static void secondMethod() {
        thirdMethod();
    }

    public static void thirdMethod() {
        throw new SelfException("自定义异常信息");
    }
}

