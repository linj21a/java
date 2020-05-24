package CollectionDemoandArrays;

/**
 * 全局变量与局部变量，大一点的作用域不允许局部变量重名
 */

public class testnametype {
    static int b =3;
    int a;
    {
        a=1;
    }
    public static void main(String... s){
        System.out.println(new testnametype().a+" "+testnametype.b);
        int a=2;
        int b=4;
        a=5;
        System.out.println(a+" "+b);
        System.out.println(testnametype.b);
       /* for(int a =3;a<5;a++){
            System.out.println(a);
        }*///编译过不了，不允许a重复于int a=2；第15行。

    }
}
