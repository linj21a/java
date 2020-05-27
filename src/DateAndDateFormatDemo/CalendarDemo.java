package DateAndDateFormatDemo;

import java.util.Calendar;


/**
 * 日期类date很多方法不适合国际化，于是出现了Calendar来代替。
 * public abstract class Calendar（抽象类）
 * extends Object
 * implements Serializable, Cloneable, Comparable<Calendar>
 *
 *   它的实例化；使用getInstance方法，
 *   它将日期的各个组成按照字段解析封装为键值对。
 *
 *   日历字段可以用三种方法来改变set() ， add()和roll() 。
 *   set()
 *   Date getTime() 返回一个 Date对象，表示此 Calendar的时间值（距离 Epoch的毫秒偏移量）。
 * long getTimeInMillis() 以毫秒为单位返回此Calendar的时间值。
 * TimeZone getTimeZone() 获取时区。
 * int getWeeksInWeekYear() 返回此 Calendar表示的周中的周 Calendar 。
 *
 * abstract void roll​(int field, boolean up) 在给定时间字段上添加或减去（向上/向下）单个时间单位而不更改更大的字段。
 * void roll​(int field, int amount) 将指定的（已签名）金额添加到指定的日历字段，而不更改更大的字段。
 * void set​(int field, int value) 将给定的日历字段设置为给定值。
 * void set​(int year, int month, int date) 设置日历字段的值 YEAR ， MONTH和 DAY_OF_MONTH 。
 * void set​(int year, int month, int date, int hourOfDay, int minute) 设置日历字段的值 YEAR ， MONTH ， DAY_OF_MONTH ， HOUR_OF_DAY和 MINUTE 。
 * void set​(int year, int month, int date, int hourOfDay, int minute, int second) 设置字段中的值 YEAR ， MONTH ， DAY_OF_MONTH ， HOUR_OF_DAY ， MINUTE和 SECOND 。
 * void setFirstDayOfWeek​(int value) 设定一周的第一天是什么; 例如， SUNDAY在美国， MONDAY在法国。
 */
public class CalendarDemo {
    public static void main(String[]args){
        Calendar calendar=Calendar.getInstance();
//        System.out.println(calendar);打印calendar的键值对。如WEEK_OF_YEAR=22,WEEK_OF_MONTH=5
        getCalendar(calendar);
        //set,add ,get乃是常用的方法
        calendar.set(Calendar.YEAR,2015);//将year设置为指定的年份
        getCalendar(calendar);
        calendar.set(2015,11,02,16,20);//2015年12月2日星期四

        getCalendar(calendar);

        calendar.add(Calendar.YEAR,-4);//2011年12月2日星期六   2015+(-4)
        getCalendar(calendar);


    }

    private static void getCalendar(Calendar calendar) {
        //获取日期
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONDAY)+1;//注意了这里是用数组实现的，所以一月是0，12月是11.所以要加一。
        int day = calendar.get(Calendar.DAY_OF_MONTH);//获取月中的第几天

//        接下来获取星期几，get返回的是整数，我们需要转化一下。
        String week = getWeek(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(year+"年"+month+"月"+day+"日"+week);
    }

    private static String getWeek(int i) {
        String []weeks = {"星期日","星期一",
                "星期二","星期三","星期四","星期五","星期六"};
        return weeks[i];
    }
}
