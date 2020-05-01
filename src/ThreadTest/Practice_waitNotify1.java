package ThreadTest;

/**
 * //第一次代码，线程不安全的实例，因为多个线程，存在多条操作共享资源的语句，所以有线程安全问题。
 * <p>
 * 一个例子说明线程之间通信的变换
 * 比如拉矿，放矿。线程通信是多个线程对共同的资源进行不同的任务
 * 一个线程负责拉矿，一个负责放矿，资源   煤块,属性是软,，铁矿，属性是硬
 * 如何保证拉一次，放一次。还要线程安全呢？
 */
class MeiKuai {
    String resource;
    String shux;
}

class FangMei implements Runnable {
    MeiKuai r;

    FangMei(MeiKuai m) {
        r = m;
    }

    public void run() {//负责放矿——设置资源属性
        int x = 0;//0就去拉铁，1就去拉煤
        while (true) {
            if (x == 0) {
                r.resource = "tie";
                r.shux = "hard";
            } else {
                r.resource = "煤";
                r.shux = "软";
            }
            x = (x + 1) % 2;//实现任务拉铁与煤的切换

        }
    }

}

class LaMei implements Runnable {
    MeiKuai r;

    LaMei(MeiKuai m) {
        r = m;
    }

    public void run() {//负责拉矿
        while (true) {
            System.out.println(r.resource + "....." + r.shux);
        }


    }
}

public class Practice_waitNotify1 {
    public static void main(String[] args) {
        //第一次代码，线程不安全的实例
        MeiKuai meiKuai = new MeiKuai();
        FangMei f = new FangMei(meiKuai);
        LaMei l = new LaMei(meiKuai);

        //创建线程
        Thread t1 = new Thread(f);
        Thread t2 = new Thread(l);
        t1.start();
        t2.start();

    }
}
