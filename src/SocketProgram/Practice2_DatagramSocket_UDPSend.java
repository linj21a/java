package SocketProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 使用UDP进行通信，这里是发送端
 * public class DatagramSocket
 * extends Object
 * implements Closeable
 * 这类代表一个发送和接收数据包的插座。
 * 数据报套接字发送或者接收点的分组传送服务。每个发送的数据包或数据报套接字上接收单独寻址和路由。
 * 就是因为每个数据包的单独寻址，导致不可靠性，接受的数据顺序可能不一致，不重排序。
 *
 * 传输协议：UDP协议
 * 1、构造器；
 * DatagramSocket() ——常用，注意这个端口是由本地主机随机分配的。
 * 构建一个数据报套接字绑定到本地主机的任何可用的端口。
 *
 * DatagramSocket(int port) ——常用，指定端口，一般1024到65535
 * 构建一个数据报套接字绑定到本地主机的指定端口。
 *
 * DatagramSocket(int port, InetAddress laddr) ——指定端口和IP地址。
 * 创建一个数据报套接字，绑定到指定的本地地址。
 *
 * protected  DatagramSocket(DatagramSocketImpl impl)
 * 创建一个绑定的数据报套接字与指定的datagramsocketimpl。
 *   DatagramSocket(SocketAddress bindaddr)
 * 创建一个数据报套接字，绑定到指定的本地套接字地址。
 *
 * 常用方法
 * 判断：
 * boolean isBound()
 * 返回套接字的绑定状态。
 * boolean isClosed()
 * 返回套接字是否关闭或不关闭的。
 * boolean isConnected()
 * 返回套接字的连接状态。
 *
 * 发送接受：
 * void receive(DatagramPacket p)
 * 接收数据报包从这个插座。
 * void send(DatagramPacket p)
 * 从这个套接字发送数据报包。
 *
 * 获取端口和IP地址：
 * InetAddress getInetAddress()
 * 返回此套接字连接的地址。
 * InetAddress getLocalAddress()
 * 获取绑定的套接字的本地地址。
 * int getLocalPort()
 * 返回此套接字绑定的本地主机上的端口号。
 * int getPort()
 *  返回此套接字连接的端口号。
 *
 * SocketAddress getLocalSocketAddress()
 * 返回此套接字绑定到的端点的地址。
 *
 * 连接和关闭：
 * void close()
 * 关闭该数据报套接字。
 * void connect(InetAddress address, int port)
 * 将套接字连接到这个套接字的远程地址。
 * void connect(SocketAddress addr)
 * 将此套接字连接到远程套接字地址（IP地址+端口号）。
 * void disconnect()
 * 断开插座。
 *
 * #########################################
 * public final class DatagramPacket
 * extends Object
 * 这类表示一个数据报包。
 * 数据包是用来实现一个无连接的分组传送服务。每个消息都是从一台机器路由到另一个完全基于包含在该数据包内的信息。
 * 从一台机器发送到另一台机器的多个数据包可能会被不同的路由，并可能以任何顺序到达。包交付没有保证。
 * 构造器
 * 先只用一个：
 * DatagramPacket(byte[] buf, int length)
 * 接收数据包长度 length DatagramPacket构建。
 *
 */

public class Practice2_DatagramSocket_UDPSend {
    private DatagramSocket UdpClient;//服务端套接字

    /**
     * 有参构造器，UDP发送端初始化
     * @param port 发送端绑定的本地端口
     */
    public Practice2_DatagramSocket_UDPSend(int port) throws IOException {
        System.out.println("UDP发送端初始化，端口为"+port);
        this.UdpClient = new DatagramSocket();//发送端不用指定端口
        System.out.println("端口绑定完毕！发送端启动....");
        System.out.println("请输入你要发送的信息：");
        //sendDate(port);
    }
    public void sendDate(int port) throws IOException {
        //读取键盘录入信息，发送到接收端
        //1.需要键盘录入信息并存储到一个缓冲区
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;//=null
        //2.将信息封装为数据包——DatagramPacket
        //发送数据封装为数据包
        DatagramPacket dataPacket;//=null;
        while((line=reader.readLine())!=null){
            byte[]bytes = line.getBytes();
            dataPacket = new DatagramPacket(bytes,bytes.length,
                    InetAddress.getByName("192.168.137.1"),port);//从主机的port端口发送数据包
            //x.x.x.255是广播ip，此时x.x.x.2发信息到广播IP，则x.x.x.0~x.x.x.255的IP都能收到，这就是广播。
            //3.发送数据包
            UdpClient.send(dataPacket);
            System.out.println("send successfully:"+line);
            if(line.equals("bye")){
                break;
            }
        }
        //5.关闭DatagramSocket流
        UdpClient.close();
        System.out.println("发送端退出！");
    }
    public static void main(String[]args) throws IOException {
        int port = 11010;
        new Practice2_DatagramSocket_UDPSend(port).sendDate(port);
    }

}
