package RuntimeDemo;

import java.io.IOException;
import java.util.Scanner;

/**
 * Runtime类是每个应用程序都有的一个类，它无法被实例化，但是又因为它里边的方法并非
 * 全为静态——所以我们能想到它的构造器是私有的，但必有一个方法用于返回一个实例对象。即
 *
 * 使用了单例设计模式。——getRuntime()
 * 常用的方法：
 * 1、Process exec(String command);在一个进程里边执行指定的命令
 * 2、static Runtime getRuntime()——返回与当前应用程序相关的java运行时对象。
 *
 * 进程类：public abstract class Process extends Object是抽象类，无法实例化的
 * 常见方法：
 * 1、abstract void destroy()
 * 杀死子进程。
 * 2、Process destroyForcibly()
 * 杀死子进程。
 * 3、abstract int exitValue()
 * 返回子进程的退出值。
 */

public class SingleDesignDemo {
    public static void main(String... args) throws IOException {
        Runtime r = Runtime.getRuntime();
        Process p = r.exec("notepad");//返回的是管理过程的新 Process对象
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        if(i==1){
            p.destroy();//杀死记事本这个子进程
        }
        r.gc();
//        r.exec("notepad E:\\words.txt");//使用记事本打开对应的文件
       // r.exec("QQ.exe");//因为虚拟机找了当前的文件有没有QQ.exe,没有就去系统path里边找，也没有，就报错！
        //java.io.IOException: CreateProcess error=2, 系统找不到指定的文件。

    }
}
