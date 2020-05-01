package java基础;

import java.text.DecimalFormat;

/**
 * 需求:练习DecimalFormat如何使用来控制输出的十进制格式
 */

public class decimal_test {
    public static void main(String[] args) {
        //首先先创建对象
        DecimalFormat dec = new DecimalFormat();
        int a = 52;
        double d = 12345.66790;
        float f = 12345.444321f;
        System.out.println("dec格式" + dec.format(a));//默认国际标准每3位加，号
        System.out.println("dec格式" + dec.format(d));//默认国际标准每3位加，号,小数部分只支持3位，并且四舍五入。
        System.out.println("dec格式" + dec.format(f));

        //设置格式，使用有参构造函数
        DecimalFormat dec_params = new DecimalFormat("000.00");//只保留2位小数，不足补0
        System.out.println("dec_params:" + dec_params.format(a));//四舍五入
        System.out.println("dec_params:" + dec_params.format(d));//
        System.out.println("dec_params:" + dec_params.format(f));

        /*
        格式的含义：
        0	显示数字，如果位数不够则补 0
        #	显示数字，如果位数不够不发生变化
        .	小数分隔符
        -	减号
        ,	组分隔符
        E	分隔科学记数法中的尾数和小数
        %	前缀或后缀，乘以 100 后作为百分比显示
        ?	乘以 1000 后作为千进制货币符显示。用货币符号代替。如果双写，
         */


    }
}
