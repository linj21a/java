package ThreadTest;

/**
 * 针对情况1，我们如何改进呢？
 * 首先我们明确原因；r.notify我们希望唤醒的是对方，假设唤醒了自己，然后cpu停止了当前线程，切换到了唤醒的这个线程
 * 这个时候不会再判断flag，就会继续生成烤鸭，使得上一个线程的生成烤鸭没被消费，同理假设是消费者的这样的过程，就会多次消费同一个烤鸭
 * 我们首先解决办法——while判断，这样当醒来的是本方，我们一样要判断有没有烤鸭（flag)
 * <p>
 * 假设我们还用notify，就会出现第二种情况——死锁，全部线程都睡过去了，没有人去争锁了。
 * <p>
 * <p>
 * 所以我们需要使用唤醒的方法使用notifyAll，为了确保能唤醒对方，即使本方也会醒，但是我们的while解决了这个问题
 * 但是也带来了问题：就是假设我们都唤醒，那么本方的flag本来就是true，只会再次睡过去。
 * 所以：降低了效率，但是jdk1.5又没有能唤醒指定线程的方法。
 */
class Productor1 implements Runnable {
    private final Resourse r;

    Productor1(Resourse r) {
        this.r = r;
    }

    public void run() {//生成烤鸭
        while (true) {
            synchronized (r) {
                while (r.flag) {
                    try {
                        r.wait();
                    } catch (InterruptedException e) {
                    }
                }
                r.name = "烤鸭" + r.count;
                System.out.println(Thread.currentThread().getName() + "。。。生产者。。。" + r.name);
                ++r.count;
                r.flag = true;
                // r.notify();,死锁
                r.notifyAll();
            }
        }


    }

}

class Consumer1 implements Runnable {
    private final Resourse r;

    Consumer1(Resourse r) {
        this.r = r;
    }

    public void run() {//无法声明抛出异常，因为这是复写的方法
        while (true) {
            synchronized (r) {
                while (!r.flag) {
                    try {
                        r.wait();
                    } catch (InterruptedException ignored) {
                    }
                }
                System.out.println(Thread.currentThread().getName() + "........消费者。。。" + r.name);
                r.flag = false;
                // r.notify();,死锁
                r.notifyAll();//解决问题~！

            }
        }

    }

}

public class ProductorAndConsumer2 {
    public static void main(String[] args) {
        Resourse r = new Resourse();
        Productor1 pro = new Productor1(r);
        Consumer1 con = new Consumer1(r);

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
