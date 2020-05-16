package ThreadTest;

class Test2 implements Runnable {
    private boolean flag = true;
    int i = 0;

    public  void run() {
        while (flag) {
            synchronized (this){
                System.out.println(Thread.currentThread().getName() + ".|||||||||||....." + i);
                i++;
                //暂停线程的方法yield()
                Thread.yield();//没啥用
            }

        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

public class ThreadOtherMethors {
    public static void main(String[] args) throws InterruptedException {
        Test2 r = new Test2();

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        //使用守护线程方法——后台方法，所有的前台方法执行完，则该线程执行完，该方法必须使用在线程启动调用之前
        //t3.setDaemon(true);
        t3.start();
        t1.start();
        //t1.join();
        // try{t1.join();}catch (InterruptedException ignored){}//这个方法是指那个线程执行到该语句，就会将cpu执行权释放，至于其他线程就会争夺执行权，但是假设
        //是main执行到这里，main想要执行必须得等到t1执行完。

        t2.start();
       // t1.join();
        int num = 1;
        for (; num < 1000; num++) {
            if (num == 700) {
                r.setFlag(false);
                break;
            }

            // System.out.println(Thread.currentThread().getName() + "------" + num);
            //演示toString方法——打印线程名，线程优先级，以及线程组
            System.out.println(Thread.currentThread().toString() + "------" + num);

        }
        System.out.println("over---------------------");
    }
}
