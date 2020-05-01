package ThreadTest;

/*
目的：练习使用多线程类创建多线程
@Override
    public void run() {//Thread的run方法源码
        if (target != null) {
            target.run();
        }
    }
 */
class Animal extends Thread {
    private String name;

    public Animal(String name) {
        super(name);
        this.name = name;
    }

    public void run() {
        // System.out.println(4/0);,其他线程发生异常不影响主线程
        for (int i = 0; i < 10; i++)
            System.out.println("大家好，我叫" + name + "...线程名" + Thread.currentThread().getName());
        //show();
    }

    void show() {
        for (int i = -9999; i < 9999; i++) {
        }
        System.out.print("大家好，我叫" + name + "..." + Thread.currentThread().getName());
    }

}

public class Practice1 {
    public static void main(String[] args) {

        Animal test2 = new Animal("旺财");//创建对象时就已经安排好线程名字了
        Animal test1 = new Animal("小强");
        //开启线程！

        test1.start();//线程1
        test2.start();//线程2
        //System.out.println(3/0);//主线程发生异常不影响其他线程，其他线程发送异常也不影响主线程
        for (int i = 0; i < 10; i++)
            System.out.println("haha" + i + "...线程名+" + Thread.currentThread().getName());//主线程，如果去掉循环，其实也是随机的
        //三个线程随机运行，抢夺资源！


    }
}
