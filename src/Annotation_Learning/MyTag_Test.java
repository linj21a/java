package Annotation_Learning;

/**
 * 目的：使用自定义的注解
 *
 */

public class MyTag_Test {
    @MyTag(name="abc")
    public void display(){
        System.out.println("这是使用了自定义注解类的成员函数");
    }
    public static void main(String[]args){
        new MyTag_Test().display();//这里使用匿名类的方法。
    }
}
