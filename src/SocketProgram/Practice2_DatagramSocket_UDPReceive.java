package SocketProgram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


/**
 * 接收端，接受UDP发送过过来的信息，并打印出来
 *
 */

public class Practice2_DatagramSocket_UDPReceive {
    private DatagramSocket UdpServer;
    Practice2_DatagramSocket_UDPReceive(int port) throws SocketException {
        System.out.println("接收端启动！接收端的端口号为:"+port);
        UdpServer = new DatagramSocket(port);

        //receiveData();

    }

    public void receiveData() {
        while(true){
            try{
                DatagramPacket data;
                byte[]bytes = new byte[1024];
                if(UdpServer!=null){
                    data = new DatagramPacket(bytes,bytes.length);
                    UdpServer.receive(data);//这个是阻塞式方法，与read()类似。
                    int port = data.getPort();
                    String hostName = data.getAddress().getHostName();//获取发送端的主机名
                    System.out.println("收到发送端信息！");

                    System.out.println("端口"+port+" 主机名:"+hostName+"\n消息为："
                            + new String(data.getData(),0,data.getLength()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[]args) throws IOException {
        new Practice2_DatagramSocket_UDPReceive(11010).receiveData();//10010被占用则报错！

    }
}
