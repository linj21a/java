package ThreadTest;

/**
 * 演示买票例子
 * 使用四个线程模拟四个窗口，进行卖票
 * 当继承thread来实现多线程买票时，可以使用static修饰num
 * 现在我们使用implements Runnable接口，演示多线程安全问题。
 * <p>
 * 发现加了延时线程的执行以后，我们就能发现线程安全问题的存在
 * Thread-0卖出票号为:。。。0
 * Thread-3卖出票号为:。。。0
 * Thread-2卖出票号为:。。。0
 * //我们都没有票号为0 的票，竟然能卖出去，这是因为
 * <p>
 * 多线程任务代码里边，1：存在多线程访问，2，操作共享数据的语句有多条
 * <p>
 * 这就有可能发生线程安全问题
 * <p>
 * 解决办法——同步代码块(锁为任意对象)或者同步函数（锁只能是this）
 * 涉及关键字 synchronized
 */
class Tick implements Runnable {
    private int num = 100;//票数,也代表票的号码或者座位
    //使用同步代码块的时候，琐是固定的，但是可以是任意对象
    final Object ob = new Object();//常常定义为只允许赋值一次的对象锁！

    public void run() {
        while (true)
            //修改如下
           synchronized (ob) {//ob就是锁！！！！！！！
                if (num > 0)
                    show();
            }


    }

    void show() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException ignored) {
        }//注意这里可能抛出异常，要么使用try'catch普抓或者声明！注意run无法声明异常
        System.out.println(Thread.currentThread().getName() + "卖出票号为:。。。" + num--);
    }

}

public class TicketDemo1 {
    public static void main(String[] args) {
        Tick tick = new Tick();
        Thread t1 = new Thread(tick);
        Thread t2 = new Thread(tick);
        Thread t3 = new Thread(tick);
        Thread t4 = new Thread(tick);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}
