package SocketProgram;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class test {
    public static void main(String []args) throws IOException {
        Socket client = new Socket();//这里是创建一个客户，并没有申请连接。也不会分配端口
        SocketAddress address1 = new InetSocketAddress("localhost",9000);
        SocketAddress address2 = new InetSocketAddress("localhost",9001);

        client.connect(address1);//连接服务器1，连接上了，client会分配一个随机端口。如果
        client.connect(address2);//再连接服务器2，则服务器那边会报disconnect set
        //一个Socket只允许 建立一次连接
        /*
        Exception in thread "main" java.net.SocketException: already connected
	at java.base/java.net.Socket.connect(Socket.java:571)
	at java.base/java.net.Socket.connect(Socket.java:540)
	at SocketProgram.test.main(test.java:15)
         */

    }
}
