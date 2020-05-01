package ThreadTest;

/**
 * 验证同步函数使用的是哪一个锁
 */
class Tick2 implements Runnable {
    private static int num = 100;//票数,也代表票的号码或者座位
    //使用同步代码块的时候，琐是固定的，但是可以是任意对象
    final Object ob = new Object();//常常定义为只允许赋值一次的对象锁！
    public boolean flag = true;

    public void run() {
        if (flag) {
            while (true)
                //修改如下
                // synchronized (this){//同步代码块 ob就是锁！！！！！！！
                synchronized (this.getClass()) {//同步代码块 ob就是锁！！！！！！！
                    if (num > 0) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ignored) {
                        }//注意这里可能抛出异常，要么使用try'catch普抓或者声明！注意run无法声明异常
                        System.out.println(Thread.currentThread().getName() + "obj:。。。" + num--);
                    }

                }

        } else {
            while (true)
                show();
        }


    }

    synchronized static void show() {//同步函数
        // synchronized void show(){//同步函数

        if (num > 0) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException ignored) {
            }//注意这里可能抛出异常，要么使用try'catch普抓或者声明！注意run无法声明异常
            System.out.println(Thread.currentThread().getName() + "show:。。。" + num--);
        }
    }

}

public class SynFunctionDemo {
    public static void main(String[] args) {
        Tick2 t1 = new Tick2();
        Thread s1 = new Thread(t1);
        Thread s2 = new Thread(t1);


        s1.start();
        //未加延时之前，主线程执行到这里，还具备cpu的执行权，瞬间就执行完这三条语句，修改了flag，所以我们看到的全是show
        //现在我们修改一下让主线程延时，使得cpu能够进行切换，就能看到show与obj一起买票，但是线程不安全
        try {
            Thread.sleep(10);
        } catch (InterruptedException ignore) {
        }
        //这个时候，我们就能发现有show与obj了。

        //因为发现obj竟然这个时候能卖出0票，而且show与obj都卖出了第98张票，说明同步代码块与同步函数使用的不是同一把锁。

        //现在我们修改同步代码块为this的锁，此时obj与show抢夺资源，一起卖出了100张票，实现同步，多线程安全。
        t1.flag = false;
        //现在我们修改同步函数为静态同步函数，那它肯定无法使用this，又锁一定要是对象，——只能是类加载进方法区时虚拟机创建的类字节码文件对象
        //我们使用this.getClass或者Ticket2.class验证 _此时obj与show抢夺资源，一起卖出了100张票，实现同步，多线程安全。
        s2.start();
        //s3.start();

    }
}
