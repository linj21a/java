package RegexLearning;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 演示功能4——获取
 * 第一步、将正则表达式编译为Pattern实例对象
 * 第二步、使用matcher(str)方法获取匹配器
 * Matcher
 * 第三步、使用Matcher里边的方法来操作如何匹配字符串及匹配的结果字串
 * boolean：
 * find——通过扫描整个字符串序列返回找到的下一个字符字串、
 * matchers()——尝试使用编译好的正则规则去匹配整个字符串序列，返回匹配的结果、
 * LookingAt——就是利用编译好的正则规则去匹配最先匹配成功的字符串，也就是说它不需要匹配完整个字符串序列。
 * 与matchers类似却不同。—— public boolean lookingAt() {
 *                           return match(from, NOANCHOR);
 *                           }
 *
 * String group(String name)——返回给定命名捕获组在前一个匹配操作中捕获的输入子序列。
 *
 * 需求：给定一个字串，找出其中的三个英文字母组成的单词。
 *
 */

public class Practice1_MatcherAndPattern {
    public static void main(String[]args){
        String str = "min,Amy John,yours,no  Love cat";

        //定义正则表达式并编译为Pattern对象
        String regex = "\\b[a-zA-Z]{3}\\b";//之前："[a-zA-Z]{3}"，导致love被匹配到了lov，
        //现在： "\\b[a-zA-Z]{3}\\b"加了一个匹配边界的限定。——\b	A word boundary
        Pattern p = Pattern.compile(regex);

        //获取匹配器对象
        Matcher m = p.matcher(str);//这个匹配器是针对str字串的

        //利用匹配器中的方法，对字符串进行操作

        //1、matchers
       /* System.out.println("matches result:"+m.matches());//false,因为是对整个字符串进行正则匹配，自然是false
        System.out.println("lookingAt result:"+m.lookingAt());//true,因为只要字符串的某个部分匹配正则表达式。
        System.out.println("find result:"+m.find());//true,与lookingAt类似*/

        //使用group方法获取匹配到的字串单词
        while(m.find()){//注意使用group方法之前一定要进行匹配：三种办法matches，find，lookingAt
            System.out.println(m.group());
            System.out.println(m.start()+":"+m.end());
        }
            /*
            min
            0:3——所匹配的子串单词索引
            Amy
            4:7
            Joh
            8:11
            you
            13:16
            Lov——发现了一个问题，love是4个字母匹配进来了。
            说明我们的正则表达式还不好。——现在修改为："\\b[a-zA-Z]{3}\\b"
            23:26
            cat
            28:31
             */

            //现在的结果：min
        //0:3
        //Amy
        //4:7
        //cat
        //28:31

    }
}
