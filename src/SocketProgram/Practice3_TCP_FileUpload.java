package SocketProgram;

import java.io.*;
import java.net.Socket;

/**
 * 客户端上传文件，然后服务器进行上传成功的响应！
 * 文件类型不限于文本、图片、音乐。
 *
 */

public class Practice3_TCP_FileUpload {
    public static void main(String[]args) throws IOException {
        System.out.println("客户端启动！");
        //1、创建客户端，要指定服务器的端口，主机地址
        Socket client = new Socket("localhost",10111);//主机为本机。端口10111

        //2、获取要上传的文件，开始上传
        OutputStream out = client.getOutputStream();

        //用于读取文件的流
        FileInputStream fileinput = new FileInputStream(new File("E:\\socket1.JPG"));

        //3、开始发送数据
        byte[]bytes = new byte[1024*1024];//分配1MB大小的内存
        int len;
        while((len=fileinput.read(bytes))!=-1){
            out.write(bytes,0,len);//使劲的发送到客户端。字节流不需要刷新？
        }

        //写完以后要告诉服务器
        client.shutdownOutput();//发送完毕，关闭客户端的发送。——做法还可以是传输时间戳。或者标识结束。如如果是over字段就结束，
        //字符流 就发送一个换行标识或者其他。
        //if(bytes...)怎么样就退出。
        //现在注释shutdownOutput，发现服务器和客户端都在等。此时得到的上传数据0kb，因为
        /*服务器的这段代码一直在阻塞，read一直在读，它不知道客户端已经发完数据了。
        while((len=in.read(bytes))!=-1){
            fileOut.write(bytes,0,len);//字节流不需要刷新
        }
         */

        InputStream in = client.getInputStream();
        //开始接受服务器的响应
        byte[]re_bytes = new byte[1024];
        while((len=in.read(re_bytes))!=-1){
            System.out.println(new String(re_bytes,0,len));
        }
        //4、注意本地的读取流需要关闭
        fileinput.close();
        //断开客户端和服务器的连接。
        client.close();


    }
}
