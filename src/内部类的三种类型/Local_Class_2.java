package 内部类的三种类型;

/*
在局部内部类中可以访问外部类的所有成员。

在局部内部类中只可以访问当前方法中 final 类型的参数与变量。如果方法中的成员与外部类中的成员同名，
则可以使用 <OuterClassName>.this.<MemberName> 的形式访问外部类中的成员。
 */
public class Local_Class_2 {
    int a = 0;
    int d = 0;

    public void method() {
        int b = 0;//不用final定义的局部变量,默认使用final， Effectively final 功能
        //b=2;//一旦重写赋值就会报错
            /*
            如果在1.8的环境下，会很神奇的发现我们最开始的ThreadTest.java文件编译和运行是完全没有问题的，
            也就是说内部类使用的局部变量是可以不声明为final？！
            也就是说规则没有改变，只是java1.8的编译变得更加智能了而已，
            在局部变量没有重新赋值的情况下，它默认局部变量为final型，
            认为你只是忘记加final声明了而已。如果你重新给局部变量改变了值或引用，
            那就无法默认为final了，所以报错。
             */
        final int c = 0;
        final int d = 10;
        class Inner {
            int a2 = a;    // 访问外部类中的成员
            int b2 = b;    //访问方法中的成员,没有编译错误？
            int c2 = c;    // 访问方法中的成员
            int d2 = d;    // 访问方法中的成员
            int d3 = Local_Class_2.this.d;    //访问外部类中的成员
        }
        Inner i = new Inner();//创建局部内部类
        System.out.println(i.d2);    // 输出10
        System.out.println(i.d3);    // 输出0
        System.out.print(i.b2);
    }

    public static void main(String[] args) {
        Local_Class_2 t = new Local_Class_2();
        t.method();
    }
}

