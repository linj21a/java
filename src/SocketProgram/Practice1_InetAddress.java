package SocketProgram;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP地址被封装为对象，相应的类为：InetAddress——直接子类Inet4Address（ipv4），Inet6Address（ipv6）
 * <p>
 * 继承体系：
 * public class InetAddress
 * extends Object
 * implements Serializable
 * 这个类代表一个互联网协议（IP）地址。
 * IP地址是一个32位或128位无符号数使用的IP，一个低层协议赖以建立的协议如UDP和TCP。IP地址的结构是由RFC 790: Assigned Numbers，
 * RFC 1918: Address Allocation for Private Internets，RFC 2365: Administratively Scoped IP Multicast定义，
 * 并RFC 2373: IP Version 6 Addressing Architecture。
 * 一个InetAddress实例由一个IP地址和可能的对应的主机名构成（取决于它是否是一个主机名或是否已经做了反向主机名解析构造）。
 * <p>
 * 它没有构造器，而是使用静态工厂来返回实例；
 * 1、常用静态工厂方法
 * 1.1、static InetAddress getByName(String host) //如 String host="www.baidu.com",或者host="192.168.1.1"
 * 确定主机的IP地址，给定主机名。
 * <p>
 * 1.2、static InetAddress[] getAllByName(String host) //如新浪的是集群的 ,“www.sina.com"或者"111.111.111.1"什么的
 * 给定一个主机的名称，返回其IP地址的数组，基于系统上的配置的名称服务。有一些主机集群了，使得其ip有很多。
 * <p>其中的addr为一个字节数组 ，参数按网络字节顺序：地址的高位字节位于 getAddress()[0] 中，IPv4 地址 byte 数组的长度必须为 4 个字节，IPv6 byte 数组的长度必须为 16 个字节。
 * static InetAddress getByAddress(String host, byte[] addr)
 * 它创造了一个基于所提供的主机名和IP地址。
 * static InetAddress getByAddress(byte[] addr)
 * 返回给定的原始IP地址 InetAddress对象。
 * static InetAddress getLocalHost()
 * 返回本地主机的地址。  是IP地址对象
 * <p>
 * 2、常用的获取方法：
 * 2.1、String getHostAddress()
 * 返回文本表示中的IP地址字符串。 主机IP地址的字符串形式
 * 2.2、String getHostName()
 * 获取此IP地址的主机名。  主机名字符串
 * public String getCanonicalHostName()
 * 获取此IP地址的完全限定的域名。最好的工作方法，这意味着我们可能无法返回FQDN取决于底层的系统配置。
 * boolean isReachable(int timeout) 方法，测试是否可以达到该地址
 * toString() 方法，将此 IP 地址转换为 String
 */

public class Practice1_InetAddress {
    public static void main(String[] args) throws IOException {
        getInstance1(getInstance3());
        getInstance2();


    }

    /**
     * 使用静态工厂方法1构造一个IP对象，
     * static InetAddress getByName(String host)
     * @return byte[] 返回ip地址的byte数组。
     */
    private static byte[] getInstance3() throws IOException {
        System.out.println("getInstance1_getByName");
        InetAddress ip = InetAddress.getByName("www.qq.com");//可以是域名形式www.qq.com 主机IP地址:112.53.27.11

        //注意，这里使用的什么形式构造ip对象，则getHostName就返回什么。

        //获取其IP地址和对应的主机名
        String str_ip = ip.getHostAddress();//对应Ip网址的主机IP地址,主机IP地址:112.53.27.11
        String str_host = ip.getHostName();//对应的主机名www.qq.com
        System.out.println("主机名:" + str_host + " 主机IP地址:" + str_ip);
        System.out.println(ip.getCanonicalHostName());//获取此 IP地址的完全限定域名 112.53.27.11


        boolean reachable=ip.isReachable(2000);//获取布尔类型，看是否能到达此IP地址
        System.out.println("是否能达到该IP地址："+reachable);
        byte[] b;
        b = ip.getAddress();
        for(byte f:b){
            System.out.print(f+" ");//[B@735b478 [B@735b478 [B@735b478 [B@735b478
        }
        System.out.println();
        return b;

    }

    /**
     * 演示静态方法static InetAddress getLocalHost()
     * 返回本地主机的地址。  是IP地址对象
     */
    private static void getInstance2() throws UnknownHostException {
        System.out.println("getInstance2_getLocalHost");
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        String name = host.getHostName();
        System.out.println("name:"+name+" ip:"+ip);//name:滚被单fhg ip:192.158.13.1
    }

    /**
     * 演示静态工厂方法static InetAddress getByAddress(byte[] addr)
     *返回给定的原始IP地址 InetAddress对象。
     * @param bytes 传入的IP地址的byte数组。
     * @throws IOException 可能抛出的异常
     */
    private static void getInstance1(byte[]bytes) throws IOException {
        System.out.println("getInstance3_getByAddress");
        InetAddress ip = InetAddress.getByAddress(bytes);
        //注意，这里使用的什么形式构造ip对象，则getHostName就返回什么。

        //获取其IP地址和对应的主机名
        String str_ip = ip.getHostAddress();//对应Ip网址的主机IP地址,主机IP地址:112.53.27.11
        String str_host = ip.getHostName();//对应的主机名www.qq.com
        System.out.println("主机名:" + str_host + " 主机IP地址:" + str_ip);
        System.out.println(ip.getCanonicalHostName());//获取此 IP地址的完全限定域名 112.53.27.11


        boolean reachable=ip.isReachable(2000);//获取布尔类型，看是否能到达此IP地址
        System.out.println("是否能达到该IP地址："+reachable);

    }
}
