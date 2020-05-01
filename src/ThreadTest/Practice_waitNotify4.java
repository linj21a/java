package ThreadTest;

/**
 * 将代码再次优化，加强封装性，我们的资源显然是不允许直接访问的！
 * 第四次代码_适合企业开发的模式！
 * 等待/唤醒机制。
 * <p>
 * 涉及的方法：
 * <p>
 * 1，wait(): 让线程处于冻结状态，被wait的线程会被存储到线程池中。
 * 2，notify():唤醒线程池中一个线程(任意).
 * 3，notifyAll():唤醒线程池中的所有线程。
 * <p>
 * 这些方法都必须定义在同步中。
 * 因为这些方法是用于操作线程状态的方法。
 * 必须要明确到底操作的是哪个锁上的线程。
 * <p>
 * 为什么操作线程的方法wait notify notifyAll定义在了Object类中？
 * <p>
 * 因为这些方法是监视器的方法。监视器其实就是锁。
 */
class MeiKuai3 {
    private String resource;
    private String shux;
    boolean flag = false;//刚开始没有资源

    //定义方法使得我们可以访问资源设置资源，
    public synchronized void set(String resource, String shux) {
        if (this.flag)
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        this.shux = shux;
        this.resource = resource;
        flag = true;//修改为已经放资源了
        this.notify();
    }

    public synchronized void out() {
        if (!flag)
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        System.out.println(resource + "....." + shux);
        flag = false;
        this.notify();//唤醒放矿的兄弟
    }
}

class FangMei3 implements Runnable {
    MeiKuai3 r;

    FangMei3(MeiKuai3 m) {
        r = m;
    }

    public void run() {//负责放矿——设置资源属性
        int x = 0;
        while (true) {
            if (x == 0) {
                r.set("tie", "hard");
            } else {
                r.set("煤", "软");
            }
            x = (x + 1) % 2;

        }
    }

}

class LaMei3 implements Runnable {
    MeiKuai3 r = null;

    LaMei3(MeiKuai3 m) {
        r = m;
    }

    public void run() {//负责拉矿
        while (true) {
            r.out();
        }
    }
}

public class Practice_waitNotify4 {
    public static void main(String[] args) {
        //第三次代码，解决了线程安全，有我们预期的功能！拉一次放一次
        MeiKuai3 meiKuai = new MeiKuai3();
        FangMei3 f = new FangMei3(meiKuai);
        LaMei3 l = new LaMei3(meiKuai);

        //创建线程
        Thread t1 = new Thread(f);
        Thread t2 = new Thread(l);
        t1.start();
        t2.start();
        //为什么会一片一片的输出同样的内容？因为使用同一个锁，假设切到了放矿，一直重复赋值，
        //当切换到拉矿，则不可能只输出一次，所以一片一片

    }
}
