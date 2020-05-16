package java基础;
class Other { static String hello = "Hello"; }
class Other1 { public static String hello = "Hello"; }
public class StringPoolTest {
    public static final String a ="ab";
    public static final String b ="ab";
    public static final String c ;
    public static final String d ;
    static{
        c="cd";
        d = "cd";
    }

    public static void main(String[] args) {
        String s0 = a+b;//s是由a，b常量加来的常量，存进字符串常量池
        String t0 = "abab";
        System.out.println((s0==t0)+" zero");
//c,d虽然被定义为常量，但是由于是用静态代码块进行初始化，必须是在类加载才能确认其值，所以就相当于变量，那么s1自然是不会进入常量池
        String s1 = c+d;
        String t1 = "cdcd";
        System.out.println((s1==t1)+" first");

        String hello = "Hello", lo = "lo";
        System.out.println((hello == "Hello") + " 1");
        System.out.println((Other.hello == hello) + " 2");
        System.out.println((Other1.hello == hello) + " 3");//只要是同一份内容，字符常量池就只有一份
        System.out.println((hello == ("Hel"+"lo")) + " 4");//加号得到“hello”本来就在常量池中，故指向地址一致
        System.out.println((hello == ("Hel"+lo)) + " 5");//lo是变量，而且不进入常量池，是在堆开辟空间，地址不一样
        System.out.println((hello == ("Hel"+lo).intern())+" 6");//使用intern（），检查常量池有没有，没有就创建，显然是有的，就是hello
    }
}
