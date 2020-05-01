package java基础;

import java.util.Random;
import java.lang.Math;

public class random_demo {
    public static void main(String[] args) {
        Random rng = new Random();//该构造方法使用一个和当前系统时间对应的数字作为种子数，然后使用这个种子数构造 Random 对象。
        int a_int = rng.nextInt(2);//不指定范围产生的数值范围很大，现指定2，即[0,2）不包括2的整数
        System.out.println("无参构造方法产生的随机整数为：（均匀分布)" + a_int);
        double a_double = rng.nextDouble();
        System.out.println("无参构造方法产生的随机双精度的浮点数为：（均匀分布)" + a_double);

        //使用另外的构造方法
        Random rang = new Random(123456);//设置了其他随机种子，发现不加L也行
        int a_int_rang = rng.nextInt(2);//所以产生的随机整数可能与上面的不同。
        System.out.println("有参构造方法产生的随机整数为：（均匀分布)" + a_int_rang);

        //重新设置随机种子
        rang.setSeed(System.nanoTime());//设置为与系统时间对应的数字，得到的Random对象与第一次的对象一致。
        int a_int_ = rng.nextInt(2);//所以产生的随机整数可能与上面的不同。
        System.out.println("重新设置随机种子为系统时间产生的随机整数为：（均匀分布)" + a_int_);
    }

}
