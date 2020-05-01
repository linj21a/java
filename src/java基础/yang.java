package java基础;

import java.util.Scanner;

/**
 * 需求：输入一个整数表示行，输出对应的行数的杨辉三角
 * 实现步骤:定义两个方法，分别为 计算对应行列的值，控制空格数与输出。
 *
 * @author lh_coder
 * @version 1.0
 */

public class yang {
    public static void main(String[] args) {
        int row;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要打印的行数：\n");
        row = sc.nextInt();
        calculate(row);

    }

    //num() 方法用于计算第 x 行第 y 列的数值。
    public static int number(int x, int y) {
        if (y == 1 || y == x) {
            return 1;
        }
        //第x行，第y列 = 上面一列的两个数的和。
        return number(x - 1, y - 1) + number(x - 1, y);

    }

    //在该方法中传入一个 int 类型的参数，该参数表示打印杨辉三角形的行数。
    public static void calculate(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) { // 打印空格后面的字符, 从第1 列开始往后打印
                System.out.print(number(i, j) + " ");
            }
            System.out.println();
        }
    }
}
