package Annotation_Learning;

/**
 * Java 中 @Deprecated 可以用来注解类、接口、成员方法和成员变量等，用于表示某个元素（类、方法等）已过时。
 * 当其他程序使用已过时的元素时，编译器将会给出警告。同时Ide会给该行代码画上横线表示过时
 */

public class Deprecated_Test {
    @Deprecated(since = "9", forRemoval = true)
    public String toString1() {
        System.out.println("这是@Deprecated,表示过时的注解，可以用来注解类、接口、成员方法和成员变量等，用于表示某个元素（类、方法等）已过时。" +
                "\n它有两个属性：\n1:since 表示自什么时候起过时\n2:forRemoval表示将来是否会被移除，布尔型" +
                "\n@Deprecated 的作用与文档注释中的 @deprecated 标记的作用基本相同，" +
                "但它们的用法不同，前者是 Java 5 才支持的注解，无须放在文档注释语法（/** ... */部分）中，" +
                "\n而是直接用于修饰程序中的程序单元，如方法、类和接口等。");

        return "@Deprecated";
    }

    public static void main(String[] args) {
        Deprecated_Test test = new Deprecated_Test();
        test.toString1();


    }

}
