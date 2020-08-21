package Stream流AndMethodFerence;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 什么是Stream流？它不同于IO流，用来解决、简化集合元素操作遍历等的弊端性问题。
 * JDK1.8以后，Lambda表达式的衍生物。
 *
 * 可以做到：
 * 1、将集合转化为stream流
 * 2、将数组转化为stream流
 *
 * 它搭建的是管道信息流，利用流水线的原理，每个阶段都生成一个新的stream流。同时上一个stream流关闭。
 *
 */

public class Stream01_What {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("张三");
        stringSet.add("李四");
        stringSet.add("王五");
        stringSet.add("田七");
        stringSet.add("张三枫");
        stringSet.add("张国荣");

        //利用集合操作，打印姓为张、长度为3的string
       /* for (String s:stringSet) {
            if(s.length()==3&&s.startsWith("张")){
                System.out.println(s);
            }

        }*/

   /*    //利用stream流操作：
        Stream<String> stream = stringSet.stream();
        stream
                .filter((name)->name.startsWith("张"))
                .filter((name)->name.length()==3)
                .forEach((name)-> System.out.println(name));*/

        Stream<String> stream = stringSet.stream();
        stream
                .filter((name)->name.startsWith("张"))
                .filter((name)->name.length()==3)
                .forEach(System.out::println);

        //总结：
        //一、使用集合来操作的时候，需要对每个数据进行判断两次，1、开头是否为‘张’；2、长度是否为3；，每个元素都参与了判断。
        //二、使用了流来操作，
        // 根据源码声明：你不需要对所有的数据进行判断，流操作分为中间（生产线）操作和（生产后消费）终端操作。
        // 中间操作是懒惰的
        //集合的大小是有限的，但是stream流可能是无限的，只有在有限的时间取出数据，比如短路操作：limit(n),findFirst().
        //stream允许在有限的时间内完成对无限流的计算。

        //流的生命周期是短暂的，其元素只允许被访问一次。与迭代器类似，必须生产新的流来访问同样的元素
        //没有存储结构
        //stream.forEach(System.out::println);报错，流已经关闭，执行了终端操作stream has already been operated upon or closed
    }
}

