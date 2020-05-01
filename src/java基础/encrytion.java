package java基础;

import java.util.Scanner;

public class encrytion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("进行加密的字符串是：\n" + str + "\n加密以后的字符串是：");
        //将获取的字符串转成字符数组
        char[] c = str.toCharArray();//记忆！
        //加密
        for (int i = 0; i < str.length(); i++) {
            c[i] = (char) (c[i] ^ 2000);//异或得到的是int，进行强制转换
            System.out.print(c[i]);
        }
        System.out.println();
        System.out.println("解密字符串是：");

        //解密
        for (int i = 0; i < str.length(); i++) {
            c[i] = (char) (c[i] ^ 2000);//异或得到的是int，进行强制转换
            System.out.print(c[i]);
        }
        System.out.println();


    }
}
