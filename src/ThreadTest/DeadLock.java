package ThreadTest;

/**
 * 目的：编写一个程序演示死锁——锁中有锁，，嵌套同步。我们一定要避免死锁！
 */

class DeanDemo implements Runnable {
    public boolean flag;

    DeanDemo(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        if (flag) {
            while (true)
                synchronized (MyLock.locka) {
                    System.out.println(Thread.currentThread().getName() + "。。。在持有lockaA，准备进入下一个锁");
                    synchronized (MyLock.lockb) {
                        System.out.println(Thread.currentThread().getName() + "成功进入");
                    }
                }

        } else {
            while (true)
                synchronized (MyLock.lockb) {
                    System.out.println(Thread.currentThread().getName() + "。。。持有lockB，准备进入下一个锁");
                    synchronized (MyLock.locka) {
                        System.out.println(Thread.currentThread().getName() + "成功进入");

                    }
                }
        }

    }
}

//定义我的锁
class MyLock {
    public static MyLock locka = new MyLock();
    public static MyLock lockb = new MyLock();

}

public class DeadLock {
    public static void main(String[] args) {
        DeanDemo d1 = new DeanDemo(true);
        DeanDemo d2 = new DeanDemo(false);
        //创建两个线程让他们争锁
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        t1.start();
        t2.start();
        //两个线程互相争锁，谁也不让，程序卡在哪里
    }
}
