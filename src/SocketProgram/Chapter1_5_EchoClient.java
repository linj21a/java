package SocketProgram;

import java.io.*;
import java.net.Socket;

public class Chapter1_5_EchoClient {
    private String host = "localhost";//主机地址为本机。
    private Socket socket;

    public Chapter1_5_EchoClient(int port) throws IOException {
        System.out.println("客户端启动！");
        socket = new Socket(host,port);
    }
    public static void main(String[]args) throws IOException {
        new Chapter1_5_EchoClient(9001).talk();
    }

    private void talk() {
        try{
            BufferedReader br = getReader(socket);
            PrintWriter pw = getWriter(socket);
            BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
            String msg;
            while((msg=localReader.readLine())!=null){
                pw.println(msg);//发送信息,println改为print,此时服务器的readline（）方法始终认为没有读取完一行，进而阻塞了。
                //假设现在输入bye，因为有socket.close,则进行关闭时会默认给readline()方法加上结束标记。进而实现关闭该客户端和服务端的连接。
                //但是此时的bye是没有发出去的。因为readline方法认为它没有读完数据。
                if(msg.equals("bye")){
                    break;//假设我们没有进行socket.close,println改为print,此时服务器的readline（）方法始终认为没有读取完一行，进而阻塞了。
                }//((msg = br.readLine()) != null) {//接受请求信息
                System.out.println(br.readLine());//接受服务器的响应。

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try{
                socket.close();
            }catch (IOException e){e.printStackTrace();}
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
}
