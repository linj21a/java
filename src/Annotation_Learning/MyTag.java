package Annotation_Learning;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 目的：练习自定义注解
 * <p>
 * 声明自定义注解使用 @interface 关键字（interface 关键字前加 @ 符号）实现。定义注解与定义接口非常像
 * <p>
 * 根据注解是否包含成员变量，可以分为如下两类。
 * 标记注解：没有定义成员变量的注解类型被称为标记注解。这种注解仅利用自身的存在与否来提供信息，如前面介绍的 @Override、@Test 等都是标记注解。
 * 元数据注解：包含成员变量的注解，因为它们可以接受更多的元数据，所以也被称为元数据注解。
 */

@Target({ElementType.METHOD, ElementType.FIELD})//指定MyTag的修饰范围为方法或者成员变量。
public @interface MyTag {//其实可以说是注解类

    // // 注解中的成员变量以方法的形式来定义
    String name();//这里是自定义的注解

    String str() default "自定义注解使用默认值";//注意是没有分号的
}

