package classandobject;

public class Integer_Int {
    public static void main(String[]args){
        // 1）基本类型和包装类型
        double a = 10.0;//常规量，
        Double b = 10.0;//自动装箱，使用了new
        System.out.println(a == b);//b拆箱，所以比较值

        // 2）两个包装类型
        Double c = 10.0;//自动装箱，使用new，
        Double d = 10.0;//自动装箱，使用new
        System.out.println(c == d);//比较地址，false

        // 3）常规量
        c = 20.0;
        d = 20.0;//也就是说这里c，d都使用了new，
        System.out.println(c == d);//自然这里比较的是地址，false
        System.out.println(c.equals(d));//自然这里比较的是对象的值，true

    }

}