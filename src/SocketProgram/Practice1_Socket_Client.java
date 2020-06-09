package SocketProgram;

import java.io.*;
import java.net.Socket;

/**
 * Socket(套接字)
 * 其为网络服务提供了一种机制。
 * 无论是C++还是java等，因为网络传输的两端都需要端点（Socket）
 * 进而网络编程实际上可以说是Socket编程。
 * <p>
 * 基于传输协议，对Socket进行划分。
 * TCP传输协议：Socket、ServerSocket——建立连接通道，三次握手
 * UDP传输协议：DatagramSocket——将数据封装为DatagramPacket（数据包）
 * <p>
 * 模式：java网络通信都是基于客户/服务器通信模式。
 * <p>
 * Socket类：
 * TCP协议，Socket只能用来发送请求——客户端套接字
 * SocketServer用来响应请求。——服务器套接字
 * 它们通过三次握手，建立通道来连接。
 * 通道：网络IO流（Socket流）如，使用getInputStream、getOutputStream获取对应的输入输出流
 * <p>
 * 先请求连接，连接不成功继续请求，得到了同意就建立了通信通道。（三次握手！）
 * <p>
 * public class Socket
 * extends Object
 * implements Closeable
 * 这个类实现了客户端套接字（也被称为“套接字”）。套接字是两台机器之间的通信的一个端点。
 * 套接字的实际工作是由该类的一个实例进行SocketImpl。一个应用程序，通过改变创建套接字实现的套接字工厂，可以配置自己创建适合本地防火墙的套接字。
 * <p>
 * 1、构造器：
 * 1.1、Socket(String host, int port)
 * 创建一个流套接字，并将其与指定的主机上的指定端口号连接起来。
 * 1.2、Socket()
 * 创建一个连接的套接字，与socketimpl系统默认的类型。
 * 1.3、 Socket(InetAddress address, int port)
 * 创建一个流套接字，并将其与指定的IP地址中的指定端口号连接起来。
 * <p>
 * <p>
 * Socket(Proxy proxy)
 * 创建一个连接的套接字类型，指定代理，如果有，应该使用无论任何其他设置。
 * protected  Socket(SocketImpl impl)
 * 创建一个用户指定的socketimpl连接插座。
 * Socket(String host, int port, InetAddress localAddr, int localPort)
 * 创建一个套接字，并将其连接到指定的远程端口上的指定的远程主机上。
 * <p>
 * 2、常用方法
 * 2.1、获取本地IP、远程IP、本地输入流、输出流、关闭Socket流
 * InetAddress getInetAddress()
 * 返回套接字连接的地址。
 * InetAddress getLocalAddress()
 * 获取绑定的套接字的本地地址。
 * InputStream getInputStream()
 * 返回此套接字的输入流。
 * OutputStream getOutputStream()
 * 返回此套接字的输出流。
 * void close()
 * 关闭这个套接字。
 * <p>
 * 2.2、获取本地端口、连接的远程端口
 * int getPort()
 * 返回此套接字连接的远程端口号。
 * int getLocalPort()
 * 返回此套接字绑定的本地端口号。
 * <p>
 * 2.3、void connect(SocketAddress endpoint)
 * 将此套接字连接到服务器。
 * void connect(SocketAddress endpoint, int timeout)
 * 将此套接字与指定的超时值连接到服务器。
 * <p>
 * 2.4、
 * void bind(SocketAddress bindpoint)
 * 将套接字绑定到本地地址。
 */
public class Practice1_Socket_Client {
    private Socket client;

    /**
     * 1、Socket(String host, int port)
     * 创建一个流套接字，并将其与指定的主机上的指定端口号连接起来。
     * 输入bye退出连接，输入send发送请求。
     *
     * @param port 传入的端口号——服务器端口
     * @param host 指定主机——服务器主机
     */
    public Practice1_Socket_Client(String host, int port) throws IOException {
        System.out.println("客户端启动...");
        client = new Socket(host, port);
    }

    public void talk() throws IOException {//向服务端发送请求。得到的响应封装为流返回。
        OutputStream out = client.getOutputStream();
        BufferedWriter bufr = new BufferedWriter(new OutputStreamWriter(out));
        String mess = "我来了";
        //out.write(mess.getBytes());//非阻塞方法，因为直接写字节。如改为BufferedWriter,不加刷新发送不出去。
        bufr.write(mess);
        //################
        // 不加刷新，这个方法只是把mess写到了out里边，没有发送出去。进而阻塞了服务器那边的读取，
        //服务器一直在读 in.read(bytes);这个方法会阻塞。
        bufr.flush();

        //接受服务器的应答，实现客户和服务器的交互

        InputStream in = client.getInputStream();

        byte[]bytes = new byte[1024];
        int len = in.read(bytes);//同理，如果服务器没有发送数据，这个方法也会阻塞。
        System.out.println(new String(bytes,0,len));

        client.close();

    }

    public static void main(String[] args) throws IOException {
        Practice1_Socket_Client client = new Practice1_Socket_Client("localhost", 9000);
        client.talk();
    }
}
