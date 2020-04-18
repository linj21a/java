package Annotation_Learning;

public class SafeVarargs_Demo {
    //定义一个可变参数类型的静态成员函数,并使用泛型
    @SafeVarargs
    public static<T> void display(T... array){//得到一个数组
        for(T t:array)
            System.out.println(t.getClass().getName()+":"+t);//打印其类型信息及值的大小
        System.out.println("代码在可变参数 display 前添加了 @SafeVarargs 注解，当然也可以使用 @SuppressWarnings(\\\"unchecked\\\") " +
                "注解，但是两者相比较来说 @SafeVarargs 注解更适合。\n" +
                "注意：@SafeVarargs注解不适用于非 static 或非 final 声明的方法，对于未声明为 static 或 final 的方法" +
                "，如果要抑制 unchecked 警告，可以使用 @SuppressWarnings 注解。");
    }
    public static  void main(String[]args){
        display(12,133,14);
        display("12",3,6);
    }
}
