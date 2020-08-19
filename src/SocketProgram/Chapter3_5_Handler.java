package SocketProgram;

import java.io.*;
import java.net.Socket;

/**
 * 负责与单个客户的通信
 */

public class Chapter3_5_Handler implements Runnable {
    private Socket socket;
    public Chapter3_5_Handler(Socket socket){
        this.socket = socket;
    }
    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream out = socket.getOutputStream();
        return new PrintWriter(out,true);
    }
    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(in));
    }
    public String echo(String msg){
        return "echo"+msg;
    }
    @Override
    public void run(){
        try{
            System.out.println("new connection accepted"+socket.getInetAddress()+":"+socket.getPort());
            BufferedReader br = getReader(socket);
            PrintWriter pw = getWriter(socket);
            String msg;
            while((msg=br.readLine())!=null){
                System.out.println(msg);//接受请求并打印
                pw.println(echo(msg));//发送应答
                if(msg.equals("bye")){
                    break;
                }
            }
        }catch (IOException e){e.printStackTrace();}
        finally {
            try{
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
