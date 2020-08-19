package Lambda表达式;

/**
 * 定义一个实验接口，函数式接口，利用一个注解声明。里面可以有默认方法和静态方法。
 * 但是只能有一个抽象方法。
 *
 */
@FunctionalInterface
public interface Lambda02_Cook {
    void makeRice(String mess);//做饭
    default void say(){
        System.out.println("我会做饭！");
    }
}
