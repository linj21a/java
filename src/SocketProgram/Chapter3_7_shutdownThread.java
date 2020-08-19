package SocketProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;


/**
 * 关闭服务器
 */

public class Chapter3_7_shutdownThread {
    private int port = 9000;//监听普通客户的端口
    private ServerSocket serverSocket;//服务器
    private ExecutorService executorService;//线程池
    private final int POOL_SIZE=4;//工作线程的数量

    private int portForShutdown = 9001;//用于监听服务器关闭命令，管理员的端口
    private ServerSocket serverSocketShutdown;//负责监听9001管理员的命令服务
    private boolean isShutdown = false;//服务器是否已经关闭
    /**
     * 负责监听关闭服务器命令的线程
     */
    private Thread shutDownThread = new Thread(){
        public void start(){
            this.setDaemon(true);//设置为守护线程
            super.start();
        }
        public void run(){
            while(!isShutdown){
                Socket socketForShutdown;
                try{
                    socketForShutdown = serverSocketShutdown.accept();//用于关闭线程池的服务器，专门监听管理员的命令
                    BufferedReader br = new BufferedReader(new InputStreamReader(socketForShutdown.getInputStream()));
                    String command = br.readLine();
                    if(command.equals("shutdown")){
                        long beginTime = System.currentTimeMillis();
                        socketForShutdown.getOutputStream().write("服务器正在关闭".getBytes());
                        isShutdown = true;
                        //请求关闭线程池,此时线程池不再接受新任务，只执行完现有任务
                        executorService.shutdown();

                        //等待关闭线程池，每次等待时间为30秒
                        while(!executorService.isTerminated())
                            executorService.awaitTermination(30, TimeUnit.SECONDS);

                        serverSocket.close();//服务器关闭
                        long endTime = System.currentTimeMillis();
                        socketForShutdown.getOutputStream().write(("服务器已经关闭"+"关闭服务器用时"+
                                (endTime-beginTime)+"ms\r\n").getBytes());
                        socketForShutdown.close();//同时不需要再监听管理员的命令，则关闭
                        serverSocketShutdown.close();
                    }else{//不是关闭命令则报错
                        socketForShutdown.getOutputStream().write("错误命令\r\n".getBytes());
                        socketForShutdown.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };

    /**
     * 服务器的构造器
     * @throws IOException
     */
    public Chapter3_7_shutdownThread() throws IOException {
        serverSocket = new ServerSocket(port);//服务器
        //设置等待客户链接的超时时间为60秒
        serverSocket.setSoTimeout(60000);
        serverSocketShutdown = new ServerSocket(portForShutdown);//监控关闭命令的服务器

        //创建线程池
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_SIZE);

        shutDownThread.start();//启动负责关闭服务器的线程
        System.out.println("服务器启动！");
    }

    /**
     * 普通客户的服务
     */
    public void service(){
        while(true){
            Socket socket = null;
            try{
                socket = serverSocket.accept();
                ///设置等待连接的超时时间
                socket.setSoTimeout(60000);
                executorService.execute(new Chapter3_5_Handler(socket));

            }catch(SocketTimeoutException e){
                //等待客户连接超时，不处理

            } catch (RejectedExecutionException e) {
                try{
                    if(socket!=null)socket.close();

            } catch (IOException ex) {
                    return;
                }
            } catch (SocketException e) {
                //如果是在执行accept方法时被shutdownThread线程关闭导致的就退出service方法
                if(e.getMessage().contains("socket closed"))
                    return;
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[]args) throws IOException {
        new Chapter3_7_shutdownThread().service();
    }
}
