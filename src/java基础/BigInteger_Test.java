package java基础;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 目的：实现大数据整数的运算。
 */

public class BigInteger_Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个整型数字：");
        // 用户输入的数字
        int num = input.nextInt();

        // 使用输入的数字创建BigInteger对象
        BigInteger bi = new BigInteger(num + "");//参数必须为字符串

        // 计算大数字加上99的结果
        System.out.println("加法操作结果：" + bi.add(new BigInteger("99")));

        // 计算大数字减去25的结果
        System.out.println("减法操作结果：" + bi.subtract(new BigInteger("25")));

        // 计算大数字乘以3的结果
        System.out.println("乘法橾作结果：" + bi.multiply(new BigInteger("3")));

        // 计算大数字除以2的结果
        System.out.println("除法操作结果：" + bi.divide(new BigInteger("2")));

        // 计算大数字除以3的商
        System.out.println("取商操作结果：" + bi.divideAndRemainder(new BigInteger("3"))[0]);//返回BigInteger数组

        // 计算大数字除以3的余数
        System.out.println("取余操作结果：" + bi.divideAndRemainder(new BigInteger("3"))[1]);

        // 计算大数字的2次方
        System.out.println("取 2 次方操作结果：" + bi.pow(2));

        // 计算大数字的相反数
        System.out.println("取相反数操作结果：" + bi.negate());
    }
}