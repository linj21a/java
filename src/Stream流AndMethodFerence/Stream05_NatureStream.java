package Stream流AndMethodFerence;

import java.util.stream.IntStream;


/**
 * 原生流类
 *
 */

public class Stream05_NatureStream {
    public static void main(String[] args) {
        IntStream.range(1,5).forEach((s)-> System.out.println(s));
        //类似于for(int i=1;i<5;i++){System.out.println(s)}
        //LongStream.range(1,5).forEach((s)-> System.out.println(s));

        //原始流类转化为对象流
        int s = IntStream.range(3,8).sum();
        System.out.println(s);

    }
}
