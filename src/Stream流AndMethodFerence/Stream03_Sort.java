package Stream流AndMethodFerence;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * 有状态的中间操作；
 * sort
 */

public class Stream03_Sort {
    public static void main(String[] args) {
      /*  Stream.of("c3","a1","b2","d4","e5")//将数据打乱
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        System.out.printf(o1+" ...... "+o2+"\n");
                        return o1.compareTo(o2);
                    }
                })
                .map((s)->{
                    System.out.println("map: "+s);
                    return s.toUpperCase();//变为大写
                }).filter((s)-> {
            System.out.println("filter: "+s);
            return s.startsWith("C");//过滤，c开头

        }).forEach(s->System.out.println("foreach--"+s));*/

        //
        Stream.of("c3","a1","b2","d4","e5")//将数据打乱
                .filter((s)-> {
                    System.out.println("filter: "+s);
                    return s.startsWith("c");//过滤，c开头

                }).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.printf(o1+" ...... "+o2+"\n");
                return o1.compareTo(o2);
            }
        })
                .map((s)->{
                    System.out.println("map: "+s);
                    return s.toUpperCase();//变为大写
                }).forEach(s->System.out.println("foreach--"+s));
        //从上面的输出中，我们看到了 sorted从未被调用过，因为经过filter过后的元素已经减少到只有一个，这种情况下，
        // 是不用执行排序操作的。因此性能被大大提高了。


    }
}
