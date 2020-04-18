package Annotation_Learning;

public class Target_TestMyTag {
    @MyTag(name="使用target注解修饰的注解MyTag")
    void sayHello(){
        System.out.println("target注解用于限制其他注解的使用范围");
    }
    @MyTag(name="使用target注解修饰的注解MyTag")
    private int name;//可以修饰成员了。
    public static void main(String[]args){
        new Target_TestMyTag().sayHello();
    }
}
