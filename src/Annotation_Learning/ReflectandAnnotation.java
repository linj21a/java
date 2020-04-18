package Annotation_Learning;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 练习使用反射获取注解类信息

 */
//定义一个注解
@Retention(RetentionPolicy.RUNTIME)//使注解运行时可见
@interface MyTag1{
    String value() default "第一个注解的默认value值";
}
@Retention(RetentionPolicy.RUNTIME)
@interface MyTag2{
    String value() default "第二个注解的默认value值";
}

@MyTag1()
@MyTag2(value="第二个注解值设置为100")
public class ReflectandAnnotation {

        public void test(){
            System.out.println("进入类的test方法,只有当定义注解时使用@Retention(RetentionPolicy.RUNTIME) 修饰，该注解才会在运行时可见。");
        }
        public static void main(String[]args){
            //第一步，创建对应的信息类
            Class<?> test = ReflectandAnnotation.class;//这里使用泛型匹配类

            //定义一个注解量接受返回值，返回值为注解类型,我们是使用类
            MyTag1 myTag1 = test.getAnnotation(MyTag1.class);//所有这里test才能返回对应的值
            System.out.println(myTag1.value());
            MyTag2 myTag2 = test.getAnnotation(MyTag2.class);//所有这里test才能返回对应的值
            System.out.println(myTag2.value());

            Annotation [] annotations = test.getAnnotations();
            //使用for-each遍历
            for(Annotation annotation:annotations){
                System.out.println(annotation);
            }


        }

}
