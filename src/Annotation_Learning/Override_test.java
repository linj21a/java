package Annotation_Learning;

public class Override_test {
    @Override
    public String toString(){
        System.out.println("这是重写Object类的toString()方法，使用Override注解告知编译器。\n" +
                "如果没有重写，则 Error:(4, 5) java: 方法不会覆盖或实现超类型的方法");
        return "返回值为String类型";
    }
    public static void main(String[]args){
        Override_test test = new Override_test();
        test.toString();
    }
}
