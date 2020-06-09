package SocketProgram;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * 既然我们知道了浏览器是如何发送请求的，那我们可以模拟这个请求
 * 创建一个自己的浏览器。
 * 访问的网页是：
 *
 */
public class Practice4_MyBrowser_Client {
    public static void main(String[]args) throws IOException {
        Socket s = new Socket();
        SocketAddress address = new InetSocketAddress("www.icourse163.org",80);
        s.connect(address);
        //发送请求，按照http的格式
        PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
        pw.println("GET /channel/2001.htm HTTP/1.1");
        pw.println("Host: www.icourse163.org:80 ");
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


        //将接收到的数据打印出来。
        InputStream in = s.getInputStream();
        byte[]bytes = new byte[1024];
        int len;
        while((len=in.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        s.close();
    }

}
