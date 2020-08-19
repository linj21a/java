package Lambda表达式;

import java.util.function.Consumer;

/**
 * Interface Consumer<T>
 *
 * 参数类型
 * T - 操作的输入类型
 * All Known Subinterfaces:
 * Stream.Builder<T>
 * Functional Interface:
 * 这是一个功能接口，因此可以用作lambda表达式或方法引用的赋值目标。
 *
 * --------------------------------------------------------------------------------
 *
 *\ @FunctionalInterface
 * public interface Consumer<T>表示接受单个输入参数并且不返回任何结果的操作。 与大多数其他功能接口不同， Consumer预计会通过副作用运行。
 * 这是一个functional interface，其功能方法是accept(Object) 。
 *
 * 从以下版本开始：
 * 1.8
 * accept方法用于消费一个数，至于如何消费则需要自定义。
 * andThen方法
 * 比如现在我们要消费两次的该数据
 *
 * ```java
 * Consumer<String>con1;
 * Consumer<String>con2;
 * String s = "猪猪";
 * con1.accept(s);
 * con2.accept(s);
 * ```
 * 使用andThen方法简写,也就是用andThen链接两个Consumer接口，进行消费同一个数据。
 *
 * ```java
 * con1.andThen(con2).accept();
 * ```
 *
 *
 */

public class FunctionInterface03_Consumer {
    public static void displayMess(String mess, Consumer<String> consumer){
        consumer.accept(mess);
    }

    public static void displayMessTwice(String mess, Consumer<String>consumer){
        consumer.andThen(s -> System.out.println(mess + " 我是二号 ")).accept(mess);
    }

    public static void main(String[] args) {
    /*    displayMess("我是cumsumer，使用Lambda表达式",( mess)->System.out.println(mess));
    //参数只有一个，语句只有一个，可以省略类型定义，返回值、{}，；

    //当语句没有对参数进行修改，仅仅进行访问，可以改为方法引用。

        displayMess("我是cumsumer，使用方法引用", System.out::println);*/
        displayMessTwice("我是comsumer",(mess)->System.out.println(mess+" 我是一号 "));

    }//参数只有一个，语句只有一个，可以省略类型定义，返回值、{}，；




}
