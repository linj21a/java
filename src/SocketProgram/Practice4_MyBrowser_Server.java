package SocketProgram;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟创建自己的http服务器
 */

public class Practice4_MyBrowser_Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动！");
        ServerSocket ss = new ServerSocket(9090);//服务器端口
        Socket s = ss.accept();
        System.out.println(s.getInetAddress()+"..连接！");
        InputStream in = s.getInputStream();
        byte []bytes = new byte[1024];
        int len = in.read(bytes);
        System.out.println(new String(bytes,0,len));

        PrintWriter pw = new PrintWriter( s.getOutputStream(), true);
        //给客户端反馈信息
        pw.println("<html>" +
                "<font color='red' size='7'>这是简单模拟的服务器程序，作者LH</font>" +
                "</html>");
        s.close();
        ss.close();


    }
}
