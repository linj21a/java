package RegexLearning;

/**
 * 演示替换功能
 * 使用了String的replaceAll(String regex,String regexment)方法
 *
 * 比如用于电话的加密
 * 13677890673——136****0673

 */

public class Practice1_ReplaceAll {
    public static void main(String[]args){
        String phone = "13677890673";
        System.out.println("加密前："+phone);
        String regex = "(\\d{3})\\d{4}(\\d{4})";//这里使用来捕获组的概念，每个右括号分割为一个组
        //第一组(\\d{3})——数字0~9出现3次
        //第二组(\\d{4})——数字0~9出现4次
        //中间的\\d{4}单独作为匹配

        phone = phone.replaceAll(regex,"$1****$2");//$1表示匹配组1,$2表示匹配组2，中间是替换的字母
        System.out.println("加密后："+phone);
    }
}
