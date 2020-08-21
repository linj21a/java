package Stream流AndMethodFerence;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 因为一个流只能访问一次，我们可以利用Supplier接口，每次都能构造该流
 *
 */

public class Stream04_GetStream {
    public static void main(String[] args) {
        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("d2", "a2", "b1", "b3", "c");
        Stream<String> stringStream = streamSupplier.get();
        stringStream.forEach(System.out::println);
        stringStream = streamSupplier.get();
        stringStream.forEach(System.out::println);


    }
}
