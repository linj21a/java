package SocketProgram;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Chapter3_1_Server {
    private  int port = 9090;
    private ServerSocket serverSocket;
    public Chapter3_1_Server()throws IOException{
        serverSocket = new ServerSocket(port,3);//指定请求连接队列长度
        System.out.println("服务器启动...完成!");
    }
    public void server(){
        while(true){
            Socket socket = null;
            try{
                socket = serverSocket.accept();
                System.out.println("new connection accepted"+socket.getInetAddress()+
                        ":"+socket.getPort());
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try{
                    if(socket!=null)
                        socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[]ars) throws InterruptedException, IOException {
        Chapter3_1_Server server = new Chapter3_1_Server();
       // Thread.sleep(600000);//睡眠60秒
        server.server();
    }
}
