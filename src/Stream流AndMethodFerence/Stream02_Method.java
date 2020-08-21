package Stream流AndMethodFerence;

import java.util.stream.Stream;

/**
 * Stream流里面的常用方法
 * 1、中断操作
 * 2、终端操作
 */

public class Stream02_Method {
    public static void main(String[] args) {
        Stream.of("a1","b2","c3","d4","e5")
                .map((s)->{
                    System.out.println("map: "+s);
                return s.toUpperCase();//变为大写
                }).filter((s)-> {
                    System.out.println("filter: "+s);
                    return s.startsWith("C");//过滤，c开头

        }).forEach(s->System.out.println("foreach--"+s));

        System.out.println("-------------------------");
        Stream.of("a1","b2","c3","d4","e5")
               .filter((s)-> {
            System.out.println("filter2: "+s);
            return s.startsWith("c");//过滤，c开头

        }) .map((s)->{
            System.out.println("map2: "+s);
            return s.toUpperCase();//变为大写
        }).forEach(s->System.out.println("foreach2--"+s));
    }
}
