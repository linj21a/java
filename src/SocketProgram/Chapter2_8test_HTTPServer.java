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

        String //host = arg[0];
        host = "www.javathinker.org";
        Socket client = new Socket();
        SocketAddress address = new InetSocketAddress(host,80);
        client.connect(address);

        InputStream in = client.getInputStream();
        OutputStream localwriter = new FileOutputStream("E:\\http_server.html");
        OutputStream out = client.getOutputStream();

        //发送请求：这里要符号HTTP协议的请求格式
        PrintWriter pw = new PrintWriter(out,true);
        pw.println("GET /channel/2001.htm HTTP/1.1");
        pw.println("Host: "+host+":80 ");
        pw.println("Connection: keep-alive");
        pw.println("Upgrade-Insecure-Requests: 1");
        pw.println("User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36");
        pw.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9," +
                "image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        pw.println("Accept-Encoding: gzip, deflate, br");
        pw.println("Accept-Language: zh-CN,zh;q=0.9,en;q=0.8");

        //注意加一个空行
        pw.println();
        byte[]bytes = new byte[1024];
        int len;
        while((len=in.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
            localwriter.write(bytes,0,len);
            localwriter.flush();
        }

        System.out.println("accept successfully!");

        client.close();
        localwriter.close();

    }
}
