package 面试题;

/**
 *  面试题1：
 *  class Test implements Runnable{
 *     public void run(Thread r){
 *
 *     }
 * }有错误吗？错在哪一行？
 * 第一行，因为Runnable含有抽象方法，Test没有覆盖，则需要声明为abstract类，才能拥有抽象方法

 /**
 *面试题2；
 */
public class Thread1Test {
    public static void main(String[]args){
        new Thread(//new Runnable() {
           // @Override
           // public void run() {
           //     System.out.println("Runnable子类的run方法");
           // }
        //}
        )
    {
           // public void run(){
           //     System.out.println("Thread子类的run方法");
           // }
        }.start();
        //第一种情况，因为是new Thread.start,所以子类调用start方法，就会执行run方法，那么子类里边如果有run，则执行run
        //体现多态
        //现在注释掉子类的run，则执行Ruannble的run方法，因为这个时候，这个run方法相当于复写了父类的run方法。

        //现在连Runnable的run方法也去掉，就会执行Thread本来封装的run方法，即——空
    }

}
