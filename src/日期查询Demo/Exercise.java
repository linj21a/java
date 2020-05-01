package 日期查询Demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 需求：创建一个类实现三个功能：
 * 1.获取指定日期所在周的周一日期、
 * 2.获取两个指定日期的相差天数、
 * 3.获取指定日期为所在周的星期几的日期这 3 个功能
 * 同时定义 Date 类型的日期与 String 类型之间的转换方法。
 *
 * @author Lh
 * @version 1.0.0
 */

public class Exercise {

    /**
     * 需求:定义获取指定日期所在周的周一日期的方法——getMonday()
     * <p>
     * Date 类型的参数，返回值为string类型
     */
    public static String getMonday(Date date) {
        //创建实例对象
        Calendar c = Calendar.getInstance();
        //设置为当前的日期
        c.setTime(date);
        //获取星期一
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        //格式化返回
        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
    }

    /**
     * 需求：定义获取两个日期间相差天数的方法——getTwoDay()
     * 该方法需要传递两个 String 类型的参数。
     */
    public static int getTwoDay(String sj1, String sj2) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        int day;
        try {
            Date date = myFormatter.parse(sj1);
            Date mydate = myFormatter.parse(sj2);
            // 计算两个日期间相差的天数
            day = (int) ((date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000));
        } catch (Exception e) {
            return 0;
        }
        return day;
    }

    /**
     * 需求:创建两个静态方法，分别完成 String 类型的日期与 Date 类型日期的互换功能。
     */
    public static Date StrToDate(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String DateToStr(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(date);
    }


    /**
     * 需求：定义获取指定日期所在周的指定星期的日期方法——getWeek()，获得一个日期所在周的星期几的日期，如要找出2011年5月1日所在周的星期一是几号
     * 该方法需要传递两个 String 类型的参数，其中第一个参数表示指定的日期，第二个参数表示星期几。
     * sdate所确定的日期形式2011-05-01
     * num要确定的是周几（1表示周一，2表示周二）
     */
    public static String getWeek(String sdate, String num) {
        // 调用strToDate方法转化sdate
        Date dd = StrToDate(sdate);
        //创建实例Calendar
        Calendar c = Calendar.getInstance();
        c.setTime(dd);
        int weekNo = Integer.parseInt(num);
        switch (weekNo) {
            case 1:
                c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);    //返回星期一所在的日期
                break;
            case 2:
                c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);    //返回星期二所在的日期
                break;
            case 3:
                c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);    //返回星期三所在的日期
                break;
            case 4:
                c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);    //返回星期四所在的日期
                break;
            case 5:
                c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);    //返回星期五所在的日期
                break;
            case 6:
                c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);    //返回星期六所在的曰期
                break;
            case 7:
                c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);    //返回星期曰所在的日期
                break;
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
    }


}
