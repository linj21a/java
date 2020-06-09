package SocketProgram;

import java.io.IOException;
import java.net.SocketException;

/**
 * 实现多线程操作，同时
 * 体验以下将IP改为广播ip——最后一个整数是255
 * 此时一个ip发向服务器的信息，通前三位的ip都能收到。
 * 所有的人都能收到
 */

class EchoServer implements Runnable{
    private Practice2_DatagramSocket_UDPReceive UdpServer;

    public EchoServer(int port) throws SocketException {
        UdpServer = new Practice2_DatagramSocket_UDPReceive(port);
    }

    @Override
    public void run() {
        UdpServer.receiveData();
    }
}
class EchoClient implements Runnable{
    private Practice2_DatagramSocket_UDPSend UdpClient;
    private int port;

    public EchoClient(int port) throws IOException {
        UdpClient = new Practice2_DatagramSocket_UDPSend(port);
        this.port = port;
    }

    @Override
    public void run() {
        try {
            UdpClient.sendDate(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class Practice2_ThreadDemo  {
    public static void main(String[]args) throws IOException {
        int port = 11010;
        new Thread(new EchoClient(port)).start();
        new Thread(new EchoServer(port)).start();
    }

}
