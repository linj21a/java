package exception_use;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---学生管理系统---\n学生录入信息");
        String name = "";//name
        int age = 0;
        String sex = "";//性别
        try {
            System.out.println("请输入学生的姓名:");
            name = sc.next();
            //sc.skip("\n");设置跳过该字符
            System.out.println("请输入学生的年龄：");
            age = sc.nextInt();
            System.out.println("请输入学生的性别：");
            sex = sc.next();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("输入有误");
        }

        System.out.print("学生的姓名是" + name + "学生的年龄是" + age + "学生的性别是：" + sex);
    }
}
