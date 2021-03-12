package SocketProgram;

import java.io.IOException;
import java.net.Socket;

/**
 * 练习使用服务器的连接请求队列长度backlog指定
 * 创建100次客户连接，而服务器之监听3个客户。
 */

public class Chapter3_1_Client {
    public static void main(String[] ars) throws IOException, InterruptedException {
        final int length = 100;
        String host = "localhost";
        int port = 9090;
        Socket[]sockets = new Socket[length];
        for(int i=0;i<length;i++){
            sockets[i] = new Socket(host,port);//创建100次连接
            System.out.println("第"+(i+1)+"次连接成功！");
        }
        Thread.sleep(3000);//延时3s
        for(int i=0;i<length;i++){
            sockets[i].close();//关闭客户端
        }
    }
}
