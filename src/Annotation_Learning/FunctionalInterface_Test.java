package Annotation_Learning;

/**
 * 在学习 Lambda 表达式时，我们提到如果接口中只有一个抽象方法（可以包含多个默认方法或多个 static 方法），那么该接口就是函数式接口
 * 。@FunctionalInterface 就是用来指定某个接口必须是函数式接口，所以 @FunInterface 只能修饰接口，不能修饰其它程序元素。
 * 函数式接口就是为 Java 8 的 Lambda 表达式准备的，Java 8 允许使用 Lambda 表达式创建函数式接口的实例，
 * 因此 Java 8 专门增加了 @FunctionalInterface。
 * <p>
 * ：@FunctionalInterface 注解主要是帮助程序员避免一些低级错误，例如，在上面的 FunInterface 接口中再增加一个抽象方法 abc()，编译程序时将出现如下错误提示：
 */

@FunctionalInterface
interface FunctionInterface_Lambda {
    void display();//默认为抽象方法，函数式接口只能有一个抽象方法，可以有静态方法和普通方法

    default void learn() {
        System.out.println("这是普通方法");
    }

    static void learn_static() {
        System.out.println("这是静态方法");
    }

}

public class FunctionalInterface_Test implements FunctionInterface_Lambda {
    @Override
    public void display() {//使用注解表示为重写接口的抽象方法。
        System.out.println("继承函数式接口，必须在相应的类里边实现该方法");
    }


    public static void main(String[] args) {
        FunctionInterface_Lambda test = new FunctionalInterface_Test();
        test.display();
        test.learn();
        FunctionInterface_Lambda.learn_static();
    }
}
