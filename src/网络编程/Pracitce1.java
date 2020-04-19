package 网络编程;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Pracitce1 {
    public static void main(String[]args){
        try{
            InetAddress ad1 = InetAddress.getByName("www.qq.com");
            System.out.println(ad1.getHostAddress());
            System.out.println(ad1.getHostName());

            InetAddress ad2 = InetAddress.getByName("61.135.169.105");
            System.out.println(ad2.getHostAddress());
            System.out.println(ad2.getHostName());

            InetAddress ia3=InetAddress.getLocalHost();
            System.out.println("主机名："+ia3.getHostName());
            System.out.println("本地ip地址："+ia3.getHostAddress());



        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
