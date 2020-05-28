package Stream_IntOut;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * 目的：使用random创建一个随机数，用户有五次试玩机会，试玩以后需要收费，
 * 收费以后次数破解。
 * 模块：
 * 使用一个文件动态保存当前剩下的试玩次数；使用另一个文件保存当前游戏客户是否已经注册及有一个状态flag记录付费状态
 * game模块控制游戏的进行,数字产生，gameWin判断游戏是否赢，给出大了还是小了的提示，register模块控制登陆，
 * getMoney模块用来付费
 */

public class RandomNumberGame {
    public static void main(String[] args) throws IOException {


        RandomNumberGame start = new RandomNumberGame();
        System.out.println("第一次试玩，有五次免费机会");
        start.game(5, false);
        System.out.println("试玩结束！");
        Scanner sc = new Scanner(System.in);
        //1.请输入你的账号密码或者选择注册（0表示输入账号密码；1表示选择注册）
        System.out.println("选择登陆还是注册（0表示登陆；1表示选择注册）");
        byte i = sc.nextByte();
        if (i >= 1) {
            //注册
            start.register();
        } else {
            //输入密码登陆
            boolean res = false;
            while (!res) {
                res = start.admin();
            }
        }
        System.out.println("是否充值？1是，2否");
        int mon = sc.nextInt();
        if (mon == 1)
            start.getMoney();
        System.out.println("是否开始游戏？1是，2否");
        int g;
        g = sc.nextInt();
        while (g == 1) {
            //获取状态flag
            boolean flag = start.getFlag();
            //开始游戏
            start.game(5, flag);
            System.out.println("是否继续游戏？1是，2否");
            g = sc.nextInt();
        }
        System.out.println("游戏结束，退出登陆。再见！");


    }

    /**
     * 该函数用于注册账号
     */
    public void register() throws IOException {
        String use = null, password = null;
        Scanner input = new Scanner(System.in);
        boolean result1, result2, flag = false;
        while (!flag) {
            System.out.println("请输入账号（账号仅由字母组成，最多10位");
            use = input.next();
            String regex1 = "\\w{0,10}";
            result1 = use.matches(regex1);

            System.out.println("请输入密码（密码由字母或者数字构成，10位");
            String regex2 = "[a-zA-Z0-9_-]{10}";
            password = input.next();
            result2 = password.matches(regex2);
            if (result1 && result2) {
                flag = true;
            } else
                System.out.println("账号或者密码格式有误！请重新输入");

        }
        System.out.println("输入完成，注册中...");
        //创建文件进行保存账号
        RandomAccessFile source_admin = new RandomAccessFile("E:/source_admin.txt", "rw");
        byte[] buffer;
        buffer = (use + "\r\n" + password).getBytes();
        source_admin.write(buffer);
        //默认普通用户
        RandomAccessFile f = new RandomAccessFile("E:/flag.txt", "rw");
        byte[] buff;
        buff = ("flag=0").getBytes();
        f.write(buff);

        f.close();
        source_admin.close();
        System.out.println("注册完成！");

    }

    /**
     * 游戏的开始模块
     *
     * @param count 使用的次数，付费情况下拥有无限次数
     * @param flag  用户是否付费
     */
    public void game(int count, boolean flag) {
        Scanner input = new Scanner(System.in);
        Random rd = new Random();
        int number = rd.nextInt(10);//随机产生一个0到10的整数
        while (count > 0) {
            if (flag) {
                count = Integer.MAX_VALUE;//重新赋值实现无线次数
            }
            System.out.println("请输入你猜测的数字（剩余次数" + count + ")");
            int mumbler = input.nextInt();

            if (mumbler > number) {
                System.out.println("大了！");
                count--;
            }
            if (mumbler < number) {
                System.out.println("小了！");
                count--;
            }
            if (mumbler == number) {
                System.out.println("你猜对了！游戏胜利");
                return;

            }


        }
    }

    /**
     * 游戏充值模块
     */
    public void getMoney() throws IOException {
        System.out.println("请再次确认是否进行充值？1：是，2：否");
        Scanner sc = new Scanner(System.in);
        byte b = sc.nextByte();

        RandomAccessFile f = new RandomAccessFile("E:/flag.txt", "rw");
        if (b == 1) {
            //读取flag文件修改其中的flag参数
            byte[] buff;
            buff = ("flag=1").getBytes();
            f.write(buff);
            f.close();
            System.out.println("付费成功！你已经是vip客户，开始畅行游戏！");
        } else {
            //读取flag文件修改其中的flag参数
            byte[] buff;
            buff = ("flag=0").getBytes();
            f.write(buff);
            f.close();
            System.out.println("付费失败！");
        }
    }

    /**
     * 游戏登陆模块
     *
     * @return 返回登陆的结果
     */
    public boolean admin() {
        //实现登陆
        String use;
        String password;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号");
        use = sc.next();
        System.out.println("请输入密码");
        password = sc.next();
        try {
            RandomAccessFile f = new RandomAccessFile("E:/source_admin.txt", "r");
            String f1, f2;
            f1 = f.readLine();
            f2 = f.readLine();
            System.out.println(f1 + "\n" + f2);
            if (use.equals(f1) && password.equals(f2)) {
                System.out.println("登陆成功！");
                return true;
            } else {
                System.out.println("登陆错误，请检查你账号或密码");
                return false;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 判断当前客户是否是vip客户
     *
     * @return 布尔值，判断的标记
     */
    public boolean getFlag() {
        try {
            RandomAccessFile f = new RandomAccessFile("E:/flag.txt", "r");
            if (f.readLine().equals("flag=1")) {
                f.close();
                return true;
            } else {
                f.close();
                return false;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }

    }
}
