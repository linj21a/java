package SocketProgram;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 上传文件到服务器，服务器告知客户上传成功！
 *
 */
public class Practice3_TCP_FileServer {
    public static void main(String[]args) throws IOException {
        System.out.println("服务器启动！");
        //1、服务器必须明确自己是哪一个端口。
        ServerSocket server = new ServerSocket(9001);

        //2、判断是否有客户连接
        Socket client = server.accept();//成功返回socket对象说明有客户连接。
        System.out.println(client.getInetAddress()+"客户连接。");
        //3、获取socket流，进行接受数据并给予反馈
        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();

        //本地写入流
        FileOutputStream fileOut = new FileOutputStream(new File("E:\\socket_upload.JPG"));

        //4、接受数据、使劲往里边写
        byte[]bytes = new byte[1024*1024];//1M大小的内存
        int len;
        while((len=in.read(bytes))!=-1){
            fileOut.write(bytes,0,len);//字节流不需要刷新，如果是其他，一定要注意刷新否则会发生阻塞！！！！！
        }

        //5、接受完毕需要给客户端发送上传完毕的反馈。
        out.write("UpLoad successfully！".getBytes());

        fileOut.close();//本地流关
        client.close();//客户端关
        //服务器一般不关
    }
}
