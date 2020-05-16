package ThreadTest;

/**
 * 使用stop方法结束线程是过时的方法，stop是强制结束的
 * <p>
 * 有另外的方法：——run（)方法的结束
 * 我们使用控制flag进行控制线程的结束
 */
class Test1 implements Runnable {
    private boolean flag = true;

    public synchronized void run() {
        int i = 0;
        while (flag) {
            //现在加入wait方法，会出现问题，就是程序无法停下来！！！！，因为现在不会判断flag了，睡过去的flag
            try {
                wait();//必须在同步中才能使用，释放锁与释放cpu执行权。，
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "||||||||"+e);
                flag = false;//配合方法interrupt（）方法，强制唤醒wait了，所以会抛中断出异常

            }
            System.out.println(Thread.currentThread().getName() + "......" + i++);
            //notify();没有用，因为notify前都睡着了。。。
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}


public class StopThread1 {
    public static void main(String[] args) {
        Test1 r = new Test1();

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        int num = 0;
        for (; ; ) {
            if (++num == 90) {
                //r.setFlag(false);//，不用notify
                //现在使用新方法
                t1.interrupt();
                t2.interrupt();
                break;
            }
            System.out.println(Thread.currentThread().getName() + "------" + num);
        }
        System.out.println("over---------------------");
    }
}
