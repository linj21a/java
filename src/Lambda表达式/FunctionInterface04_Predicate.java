package Lambda表达式;

import java.util.function.Predicate;

/**
 * Interface Predicate<T>
 *
 * 参数类型
 * T - 谓词的输入类型
 * Functional Interface:
 * 这是一个功能接口，因此可以用作lambda表达式或方法引用的赋值目标。
 *
 * --------------------------------------------------------------------------------
 *
 *\ @FunctionalInterface
 * public interface Predicate<T>表示一个参数的谓词（布尔值函数）。
 * 这是一个functional interface，其功能方法是test(Object) 。
 *
 * 从以下版本开始：
 * 1.8
 * 里面的方法有：
 * default Predicate<T> and​(Predicate<? super T> other)
 * 返回一个组合谓词，表示此谓词和另一个谓词的短路逻辑AND。
 * static <T> Predicate<T> isEqual​(Object targetRef)
 * 返回一个谓词，根据 Objects.equals(Object, Object)测试两个参数是否相等。
 * default Predicate<T> negate()
 * 返回表示此谓词的逻辑否定的谓词。
 * static <T> Predicate<T> not​(Predicate<? super T> target)
 * 返回谓词，该谓词是提供的谓词的否定。
 * default Predicate<T> or​(Predicate<? super T> other)
 * 返回一个组合谓词，表示此谓词与另一个谓词的短路逻辑OR。
 * boolean test​(T t)
 * 根据给定的参数计算此谓词。
 */

public class FunctionInterface04_Predicate {
    public static void isBiggerThanTen(int t, Predicate<Integer> predicate){
        if(predicate.test(t)){//大于10则输出
            System.out.println("输入的数字大于10，可以输出:"+t);
        }else System.out.println("t = " + t + "小于10");
    }
    public static void testAllMethod(int t, Predicate<Integer> predicate1, Predicate<Integer> predicate2){//判断是否为三位数
        if(predicate1.and(predicate2).test(t)){//——test
            //等效于：predicate1.test()&&predicate2.test();
            System.out.println("输入的数字是三位数"+t);
        }else  System.out.println("输入的数字不是三位数"+t);

        if(predicate1.or(predicate2).test(t)){//输入大于10或者小于5的数——or
            //等价于predicate1.test(t)||predicate2.test(t)
            System.out.println("输入的数大于10或者小于5  "+t);
        }else  System.out.println("输入的数小于10，大于5  "+t);

        if(Predicate.isEqual(100).test(t)){
            //等价于t==100
            System.out.println("输入的数等于100：  "+t);
        }else System.out.println("输入的数不等于100：  "+t);

        if(!predicate1.negate().test(0)){//测试是否为负数
            System.out.println("输入的数是负数：  "+t);
        }else  System.out.println("输入的数不是负数：  "+t);


    }

    public static void main(String[] args) {

        testAllMethod(100,(t)->t>0,(t)->t>10);
    }
}
