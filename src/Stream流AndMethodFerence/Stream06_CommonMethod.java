package Stream流AndMethodFerence;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 常用方法学习
 * + concat()用于连接两个流
 * + map方法用于对流中数据进行隐射、
 * + count()方法执行计数、，min()、max（）返回最值操作。`终端操作`
 * + limit​(long maxSize) 返回由此流的元素组成的流，截断长度不超过 maxSize 。
 * + skip(long n) 在丢弃了流 的n个元素后，返回由此流的其余元素组成的流。
 * + Stream<T> distinct() 返回由此流的不同元素（根据 Object.equals(Object) ）组成的流。
 * + Object[] toArray() 返回包含此流的元素的数组。
 * + Stream<T> sorted() 返回由此流的元素组成的流，按照自然顺序排序。
 * Stream<T> sorted​(Comparator<? super T> comparator) 返回由此流的元素组成的流，根据提供的 Comparator进行排序。
 * + boolean noneMatch​(Predicate<? super T> predicate) 返回此流的元素是否与提供的谓词匹配。
 */

public class Stream06_CommonMethod {
    public static void main(String[] args) {
        long length = Stream.of("a", "b", "c", "d").count();//计数
        System.out.println(length);


        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
        integerArrayList.add(5);
        integerArrayList.add(15);
        integerArrayList.add(18);
        integerArrayList.add(5);

        Stream<Integer> stream = integerArrayList.stream();

        Optional<Integer> t = stream.max((o1, o2) -> o1 - o2);//求最大值

        System.out.println(t + "------" + t.get());
        System.out.println("跳过前三个数：");
        integerArrayList.stream().skip(3).forEach((s) -> System.out.print(s + " "));//跳过前三个数
        System.out.println("\n截取前三个数：");
        integerArrayList.stream().limit(3).forEach((s) -> System.out.print(s + " "));//截取前3个数据打印
        System.out.println("\n去除重复：");

        integerArrayList.stream().distinct().forEach((s) -> System.out.print(s + " "));//去重
        System.out.println("\nstream foreach打印所有数：");
        integerArrayList.stream().forEach((s) -> System.out.print(s + " "));//打印所有数
        System.out.println("\n arrayList foreach打印所有数：");
        integerArrayList.forEach((s) -> System.out.print(s + " "));//打印所有数

        boolean res = integerArrayList.stream().allMatch((i) -> i > 5);//判断所有的值是否大于5，传入参数为predicate接口。
        System.out.println(res);

       // Object[] arr = integerArrayList.toArray();
        Object[] arr = integerArrayList.stream().toArray();
        for (Object o : arr
        ) {
            System.out.println(o);

        }

    }
}
