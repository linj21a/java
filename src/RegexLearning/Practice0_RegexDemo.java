package RegexLearning;

/**
 * 正则表达式学习：
 * 正则表达式使用来操作字符串的匹配的
 *
 * 相关用途为：
 * 1、匹配
 *      使用String的match(String regex);
 *          ——实际上底层调用的都是Pattern的方法
 * 2、切割
 *      使用String的split(String regex)方法
 *          ——实际上底层调用的都是Pattern的方法
 * 3、替换
 *      使用String的replaceAll​(String regex, String replacement)
 *          ——实际上底层调用的都是Pattern的方法
 * 4、获取
 * 使用了正则表达式的封装对象
 * Pattern——正则表达式的样式表达对象
 * Matcher——正则表达式的匹配器

 第一步创建Pattern对象，使用compile，它没有构造器。参数是一个正则表达式字符串
 *  Pattern p = Pattern.compile("a*b");
 *  Matcher m = p.matcher("aaaaab");//使用matcher方法进行匹配返回一个匹配器对象
 *  boolean b = m.matches();//开始匹配matcher，返回匹配的结果。
 *这个类定义matches方法是为了方便正则表达式只使用一次。该方法编译一个表达式，并在一次调用中根据它匹配输入序列。该声明
 *  boolean b = Pattern.matches("a*b", "aaaaab");
 * 与上面的三个语句相同，但是对于重复匹配，它的效率较低，因为它不允许重用已编译的模式。
 * 该类的实例是不可变的，并且对于多个并发线程来说是安全的。Matcher类的实例对于这样的使用是不安全的。
 */

public class Practice0_RegexDemo {
    public static void main(String[]args){
        System.out.println("正则表达式！");
    }
}
