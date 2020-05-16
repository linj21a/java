package classandobject;

public class Integer_Int {
    public static void main(String[]args){
        // 1）基本类型和包装类型
        int a = 100;//字面量
        Integer b = 100;//自动装箱，但是100在-128到127之间（一个字节大小的范围），使用常量池存放，new一个会作为共享，节省空间
        System.out.println(a == b);//b拆箱，这里就是比较值的大小了。true

        // 2）两个包装类型
        Integer c = 100;//自动装箱，但是100在-128到127之间，地址引用,直接拿b来用
        Integer d = 100;//自动装箱，但是100在-128到127之间，常量池已经有了，直接拿b的值来用
        System.out.println(c == d);//true，地址引用相同
        System.out.println(c==b);//true,地址引用相同
        System.out.println(c==a);//true 自动拆箱
        Integer c_new = new Integer(100);
        System.out.println(c_new==c);//false,因为地址引用不同
        // 3）常规量
        c = 200;//c = c.valueOf(200),200不在-128到127之间，所以会使用new创建对象
        d = 200;//也就是说这里c，d都使用了new，

        System.out.println(c == d);//使用new创建的对象地址引用不同，false
        System.out.println(c.equals(d));//比较的是值，true

    }
}
