package ThreadTest;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的学习。JDK1.5后JDK内部提供了线程池的实现和封装。
 * java.util.concurrent
 * Interface Executor
 * 子接口:
 * ExecutorService， ScheduledExecutorService
 * 所有已知实现类：
 * AbstractExecutorService， ForkJoinPool， ScheduledThreadPoolExecutor， ThreadPoolExecutor
 *
 * 里面只有一个抽象方法：
 * void execute​(Runnable command) 在将来的某个时间执行给定的命令。
 *
 * 学习子类：
 * public interface ExecutorService
 * extends Executor
 * Executor ，提供管理终止的方法和可生成Future以跟踪一个或多个异步任务进度的方法。
 * 可以关闭ExecutorService ，这将导致它拒绝新任务。 关闭ExecutorService提供了两种不同的方法。
 * shutdown()方法将允许先前提交的任务在终止之前执行，而shutdownNow()方法可防止等待任务启动并尝试停止当前正在执行的任务。
 * 终止时，执行程序没有正在执行的任务，没有等待执行的任务，也没有任何新任务可以提交。 应关闭未使用的ExecutorService以允许回收其资源。
 *
 * 方法submit延伸的基方法Executor.execute(Runnable)通过创建并返回一个Future ，可用于取消执行和/或等待完成。
 * 方法invokeAny和invokeAll执行最常用的批量执行形式，执行一组任务，然后等待至少一个或全部完成。 （ ExecutorCompletionService类可用于编写这些方法的自定义变体。）
 * boolean isTerminated() 如果关闭后所有任务都已完成，则返回 true 。
 * boolean isShutdown() 如果此执行程序已关闭，则返回 true 。
 *
 *public interface Future<V>
 *  Future表示异步计算的结果。 提供方法以检查计算是否完成，等待其完成，以及检索计算结果。
 * 只有在计算完成时才能使用方法get检索结果，必要时将其阻塞直到准备就绪。 取消由cancel方法执行。 提供了其他方法来确定任务是否正常完成或被取消。
 * 计算完成后，无法取消计算。 如果您希望使用Future以获取可取消性但未提供可用结果，则可以声明Future<?>表单的Future<?>并返回null作为基础任务的结果。
 *如判断任务是否被取消等。
 *
 * Executors类为此包中提供的执行程序服务提供工厂方法。
 * 工厂类：Executors
 * --------------------------------------------------------------------------------
 *
 * public class Executors
 * extends Object
 * 工厂和工具方法Executor ， ExecutorService ， ScheduledExecutorService ， ThreadFactory ，和Callable此包中定义的类。
 * 该类支持以下几种方法：
 * 使用常用配置设置创建和返回ExecutorService设置的方法。
 * 创建和返回ScheduledExecutorService设置的方法，使用常用的配置设置。
 * 创建并返回“包装”ExecutorService的方法，通过使特定于实现的方法不可访问来禁用重新配置。
 * 创建并返回将新创建的线程设置为已知状态的ThreadFactory的方法。
 * 创建并返回一个方法Callable出来的其他闭包形式，这样他们就可以在需要的执行方法使用Callable 。
 *
 * 里面有很多的方法：常用学习:
 *1、static Callable<Object> callable​(Runnable task)
 *  返回一个Callable对象，该对象在调用时运行给定任务并返回null 。
 * 2、static ExecutorService newFixedThreadPool​(int nThreads)
 * 创建一个线程池，该池重用在共享的无界队列中运行的固定数量的线程。
 * 3、static ExecutorService newFixedThreadPool​(int nThreads, ThreadFactory threadFactory)
 * 创建一个线程池，该线程池重用在共享的无界队列中运行的固定数量的线程，使用提供的ThreadFactory在需要时创建新线程。
 *
 * 4、static ScheduledExecutorService newScheduledThreadPool​(int corePoolSize)
 * 创建一个线程池，可以调度命令在给定的延迟后运行，或者定期执行。
 * 5、static ScheduledExecutorService newScheduledThreadPool​(int corePoolSize, ThreadFactory threadFactory)
 * 创建一个线程池，可以调度命令在给定的延迟后运行，或者定期执行。
 * ---------------------------------------------------
 */

public class ThreadPoolExecutor {
    public static void main(String[] args) {
        //1、创建一个线程池接口类
        ExecutorService service = Executors.newFixedThreadPool(4);//指定了线程池的个数
        //第二步，利用submit方法，将传入的线程任务执行。即创建Runnable类封装线程任务。
        for (int i = 0; i <5 ; i++) {//这里想要创建5个线程任务，但是只有4个线程则有一个线程重用。
            service.submit(new DisplayThreadName());
            /*
我叫：pool-1-thread-2 打印完成
我叫：pool-1-thread-3 打印完成
我叫：pool-1-thread-4 打印完成
我叫：pool-1-thread-1 打印完成
我叫：pool-1-thread-1 打印完成
             */
        }
     /*   service.submit(new DisplayThreadName());//我叫：pool-1-thread-3 打印完成
        //发现执行到了这里，程序没有停，因为线程池没有被关闭。我们还可以添加线程
        service.submit(new DisplayThreadName());//我叫：pool-1-thread-2 打印完成
        service.submit(new DisplayThreadName());//我叫：pool-1-thread-1 打印完成
        service.submit(new DisplayThreadName());
*/
     //调用shutDown关闭线程池，程序停止。
      /*  service.shutdown();
        System.out.println("args = " + service.isTerminated());//如果关闭后所有任务都已完成，则返回 true 。 因为main是一个线程，我们在这里无法得到true*/
        if(!service.isTerminated()){
            service.shutdown();
            System.out.println("args = " + service.isTerminated());//如果关闭后所有任务都已完成，则返回 true
            System.out.println("shutDown = "+service.isShutdown());
        }
    }
    static class DisplayThreadName implements Runnable{
        @Override
        public void run(){
            System.out.println("我叫："+Thread.currentThread().getName()+" 打印完成");
        }
    }
}
