/**
 * 需求:不使用第三方变量交换两个数的值。
 * 实现步骤：方法1，a = a +b; b = a-b; a =a-b;但是该方法有范围溢出的风险，比较两个整数相加。
 * 方法2：利用同一个数异或一个数两次得到其本身实现。效率最高，最安全。
 * 代码设计：使用两个函数实现上面两个方法。
 */


package java基础;

import java.util.Scanner;

public class ExchangeTwoInteger {
    public static void main(String[] args) {
        int a, b;
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        b = input.nextInt();
        System.out.println("原来的a=" + a + ",b=" + b);
        a ^= b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("交换以后的a=" + a + ",b=" + b);
        sWap(a, b);
        System.out.println("调用Integer方法交换以后的a=" + a + ",b=" + b);
        int[] c = new int[2];
        c[0] = a;
        c[1] = b;
        sWap(c);
        System.out.println("调用数组方法交换以后的a=" + c[0] + ",b=" + c[1]);

    }

    public static void sWap(Integer a, Integer b) {//不行
        int temp = a.intValue();
        a = b;
        b = temp;
    }

    //使用加减法
    public static int[] sWap(int[] a) {
        int temp = a[0];
        a[0] = a[1];
        a[1] = temp;
        return a;
    }
}

