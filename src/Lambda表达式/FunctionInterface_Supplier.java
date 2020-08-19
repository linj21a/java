package Lambda表达式;

import java.util.function.Supplier;

/**
 * Supplier是函数式接口，常用的
 * 一般称为生产型接口，只有一个get方法。
 * 该接口带泛型参数。
 * Interface Supplier<T>
 *
 * 参数类型
 * T - 该供应商提供的结果类型
 * All Known Subinterfaces:
 * ServiceLoader.Provider<S>
 * 所有已知实现类：
 * GuardingDynamicLinkerExporter
 * Functional Interface:
 * 这是一个功能接口，因此可以用作lambda表达式或方法引用的赋值目标。
 *
 * --------------------------------------------------------------------------------
 *
 *、 @FunctionalInterface
 * public interface Supplier<T>代表结果的供应商。
 * 每次调用供应商时都不要求返回新的或不同的结果。
 *
 * 这是一个functional interface，其功能方法是get() 。
 *
 * 从以下版本开始：
 * 1.8
 */

public class FunctionInterface_Supplier {
    public static String  getMess(Supplier<String> supplier){
        return supplier.get();
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
       /* String mess = FunctionInterface_Supplier.getMess(new Supplier<String>() {
            @Override
            public String get() {
                return s1+s2;//函数式接口，如果函数内不修改外部的数据，则可以。否则外部数据需要声明为efficiency final
            }
        });*/
        String mess = FunctionInterface_Supplier.getMess(() -> s1 + s2);//无论有没有返回值都省略，泛型参数都省略了。。。
        System.out.println("mess = " + mess);
        //利用lambda表达式

    }
}
