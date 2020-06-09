package SocketProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 第一章1.1 进程之间的通信演示。
 * @author  Mr Lin time 2020-6-4
 * @version 1.0
 */

public class Chapter1_1_EchoPlayer {
    public String echo(String msg){
        return "echo"+msg;
    }
    public void talk()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//转换流
        String msg;
        while((msg=br.readLine())!=null){
            System.out.println(echo(msg));
            if("bye".equals(msg))
                break;
        }
    }
    public static void main(String[]args) throws IOException {
        new Chapter1_1_EchoPlayer().talk();
    }
}
