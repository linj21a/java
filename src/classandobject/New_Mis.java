package classandobject;

public class New_Mis {

    public static void main(String[] args) {
        String a = "qwe";//隐式创建对象，由 Java 虚拟机隐含地创建。
        String b = new String("qwe");//在堆中会创建一个对象，返回地址
        String c = "qwe";//先在栈里边寻找是否已经有这个内容了，没有就创建，有就直接将c指向这个地址。
        String d = new String("qwe");//在堆中会创建一个对象，返回地址
        System.out.println(a == b);//false
        System.out.println(a == c);//true，已经有qwe，c指向的地址与a同
        System.out.println(d == b);//false，两个对象的引用的地址肯定不同
        System.out.println(a);//qwe
        a = "Java";//重新赋值
        System.out.println(a);
    }
}