package RegexLearning;

import java.util.Scanner;

/**
 * 练习匹配功能。
 * 给定一个手机号码：进行匹配。【11位数，开头只允许1，第二位只能是3、5、8；之后的数字都是0——9】
 *
 */

public class Practice1_Match {
    public static void main(String[]args){
        System.out.println("请输入一个手机号码：");
        Scanner input = new Scanner(System.in);
        String phone = input.nextLine();
        String myregex = "[1][358][0-9]{9}";//优化结构："[1][358]\\d{9}"
        //myregex = "[1][358]\\d{9}";
        boolean res = phone.matches(myregex);
        System.out.println("你输入的手机号码匹配结果："+res);

    }
}
