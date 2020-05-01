package Annotation_Learning;

import java.lang.annotation.Repeatable;

//定义一个注解
@Repeatable(Tags.class)
@interface Tag {
    String value();//都是叫做value
}

//定义一个注解可以多重使用
@interface Tags {
    Tag[] value();//都是叫做value，只不过类型为注解数组
}

public class Repeatable_Test {

    @Tag(value = "name2")
    @Tag(value = "name1")//连续使用注解
    public void sayHell0() {
        System.out.println("两个注解的成员变量的method要一样！，这里都是value，然后类似于java7的写法，只不过在第二个注解上面加上@Repeatable（第一个注解的class静态量）");
    }

    @Continue_Tag(con = "jj")
    public static void main(String[] args) {
        new Repeatable_Test().sayHell0();
    }
}