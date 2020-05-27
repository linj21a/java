package DateAndDateFormatDemo;

import java.util.Date;

/**public class Date
 extends Date（接口）

 * Date是java里边内置的日期类，里边封装了操作日期的方法。始于jdk1.1版本
 * 我们必须掌握其常用方法：
 * 1、构造器——jdk11里边未过时的两个构造器：（共有6个构造器）
 *              1、1 Date(){this(System.currentTimeMillis());}默认构造器，使用的格式为：
 *              1、2 public Date(long date) {fastTime = date;}使用给定的毫秒时间价值构建 Date对象。
 *                  ——参照日期是date -毫秒自1970年1月1日00:00:00 GMT不超过全年8099毫秒表示。负数表示的毫秒数在1970年1月1日之前，00:00:00 GMT。
 *
 * 2、其他的常用的方法（这里只列出未过时的方法）：
 * boolean after​(Date when) 测试此日期是否在指定日期之后。
 * boolean before​(Date when) 测试此日期是否在指定日期之前。
 * Object clone() 返回此对象的副本。
 * int compareTo​(Date anotherDate) 比较两个日期的订购。
 * boolean equals​(Object obj) 比较两个相等的日期。
 * static Date from​(Instant instant) 从 Instant对象获得 Date的实例。
 * Instance是时间线上的瞬时点。
 * 该类在时间线上模拟单个瞬时点。 这可能用于在应用程序中记录事件时间戳。
 * Long getTime(Date)将日期对象转化为毫秒数。
 * String toString() 将此 Date对象转换为以下形式的 String ：
 */

public class DateDemo {
    public static void main(String[]args){
        //1、缺省构造器
        Date date1 = new Date();
        System.out.println(date1);
        //2、参数为ms的构造器
        Date date2 = new Date(11111111111111L);
        System.out.println(date2);
        //3、下面展示过时的构造器：
        /*date = new Date(10,10,2);//三个参数都是int类型，支持到秒分时。
        System.out.println(date);*/

        //4、判断日期对象date1与date2的先后。基于uct转化为ms计算的结果。
        /*
        return getMillisOf(this) > getMillisOf(when);
         */
        boolean result = date1.after(date2);
        System.out.println(result);

        //其他方法：1、getTime()返回毫秒数
        Long t1 = date1.getTime();
        System.out.println(t1+"ms");

        //过时方法static long parse​(String s)Deprecated.
        //As of JDK version 1.1, replaced by DateFormat.parse(String s).
        /*s中位于ASCII括号内的字符(和)任何材料都将被忽略。 括号可以嵌套。 否则， s中允许的唯一字符是这些ASCII字符
        abcdefghijklmnopqrstuvwxyz
        ABCDEFGHIJKLMNOPQRSTUVWXYZ
        0123456789,+-:/
         */
        long t2 = date2.parse("07/10/96 4:5 PM, PDT");
        System.out.println(t2);
        String s = date1.toString();//返回日期的字符串，基于CST格式星期月份时分秒 中国标准时间。
        System.out.println("string"+s);

        //setYear,setTime,setDate,setMinutes,setHours,setSeconds,setMonth,UTC等
        long t3 = Date.UTC(2015,11,12,10,34,22);
        //与具有六个参数的Date构造函数完全相同，除了参数是相对于UTC解释的而不是当地时区。 返回指示的时间表示为从纪元（1970年1月1日00:00:00 GMT）起的该时间的距离（以毫秒为单位）。
        System.out.println(t3);
    }
}
