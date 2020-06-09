package Stream_IntOut;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道流
 * 1、PipedInputStream
 * public class PipedInputStream
 * extends InputStream
 * 管道输入流应连接到管道输出流;
 * 然后，管道输入流提供写入管道输出流的任何数据字节。
 * 通常，一个线程从PipedInputStream对象读取数据，并且某些其他线程将数据写入相应的PipedOutputStream 。
 *
 * !!建议不要尝试使用单个线程中的两个对象，因为它可能使线程死锁。
 * 管道输入流包含缓冲区，在一定限度内将读操作与写操作解耦。 如果为连接的管道输出流提供数据字节的线程不再存在， 则称管道为broken 。
 * 从以下版本开始：
 * 1.0
 * ####################################################################
 * 构造器：
 * PipedInputStream() 创建一个 PipedInputStream ，使它还不是 connected 。
 * PipedInputStream​(int pipeSize) 创建一个 PipedInputStream ，使其尚未 connected并使用指定的管道大小作为管道缓冲区。
 * PipedInputStream​(PipedOutputStream src) 创建 PipedInputStream ，使其连接到管道输出流 src 。
 * PipedInputStream​(PipedOutputStream src, int pipeSize) 创建一个 PipedInputStream ，
 * 使其连接到管道输出流 src并使用指定的管道大小作为管道缓冲区。
 *
 * 方法：
 * int available() 返回可以在不阻塞的情况下从此输入流中读取的字节数。
 * void close() 关闭此管道输入流并释放与该流关联的所有系统资源。
 * 连接管道源
 * void connect​(PipedOutputStream src) 使此管道输入流连接到管道输出流 src 。
 * 接受：读
 * int read() 从此管道输入流中读取下一个数据字节。
 * int read​(byte[] b, int off, int len) 从此管道输入流 len最多 len个字节的数据读入一个字节数组。
 * protected void receive​(int b) 接收一个字节的数据。
 *
 * #################################################################
 * 2、PipedOutputStream
 * public class PipedOutputStream
 * extends OutputStream
 * 管道输出流可以连接到管道输入流以创建通信管道。
 * 管道输出流是管道的发送端。 通常，数据由一个线程写入PipedOutputStream对象，并且由其他线程从连接的PipedInputStream读取数据。
 * 建议不要尝试使用单个线程中的两个对象，因为它可能使线程死锁。 如果从连接的管道输入流读取数据字节的线程不再存在， 则称该管道为broken 。
 * 从以下版本开始：
 * 1.0
 *################################################################
 * 构造器
 * PipedOutputStream() 创建尚未连接到管道输入流的管道输出流。
 * PipedOutputStream​(PipedInputStream snk) 创建连接到指定管道输入流的管道输出流。
 *
 * 方法：
 * void close() 关闭此管道输出流并释放与此流关联的所有系统资源。
 * void flush() 刷新此输出流并强制写出任何缓冲的输出字节。
 *写：发送方法：
 * void write​(byte[] b, int off, int len) 将从偏移 off开始的指定字节数组中的 len字节写入此管道输出流。
 * void write​(int b) 将指定的 byte写入管道输出流。
 * 连接两个管道：
 * void connect​(PipedInputStream snk) 将此管道输出流连接到接收器。
 *
 *
 * 注意：一定要多线程使用，单线程会发生死锁！（因为无法同时读和写。）
 */
class Input implements Runnable{//负责接受信息的管道线程
    private PipedInputStream input;
    public Input(PipedInputStream input){
        this.input = input;
    }
    @Override
    public void run(){
        try{
            //Thread.sleep(5000);//延时5秒
            byte[]buff = new byte[1024];
            while((input.read(buff))!=-1){
                System.out.println("我是接受管道的线程，我收到你发送的信息如下：");
                System.out.println(new String(buff));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(input!=null)
                try{
                    input.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
        }

    }
}
class Out implements Runnable{//负责发送数据的管道线程
    private PipedOutputStream output;
    public Out(PipedOutputStream output) {
        this.output = output;
    }
    @Override
    public void run(){
        try{
            Thread.sleep(5000);//延时5秒
            String message =  "扑街，我来了！";
            System.out.println("我是PipedOutputStream，负责发送信息的管道！发送信息如下：\n"+message);
            output.write(message.getBytes());
        }catch(IOException | InterruptedException e){
            e.printStackTrace();
        }finally {
            if(output!=null)
            try{
                output.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}

public class Practice13_PipeInput_OutputStream {
    public static void main(String[]args) throws IOException {
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream input = new PipedInputStream();

        //必须两个管道连接。方式1就是使用connect方法，方式二就是在构造器时传入。
        out.connect(input);
        new Thread(new Input(input)).start();
        new Thread(new Out(out)).start();
        //方式二
//        PipedOutputStream OUT = new PipedOutputStream(new PipedInputStream());

    }
}
