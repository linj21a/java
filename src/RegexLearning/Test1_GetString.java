package RegexLearning;

/**
 * 正则表达式练习1：治疗口吃
 * 给定一个字符串
 * 匹配出其正确的理解意思：
 * 字符串：我我我我我.....要要要要要.....学学..编编....编..程程.....程
 */

public class Test1_GetString {
    public static void main(String[]args){
        String str = "我我我我我.....要要要要要.....学学..编编....编..程程.....程";
        System.out.println("源字符串："+str);//我我我我我.....要要要要要.....学学..编编....编..程程.....程

        //1、考虑使用什么功能——替换replaceAll()方法
        //先去除...
        str = str.replaceAll("\\.","");
        System.out.println("去除..："+str);//我我我我我要要要要要学学编编编程程程
        //替换重复的部分——组的概念来去除重复或者替换
        str = str.replaceAll("(.)\\1+","$1");//匹配一次或者多次，然后用当前的第一组替换
        System.out.println("去除叠词："+str);//我要学编程
    }
}
