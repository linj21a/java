package DateAndDateFormatDemo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * public abstract class DateFormat
 * extends Format
 * DateFormat是日期/时间格式化子类的抽象类，它以与语言无关的方式格式化和分析日期或时间。
 * 日期/时间格式化子类（例如SimpleDateFormat ）允许格式化（即，日期→文本），解析（文本“日期”）和规范化。
 * 日期表示为Date对象或自1970年1月1日00:00:00 GMT以来的毫秒数。
 * 日期的格式控制，基于date的进行改进。
 *
 *
 * 要格式化当前Locale的日期，请使用以下静态工厂(我们的单例设计模式就是一种静态工厂方法)方法之一：
 *  myString = DateFormat.getDateInstance().format(myDate);
 *静态工厂方法：
 * static DateFormat getDateInstance() 获取具有默认 FORMAT语言环境的默认格式样式的日期格式化程序。
 * static DateFormat getDateInstance​(int style) 获取具有默认 FORMAT语言环境的给定格式样式的日期格式化程序。
 * static DateFormat getDateInstance​(int style, Locale aLocale) 获取具有给定语言环境的给定格式样式的日期格式化程序。
 * static DateFormat getDateTimeInstance() 获取具有默认 FORMAT语言环境的默认格式样式的日期/时间格式化程序。
 * static DateFormat getDateTimeInstance​(int dateStyle, int timeStyle) 获取具有默认 FORMAT语言环境的给定日期和时间格式样式的日期/时间格式化程序。
 * static DateFormat getDateTimeInstance​(int dateStyle, int timeStyle, Locale aLocale) 获取具有给定语言环境的给定格式样式的日期/时间格式化程序。
 * static DateFormat getInstance() 获取一个默认的日期/时间格式化程序，它使用SHORT样式作为日期和时间。
 *
 * 常用格式控制字段
 * 1、static int LONG 长款式的常量。
 * 2、static int FULL 完整样式模式的常量。
 * 3、static int MEDIUM 中等风格图案的常量。
 * 4、static int SHORT 短款式的常量。
 *
 * 就是规定了一个日期的格式，然后你传进来的date我都能变为这样的格式。
 *
 * 但是它无法自定义日期的格式，因为工厂模式全都带有内置的格式。
 *  ——我们想到了它的子类——SimpleDateFormat
 *     SimpleDateFormat是一个用于以区域设置敏感的方式格式化和解析日期的具体类。 它允许格式化（日期→文本），解析（文本→日期）和规范化
 *     里边有模式表，我们可以根据模式表来自定义格式
 *
 *     相关构造器:
 *     1、SimpleDateFormat() 构造一个 SimpleDateFormat使用默认模式和日期格式符号默认 FORMAT区域设置。
 *      2、SimpleDateFormat​(String pattern) 构造一个 SimpleDateFormat使用给定的模式和默认的默认日期格式符号 FORMAT区域设置。
 *        3、SimpleDateFormat​(String pattern, DateFormatSymbols formatSymbols) 使用给定的模式和日期格式符号构造 SimpleDateFormat 。
 *         4、SimpleDateFormat​(String pattern, Locale locale) 使用给定模式和给定语言环境的默认日期格式符号构造 SimpleDateFormat
 *
 *  重点应用——日期转字符串——Dateformat /SimpleDateFormat的format()
 *  _字符串转为日期——使用DateFormat的 Date parse​(String text, ParsePosition pos) 解析字符串中的文本以生成 Date 。
 */

public class DateFormatDemo1 {
    public static void main(String[]args) throws ParseException {

        //源代码：return get(0, DEFAULT, 2, Locale.getDefault(Locale.Category.FORMAT));
        //具备默认的格式——Locale.Category.FORMAT，只获取日期
        DateFormat dateFormat = DateFormat.getDateInstance();//使用默认的静态方法
        System.out.println(dateFormat);//这样打印的是包信息+类信息以及其哈希码。
        Date date = new Date();
        String ds = dateFormat.format(date);
        System.out.println(ds);

        //获取日期加时间
        dateFormat = DateFormat.getDateTimeInstance();
        ds = dateFormat.format(date);
        System.out.println(ds);

        //使用字段控制格式
        dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.LONG);//日期时间全
        ds = dateFormat.format(date);
        System.out.println(ds);

        //Date
        dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);//日期 Medium 2020年5月24日 Short 2020/5/24
        ds = dateFormat.format(date);
        System.out.println(ds);

        SimpleDateFormat mydate = new SimpleDateFormat("yy:MM:dd");//注意要和时间日期模板里边的定义一致yy表示一年的年，MM表示年的月。DD表示年的天
        System.out.println(mydate.format(date));

        String inputdate = "2012:2:24";
        date = mydate.parse(inputdate);
        System.out.println(date);//Exception in thread "main" java.text.ParseException Unparseable date: "2012224" 抛出异常，不一定能转



    }
}
