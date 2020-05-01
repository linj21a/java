package ThreadTest;

public class Practice2 implements Runnable {
    public void show() {
        for (int i = 0; i < 20; i++)
            System.out.println("大家好，我是show！" + i);
    }

    @Override
    public void run() {
        show();
    }

    public static void main(String[] args) {
        Practice2 test = new Practice2();
        Thread thread = new Thread(test);
        thread.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("现在是主线程执行" + i);//线程之间互相不影响，并且随机切换。
        }
        thread.stop();//进入线程的冻结时期，随机冻结
        for (int i = 0; i < 20; i++) {
            System.out.println("现在是主线程执行" + i);//线程之间互相不影响，并且随机切换。
        }


    }
}
