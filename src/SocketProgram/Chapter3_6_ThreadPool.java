package SocketProgram;

import java.util.LinkedList;

/**
 * 为了解决每个客户都要分配一个线程来服务所带来的缺点，我们应该使用线程池对象。
 * public class ThreadGroup
 * extends Object
 * implements Thread.UncaughtExceptionHandler
 * 一个线程组表示一组线程。此外，一个线程组还可以包括其他线程组。线程组形成一个树，其中每一个线程组除了初始线程组有一个父。
 * 允许一个线程访问它自己的线程组的信息，但不允许访问它的线程组的父线程组或其他任何线程组的信息。
 *
 * 从以下版本开始：
 * JDK1.0
 * 下面使用自定义线程池类 ThreadPool
 */

public class Chapter3_6_ThreadPool extends ThreadGroup {
    private boolean isClosed = false;//判断线程池是否关闭
    private LinkedList<Runnable> workQueue;//表示工作队列
    private static int threadPoolID;//表示线程池ID
    private static int threadID;//工作线程的ID号

    /**
     *
     * @param poolSize 指定线程池中工作线程的数量
     */
    public Chapter3_6_ThreadPool(int poolSize) {
        super("ThreadPool-"+(threadPoolID++));
        setDaemon(true);//守护线程组，后台运行
        workQueue = new LinkedList<>();//创建工作队列
        for(int i=0;i<poolSize;i++){
            new WorkThread().start();//创建并启动工作线程，该WorkThread是一个内部类，线程子类
        }
    }

    /**
     * 向工作队列加入一个新任务，由工作线程去执行该任务。
     * @param task 线程任务，Runnable的子类对象
     */
    public synchronized void execute(Runnable task){
        if(isClosed){//如果线程池已经关闭，则抛出异常
            throw new IllegalStateException();
        }
        if(task!=null){
            workQueue.add(task);
            notify();//唤醒正在getTask()方法里边等到的工作线程
        }
    }

    /**
     * 从工作队列中取出一个任务，工作线程会调用该方法。
     * @return 返回执行的工作任务
     * @throws InterruptedException 中断异常
     */
    protected synchronized Runnable getTask()throws InterruptedException{
        while(workQueue.size()==0){
            if(isClosed)return null;
            wait();//如果线程队列没有任务则等待任务
        }
        return workQueue.removeFirst();//执行任务同时工作队列任务减一。
    }
    /**
     * 关闭线程池
     */
    public synchronized  void close(){
        if(!isClosed){
            isClosed = true;
            workQueue.clear();//清空工作队列
            interrupt();//线程池终止
        }
    }
    /**
     * 等到工作线程将所有的任务执行完毕
     */
    public void join(){
        synchronized (this){
            isClosed = true;
            notifyAll();//唤醒所有还在getTask方法中等待的工作线程
        }
        Thread[]threads = new Thread[activeCount()];
        //enumerate方法继承自ThreadGroup类，获取线程组中当前存活的所有工作线程
        int count = enumerate(threads);
        for(int i=0;i<count;i++){//等待所有的工作线程结束
            try{
                threads[i].join();//等到工作线程结束
            }catch (InterruptedException ignored){}
        }
    }
    /**
     * 内部类：工作线程类
     */
    private class WorkThread extends Thread{
        public WorkThread(){
            //加入到当前的ThreadPool线程组中
            super(Chapter3_6_ThreadPool.this,"WorkThread-"+(threadID++));
        }
        public void run(){
            while(!isInterrupted()){
                Runnable task = null;
                try{
                    task = getTask();
                } catch (InterruptedException ignored) {}

                //如果getTask返回null或者执行时方法被中断，则结束该线程
                if(task==null) return;
                try{
                    task.run();
                }catch (Throwable t){//Throwable是异常体系的顶层
                    t.printStackTrace();
                }
            }
        }

    }
}
