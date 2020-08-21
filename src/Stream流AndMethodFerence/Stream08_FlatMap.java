package Stream流AndMethodFerence;

import java.util.Optional;

/**
 * 上面我们已经学会了如通过map操作, 将流中的对象转换为另一种类型。但是，Map只能将每个对象映射到另一个对象。
 * 如果说，我们想要将一个对象转换为多个其他对象或者根本不做转换操作呢？这个时候，flatMap就派上用场了。
 * FlatMap 能够将流的每个元素, 转换为其他对象的流。因此，每个对象可以被转换为零个，一个或多个其他对象，
 * 并以流的方式返回。之后，这些流的内容会被放入flatMap返回的流中。
 *
 */
public class Stream08_FlatMap {
    public static void main(String[] args) {
        Stream08_Outer stream08_outer = new Stream08_Outer();
        //为了处理从 Outer 对象中获取最底层的 name字符串，
        //你需要添加多个null检查来避免可能发生的NullPointerException
        if(stream08_outer.inerr != null && stream08_outer.inerr.inerr2 != null){
            System.out.println(stream08_outer.inerr.inerr2.name);
        }
        //我们还可以使用Optional的flatMap操作，来完成上述相同功能的判断，且更加优雅
        Optional.of(new Stream08_Outer())
                .flatMap(o -> Optional.ofNullable(o.inerr))
                .flatMap(n -> Optional.ofNullable(n.inerr2))
                .flatMap(i -> Optional.ofNullable(i.name))
                .ifPresent(System.out::println);
//如果不为空的话，每个flatMap的调用都会返回预期对象的Optional包装，否则返回为null的Optional包装类。
    }
}
