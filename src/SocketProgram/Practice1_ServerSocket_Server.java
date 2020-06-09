package SocketProgram;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP之服务器端
 * 使用ServerSocket类
 */

public class Practice1_ServerSocket_Server {
    private ServerSocket serverSocket;

    public Practice1_ServerSocket_Server(int port) throws IOException {
        System.out.println("服务器启动！");
        serverSocket = new ServerSocket(port);
    }
    public void receiveServer(){
        while (true) {//服务器一般是不断进行监听的，有客户请求，就做出响应。
            Socket socket;
            try{
                socket = serverSocket.accept();//等待客户端连接。一旦返回socket对象意味着与一个客户连接。
                System.out.println("New connection accepted" + socket.getInetAddress() +
                        ":" + socket.getPort());
                InputStream in = socket.getInputStream();
                byte[]bytes = new byte[1024];
                in.read(bytes);
                System.out.println(new String(bytes));

                //服务器做出应答：
                OutputStream out = socket.getOutputStream();
                out.write("收到".getBytes());


            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    /*private void sendMessage(StringBuilder message, PrintWriter pw) throws IOException {
        String mesg_read = message.toString();

        System.out.println(mesg_read);
        if(mesg_read.equals("bye")){
            pw.println("");
            return;
        }
        //否则本地录入的信息作为发送
        BufferedReader localreader = new BufferedReader(new InputStreamReader(System.in));
        String msg;
        StringBuilder re_msg = new StringBuilder();
        while((msg=localreader.readLine())!=null){
            if(msg.equals("over"))//本地输入以over结束。
                break;
            re_msg.append(msg);
        }
        //发送
        pw.println(re_msg.toString());
    }

    private void getMessage(BufferedReader br,StringBuilder message) throws IOException {
        message.delete(0,message.length());//每次读取都要清空message
        String msg;
        while((msg=br.readLine())!=null){
            message.append(msg);
        }
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream socketOut = socket.getOutputStream();//获取输出流对象，用于做出响应。
        return new PrintWriter(socketOut, true);//使用装饰类
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream socketIn = socket.getInputStream();//获取输入流对象，用于接受请求。
        return new BufferedReader(new InputStreamReader(socketIn));//使用转换流和装饰类
    }
*/

    public static void main(String[]args) throws IOException {
        Practice1_ServerSocket_Server server = new Practice1_ServerSocket_Server(9000);//必须服务器先启动。
        server.receiveServer();
    }
}
