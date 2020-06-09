package SocketProgram;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Chapter1_5_EchoServer {
    private ServerSocket serverSocket;//创建监听端口的对象

    public Chapter1_5_EchoServer(int port) throws IOException {
        //端口
        serverSocket = new ServerSocket(port);
        System.out.println("EchoServer start!");
    }

    public String echo(String msg) {
        return "echo:" + msg;
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream socketOut = socket.getOutputStream();//获取输出流对象，用于做出响应。
        return new PrintWriter(socketOut, true);//使用装饰类
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream socketIn = socket.getInputStream();//获取输入流对象，用于接受请求。
        return new BufferedReader(new InputStreamReader(socketIn));//使用转换流和装饰类
    }

    public void service() {
        while (true) {//不断监控端口
            Socket socket = null;
            try {
                socket = serverSocket.accept();//等待客户端连接。一旦返回socket对象意味着与一个客户连接。
                System.out.println("New connection accepted" + socket.getInetAddress() +
                        ":" + socket.getPort());
                BufferedReader br = getReader(socket);//Input
                PrintWriter pw = getWriter(socket);//Output

                String msg;
                while ((msg = br.readLine()) != null) {//接受请求信息
                    System.out.println(msg);//打印
                    pw.println(echo(msg));//做出响应
                    if (msg.equals("bye")) {
                        break;//发来bye中止while，退出连接
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (socket != null)
                        socket.close();//断开连接
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[]args) throws IOException {
        new Chapter1_5_EchoServer(9000).service();
    }


}
