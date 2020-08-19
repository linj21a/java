package SocketProgram;

/**
 * 测试自定义线程池类ThreadPool
 */
public class Chapter3_6_ThreadPoolTest {
    public static void main(String[] args) {
        /*if(args.length!=2){
            System.out.println("用法：java ThreadPoolTest numTasks poolSize"+
                    "\n numTask-integer:任务的数目"+
                    "\n numThreads-integer：线程池中线程数目");
            return;
        }*/
        int numTasks = 5;//Integer.parseInt(args[0]);
        int poolSize = 3;//Integer.parseInt(args[1]);
        Chapter3_6_ThreadPool threadPool = new Chapter3_6_ThreadPool(poolSize);//创线程池
        //运行任务
        for(int i=0;i<numTasks;i++){
            threadPool.execute(createTask(i));
        }
        threadPool.join();//必须等所有的线程都完成主线程才能退出。
        //threadPool.close();//关闭线程池

    }

    private static Runnable createTask(final int taskID) {
        return () -> {//lambda表达式
            System.out.println("Task"+taskID+": start!"+"线程"+Thread.currentThread().getName());
            try{
                Thread.sleep(500);//增加执行一个任务的时间

            } catch (InterruptedException ignored){}
            System.out.println("Task"+taskID+": end..."+"线程"+Thread.currentThread().getName());
        };
    }
}
