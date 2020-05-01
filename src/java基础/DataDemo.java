package java基础;

import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 * 目的：演示日期类的使用及格式控制
 * 相关函数：format（），getInstance（），日期类Data，Calendar，；日期格式控制类DataFrom，
 */

public class DataDemo {
    public static void main(String[] args) {
        //第一步，定义data对象,因为是抽象类，不能使用构造方法实例化对象，通过方法getDateInstance可以创建。
        //DateFormat df1 = DateFormat.getDateInstance();
        Date dt1 = new Date();//采用的是国家标准格式CST(Center Standard Time) ,分配一个Date对象并初始化它，使它表示分配它的时间，测量到最近的毫秒。
        System.out.println(dt1.toString());

        //构造方法2.参数表示距离基准时间过了多少毫秒。GMT与CST相差8小时
        Date dt2 = new Date(60000);//分配一个Date对象并初始化它，使其表示自标准基准时间“epoch”(即1970年1月1日00:00:00 GMT)以来指定的毫秒数。
        System.out.println(dt2.toString());

        //接受用户输入的时间与日期，到了日期就提醒，过期就警告
        Scanner sc = new Scanner(System.in);
        //1.输入你要办的时间与日期
        System.out.println("请输入事件：");
        String staff = sc.next();
        //获取当前时间
        Date now_da = new Date();
        System.out.println("你要办的事件为：" + staff + ",发生的时间是" + now_da);


        //模拟时间流逝，采用延时
        try {
            Thread.sleep(60000);//延时1分钟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //获取当前时间，before判断时间的前后，使用getTime（）来计算时间差值。计算的是毫秒，必须除以1000
        Date date2 = new Date();
        System.out.println("现在时间为：" + date2);
        if (date2.before(now_da)) {
            System.out.println("你还有 " + (date2.getTime() - now_da.getTime()) / 1000 + " 秒需要去完成【" + staff + "】这件事！");
        } else {
            System.out.println("【" + staff + "】事情已经过去了 " + (date2.getTime() - now_da.getTime()) / 1000 + " 秒");
        }


    }


}
