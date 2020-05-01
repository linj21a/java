package ThreadTest;

/**
 * 第三次实例——修改为线程安全，使用同一个锁，多个线程必须在同一个锁下同步
 * 解决了线程安全，同时做到我们预期的功能！拉一次放一次
 */
class MeiKuai2 {
    String resource;
    String shux;
    boolean flag = false;//刚开始没有资源
}

class FangMei2 implements Runnable {
    MeiKuai2 r;

    FangMei2(MeiKuai2 m) {
        r = m;
    }

    public void run() {//负责放矿——设置资源属性
        int x = 0;//0就去拉铁，1就去拉煤
        while (true) {
            synchronized (r) {
                if (r.flag)
                    try {
                        r.wait();
                    } catch (InterruptedException e) {
                    }

                if (x == 0) {
                    r.resource = "tie";
                    r.shux = "hard";
                } else {
                    r.resource = "煤";
                    r.shux = "软";
                }
                r.flag = true;//修改已经放资源了
                r.notify();//唤醒拉煤的那个家伙,注意这里不加r是无法知道去哪一个线程池唤醒，就会报错

            }

            x = (x + 1) % 2;//实现任务放铁与煤的切换

        }
    }

}

class LaMei2 implements Runnable {
    MeiKuai2 r;

    LaMei2(MeiKuai2 m) {
        r = m;
    }

    public void run() {//负责拉矿
        while (true) {
            synchronized (r) {
                if (!r.flag)
                    try {
                        r.wait();
                    } catch (InterruptedException e) {
                    }
                System.out.println(r.resource + "....." + r.shux);
                r.flag = !r.flag;
                r.notify();//唤醒放矿的兄弟
            }

        }


    }
}

public class Practice_waitNotify3 {
    public static void main(String[] args) {
        //第三次代码，解决了线程安全，有我们预期的功能！拉一次放一次
        MeiKuai2 meiKuai = new MeiKuai2();
        FangMei2 f = new FangMei2(meiKuai);
        LaMei2 l = new LaMei2(meiKuai);

        //创建线程
        Thread t1 = new Thread(f);
        Thread t2 = new Thread(l);
        t1.start();
        t2.start();
        //为什么会一片一片的输出同样的内容？因为使用同一个锁，假设切到了放矿，一直重复赋值，
        //当切换到拉矿，则不可能只输出一次，所以一片一片

    }
}
