package exception_use;

import java.util.Scanner;
import java.util.InputMismatchException;//导入输入的类型匹配错误的异常类型
public class Test3 {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println("请输入班级总人数：");
                int count = input.nextInt();
                System.out.println("请输入总成绩：");
                int score = input.nextInt();
                int avg = score / count; // 获取平均分
                System.out.println("本次考试的平均分为：" + avg);
            } catch (InputMismatchException e1) {
                System.out.println("输入数值有误！");
            } catch (ArithmeticException e2) {//各种异常类型
                System.out.println("输入的总人数不能为0！");
            } catch (Exception e3) {
                e3.printStackTrace();
                System.out.println("发生错误！" + e3.getMessage());
            }
        }

}
