package java基础;

import java.util.Scanner;

/**
 * @author Lh
 * @versi jdk 1.11.0
 * 需求：演示正则表达式匹配电话号码及邮箱
 */

public class regex_Demo {
    public static void main(String[] args) {
        //匹配固定电话或者移动电话
        String regex_phone = "0\\d{2,3}[-]?\\d{7,8}|0\\d{2,3}\\s?\\d{7,8}|13[0-9]\\d{8}|15[1089]\\d{8}";
        //匹配邮箱，分名称，域名
        String regex_email = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";//^匹配开头，$匹配末尾
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入电话：");
        String phone_number = sc.next();
        System.out.println("请输入邮箱：");
        String emil_number = sc.next();
        boolean result_p = phone_number.matches(regex_phone);
        boolean result_e = emil_number.matches(regex_email);

        if (result_p) {
            System.out.println("电话格式匹配成功！");
        } else {
            System.out.println("电话格式匹配错误！");
        }
        if (result_e) {
            System.out.println("邮箱格式匹配成功！");
        } else {
            System.out.println("邮箱格式匹配错误！");
        }

    }
}
