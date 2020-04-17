package collectionandmap;
/**
 * 目的:演示Stream的使用
 *
 * 独立使用 Stream 的步骤如下：
 * 使用 Stream 或 XxxStream 的 builder() 类方法创建该 Stream 对应的 Builder。
 * 重复调用 Builder 的 add() 方法向该流中添加多个元素。
 * 调用 Builder 的 build() 方法获取对应的 Stream。
 * 调用 Stream 的聚集方法。
 *
 * 注意事项：
 * Stream 提供了大量的方法进行聚集操作，这些方法既可以是“中间的”（intermediate），也可以是 "末端的"（terminal）。
 * 中间方法：中间操作允许流保持打开状态，并允许直接调用后续方法。上面程序中的 map() 方法就是中间方法。中间方法的返回值是另外一个流。
 * 末端方法：末端方法是对流的最终操作。当对某个 Stream 执行末端方法后，该流将会被“消耗”且不再可用。 sum()、count()、average() 等方法都是末端方法。
 */


import java.util.stream.IntStream;

public class IntStreamTest {
        public static void main(String[] args) {
            IntStream is = IntStream.builder().add(20).add(13).add(-2).add(18).build();
            // 下面调用聚集方法的代码每次只能执行一行，都是末端方法
            // System.out.println("is 所有元素的最大值：" + is.max().getAsInt());
            //            System.out.println("is 所有元素的最小值：" + is.min().getAsInt());
            //            System.out.println("is 所有元素的总和：" + is.sum());
            //            System.out.println("is 所有元素的总数：" + is.count());
            //            System.out.println("is 所有元素的平均值：" + is.average());
            //            System.out.println("is所有元素的平方是否都大于20: " + is.allMatch(ele -> ele * ele > 20));
            //            System.out.println("is是否包含任何元素的平方大于20 : " + is.anyMatch(ele -> ele * ele > 20));



            // 将is映射成一个新Stream,新Stream的每个元素是原Stream元素的2倍+1，中端方法
            IntStream newIs = is.map(ele -> ele * 2 + 1);
            // 使用方法引用的方式来遍历集合元素
            newIs.forEach(System.out::println); // 输岀 41 27 -3 37
        }
    }
