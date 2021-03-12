package SocketProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


/**
 * SMTP客户端程序发送邮件。
 * SMTP(Simple Mail Transfer Protocol)是一个应用层协议:
 * 建立在TCP/IP协议基础上，其规定了邮件从发送方到接收方的传输规则
 *
 * 客户端：负责发送邮件到服务器
 * SMTP服务器：负责将邮件传输到目的地
 * SMTP服务器默认监听端口：25
 * 服务器的主机地址：smtp.mydomain.com
 *
 *
 */

public class Chapter2_6_SMTPSender {
    //1、设置服务器的主机和其端口
    private final static  String smptServer = "smtp.mydomain.com";
    private final static int port = 80;

    /**
     * 发送一封邮件，使用SMTP协议，基于TCP/IP协议。注意发送者和接收者的地址。
     * @param args 命令行参数
     */
    public static void main(String[]args){
        Message msg = new Message("tom@abc.com",//发送者邮箱
                "6041@.com",//接收者邮箱
                "hello",//邮件标题
                "hi,I miss you very much!");
        new Chapter2_6_SMTPSender().sendMail(msg);

    }

    private void sendMail(Message msg) {
        Socket socket = null;
        try{
            socket = new Socket(smptServer,port);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            String localhost = InetAddress.getLocalHost().getHostName();//获取客户的主机名
/*//一般这里还要密码和用户名
            String username = "";
            String password = "";
            //编码*/
            sendAndReceive(null,br,pw);//接受服务器响应数据
            sendAndReceive("HELO"+localhost,br,pw);
            sendAndReceive("MAIL FROM:<"+msg.from+">",br,pw);
            sendAndReceive("RCPT TO:<"+msg.to+">",br,pw);
            sendAndReceive("DATA",br,pw);
            //开始发送
            pw.println(msg.data);//发送邮件内容
            System.out.println("Client>"+msg.data);
            sendAndReceive(".",br,pw);//邮件发送完毕
            sendAndReceive("QUIT",br,pw);


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if (socket != null)socket.close();
            }catch (IOException e){e.printStackTrace();}
        }
    }

    /**
     * 发送一行字符串并接受服务器的响应数据。
     * @param s 要接受的信息
     * @param br 接受器
     * @param pw 发送器
     */
    private void sendAndReceive(String s, BufferedReader br, PrintWriter pw) throws IOException {
        if (s != null) {
            System.out.println("Client>"+s);
            pw.println(s);//发送
        }
        String response;
        if((response=br.readLine())!=null){
            System.out.println("Server>"+response);
        }

    }

}
