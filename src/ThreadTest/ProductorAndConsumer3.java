package ThreadTest;

import java.util.concurrent.locks.*;

/**
 * 使用jdk1.5以后，java5以后的新的更为灵活的锁的使用方法来改写程序，消灭while
 * 与notifyAll带来的线程效率问题
 * Condition Lock
 * jdk1.5以后将同步和锁封装成了对象。
 * 并将操作锁的隐式方式定义到了该对象中，
 * 将隐式动作变成了显示动作。
 * <p>
 * Lock接口： 出现替代了同步代码块或者同步函数。将同步的隐式锁操作变成现实锁操作。
 * 同时更为灵活。可以一个锁上加上多组监视器。
 * lock():获取锁。
 * unlock():释放锁，通常需要定义finally代码块中。
 * <p>
 * <p>
 * Condition接口：出现替代了Object中的wait notify notifyAll方法。
 * 将这些监视器方法单独进行了封装，变成Condition监视器对象。
 * 可以任意锁进行组合。
 * await();
 * signal();
 * signalAll();
 */
class Resourse1 {
    private String name = null;
    private int count = 0;
    public boolean flag = false;
    Lock mylock = new ReentrantLock();
    Condition con_condition = mylock.newCondition();
    Condition pro_condition = mylock.newCondition();

    void set(String name) {
        mylock.lock();//获取锁
        try {
            while (flag) {
                try {
                    pro_condition.await();
                } catch (InterruptedException ignored) {
                }
            }
            this.name = name + count;
            System.out.println(Thread.currentThread().getName() + "。。。生产者。。。" + this.name);
            ++count;
            flag = true;
            con_condition.signal();
        } finally {
            mylock.unlock();//释放锁
        }
    }

    void out() {
        mylock.lock();//获取锁
        try {
            while (!flag) {
                try {
                    con_condition.await();
                } catch (InterruptedException ignored) {
                }
            }
            System.out.println(Thread.currentThread().getName() + "........消费者。。。" + name);
            flag = false;
            pro_condition.signal();
        } finally {
            mylock.unlock();//释放锁

        }

    }


}

class Productor2 implements Runnable {
    private final Resourse1 r;

    Productor2(Resourse1 r) {
        this.r = r;
    }

    public void run() {//生成烤鸭
        while (true) {
            r.set("烤鸭");

        }
    }
}

class Consumer2 implements Runnable {
    private final Resourse1 r;

    Consumer2(Resourse1 r) {
        this.r = r;
    }

    public void run() {//无法声明抛出异常，因为这是复写的方法
        while (true) {
            r.out();

        }

    }

}

public class ProductorAndConsumer3 {
    public static void main(String[] args) {
        Resourse1 r = new Resourse1();
        Productor2 pro = new Productor2(r);
        Consumer2 con = new Consumer2(r);

        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(pro);
        Thread t3 = new Thread(con);
        Thread t4 = new Thread(con);
        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }
}
