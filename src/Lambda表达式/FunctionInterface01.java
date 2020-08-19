package Lambda表达式;

/**
 * 函数式编程1，什么是函数式接口？
 * 有且只有一个抽象方法。支持默认方法和静态方法。
 *
 * 语法糖：
 * 什么是语法糖？
 * 就是原理上是一样的，但是简化了书写，
 * 如For-each，原理都是利用了底层的迭代器。但是简化了书写而已。
 *
 * 但是Lambda表达式从应用上看，是匿名内部类 的‘语法糖’。但是实际上原理是不一样的。
 *
 * Java Lambda表达式的一个重要用法是简化某些匿名内部类（Anonymous Classes）的写法。
 * 实际上Lambda表达式并不仅仅是匿名内部类的语法糖，JVM内部是通过invokedynamic指令来实现Lambda表达式的。
 *
 * 如：
 * 不能在lambda内部修改定义在域外的变量，可以读取
 * int a = 0;
 *     new Thread(
 *            () -> a++
 *            //Variable used in lambda expression should be final or effectively final
 *     ).start();
 *
 *     下面通过测试两种方式可以看出两者的原理区别。
 */

public class FunctionInterface01 {
    public static void main(String[] args) {
        //方式一，利用匿名内部类来实现
        new FunctionInterface01().get(3, 5, new Lambda03_Calculator() {
            @Override
            public int sum(int a, int b) {
                return a+b;
            }
        });

    }
    public void get(int a,int b,Lambda03_Calculator calculator){
        System.out.println(calculator.sum(a,b));
    }

}
