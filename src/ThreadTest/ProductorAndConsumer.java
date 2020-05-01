package ThreadTest;


/**
 * 演示等待唤醒机制最经典的例子；多生产者与多消费者
 * <p>
 * 使用到了notifyAll，与wait——涉及到了效率低下是问题——后来在java的1.5版本以后改进，封封装了锁对象为lock类。
 * 以及Condition——await（），asignal（），asignalAll（）
 */
//出现情况1，生成的烤鸭只有一个，却这么多消费者能吃到
    /*
    Thread-3........消费者。。。烤鸭111835
Thread-2........消费者。。。烤鸭111835
Thread-3........消费者。。。烤鸭111835
Thread-2........消费者。。。烤鸭111835
Thread-3........消费者。。。烤鸭111835
Thread-2........消费者。。。烤鸭111835
Thread-3........消费者。。。烤鸭111835
     */
class Resourse {
    String name = null;
    int count = 0;
    public boolean flag = false;
}

class Productor implements Runnable {
    private final Resourse r;

    Productor(Resourse r) {
        this.r = r;
    }

    public void run() {//生成烤鸭
        while (true) {
            synchronized (r) {
                if (r.flag) {
                    try {
                        r.wait();
                    } catch (InterruptedException ignored) {
                    }
                }
                r.name = "烤鸭" + r.count;
                System.out.println(Thread.currentThread().getName() + "。。。生产者。。。" + r.name);
                ++r.count;
                r.flag = true;
                r.notify();
            }
        }


    }

}

class Consumer implements Runnable {
    private final Resourse r;

    Consumer(Resourse r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            synchronized (r) {
                if (!r.flag) {
                    try {
                        r.wait();
                    } catch (InterruptedException ignored) {
                    }
                }
                System.out.println(Thread.currentThread().getName() + "........消费者。。。" + r.name);
                r.flag = false;
                r.notify();

            }
        }

    }

}

public class ProductorAndConsumer {
    public static void main(String[] args) {
        Resourse r = new Resourse();
        Productor pro = new Productor(r);
        Consumer con = new Consumer(r);

        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(pro);
        Thread t3 = new Thread(con);
        Thread t4 = new Thread(con);
        t1.start();
        t2.start();//当只有一个消费者与一个生产者的时候，我们发生程序 线程安全，同时实现生成一个消费一个。现在修改为多生产者多消费者
        t3.start();
        t4.start();


    }
}
