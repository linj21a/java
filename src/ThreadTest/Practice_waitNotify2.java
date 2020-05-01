package ThreadTest;

/**
 * 第二次实例——修改为线程安全，使用同一个锁，多个线程必须在同一个锁下同步
 * //第二次代码，解决了线程安全，但是没有我们预期的功能！拉一次放一次
 */
class FangMei1 implements Runnable {
    MeiKuai r;

    FangMei1(MeiKuai m) {
        r = m;
    }

    public void run() {//负责放矿——设置资源属性
        int x = 0;//0就去拉铁，1就去拉煤
        while (true) {
            synchronized (r) {
                if (x == 0) {
                    r.resource = "tie";
                    r.shux = "hard";
                } else {
                    r.resource = "煤";
                    r.shux = "软";
                }
            }

            x = (x + 1) % 2;//实现任务拉铁与煤的切换

        }
    }

}

class LaMei1 implements Runnable {
    MeiKuai r;

    LaMei1(MeiKuai m) {
        r = m;
    }

    public void run() {//负责拉矿
        while (true) {
            synchronized (r) {
                System.out.println(r.resource + "....." + r.shux);
            }

        }


    }
}

public class Practice_waitNotify2 {
    public static void main(String[] args) {
        //第二次代码，解决了线程安全，但是没有我们预期的功能！拉一次放一次
        MeiKuai meiKuai = new MeiKuai();
        FangMei1 f = new FangMei1(meiKuai);
        LaMei1 l = new LaMei1(meiKuai);

        //创建线程
        Thread t1 = new Thread(f);
        Thread t2 = new Thread(l);
        t1.start();
        t2.start();
        //为什么会一片一片的输出同样的内容？因为使用同一个锁，假设切到了放矿，一直重复赋值，
        //当切换到拉矿，则不可能只输出一次，所以一片一片

    }
}
