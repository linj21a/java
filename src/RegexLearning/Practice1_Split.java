package RegexLearning;

/**
 * 演示切割功能。
 * split(regex)
 * 给定一个字符串，切割出需要的字串。
 */
public class Practice1_Split {
    public static void main(String[]args){
        String name = "zhaoliu    lisi    zhoulong";
        //现在需要将名字提取并打印
        String regex = " +";//匹配空格至少一次
        String []names = name.split(regex);
        for(String s:names){
            System.out.println("姓名："+s);
        }
        name = "zhaoliuMMMMMMMMlisiTTTTTzhoulong";
        regex = "(.)\\1+";//使用来捕获组的概念，(.)表示一组，\\1表示该组出现一次，+号表示至少出现一次。
        names = name.split(regex);
        for(String s:names){
            System.out.println("捕获组姓名："+s);
        }


    }
}

