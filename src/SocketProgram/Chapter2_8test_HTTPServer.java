package SocketProgram;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * 创建一个简单的HTTP客户程序，它访问右命令行参数（args）指定的一个网页
 * （如：www.javathinker.org/index.jsp）
 * 并把得到的HTTP响应结果保存到本地系统的一个文件。
 *
 * HTTP一般端口是80；
 */

public class Chapter2_8test_HTTPServer {
    public static void main(String[]arg) throws IOException {
        String host = arg[0];
        Socket client = new Socket();
        SocketAddress address = new InetSocketAddress(host,80);
        client.connect(address);

        InputStream in = client.getInputStream();
        OutputStream localwriter = new FileOutputStream("E:\\http_server.html");
        OutputStream out = client.getOutputStream();
        PrintWriter pw = new PrintWriter(out,true);

        //发送请求：这里要符号HTTP协议的请求格式

        byte[]bytes = new byte[1024];
        int len;
        while((len=in.read(bytes))!=-1){
            localwriter.write(bytes,0,len);
        }

        System.out.println("accept successfully!");

        client.close();
        localwriter.close();

    }
}
