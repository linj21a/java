package SocketProgram;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 将服务器的服务用线程池处理
 */

public class Chapter3_6_EchoServer_ThreadPool {
    private int port = 9000;
    private ServerSocket serverSocket;
    private Chapter3_6_ThreadPool threadPool;
    private final int POOL_SIZE = 4;//单CPU时线程池中工作线程的数目

    public Chapter3_6_EchoServer_ThreadPool()throws IOException{
        serverSocket = new ServerSocket(port);
        //创建线程池
        threadPool = new Chapter3_6_ThreadPool(Runtime.getRuntime().availableProcessors()*POOL_SIZE);
        //Runtime.getRuntime().availableProcesses返回当前系统的CPU数目，我们根据该数目创建工作线程数目
        System.out.println("服务器启动！");
    }
    public void service(){
        while(true){
            Socket socket = null;
            try{
                socket = serverSocket.accept();
                //每来一个线程就执行一次execute方法判断从而添加线程任务到工作队列。
                threadPool.execute(new Chapter3_5_Handler(socket));//Handler是将服务器的任务处理封装为了对象
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[]args) throws IOException {
        new Chapter3_6_EchoServer_ThreadPool().service();
    }
}
