package Stream_IntOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * public abstract class InputStream
 * extends Object
 * implements Closeable此抽象类是表示输入字节流的所有类的超类。顶层类。
 * 需要定义子类InputStream应用程序必须始终提供返回输入的下一个字节的方法。
 *
 * 直接子类：AudioInputStream ， ByteArrayInputStream ， FileInputStream ，
 * FilterInputStream ， ObjectInputStream ， PipedInputStream ， SequenceInputStream ，
 * StringBufferInputStream
 *
 * 常用子类：FileInputStream
 *
 * 常用方法：
 * 1、int available() 返回估计的文件字节大小
 * 2、void close() 关闭此输入流并释放与该流关联的所有系统资源。  字节流不需要刷新，因为写的是字节，直接写入不需要缓冲。
 * 3、abstract int read() 从输入流中读取下一个数据字节。——子类必须覆写
 * 4、int read​(byte[] b) 从输入流中读取一些字节数并将它们存储到缓冲区数组 b 。
 * 5、int read​(byte[] b, int off, int len) 从输入流 len最多 len字节的数据读入一个字节数组。
 * 6、long skip​(long n) 跳过并丢弃此输入流中的 n字节数据。
 *
 * 基本操作与字符流类似。但是其不需要刷新流——flush，有一些子类需要有，而一些子类不需要。
 */

public class Practice5_InputStream {
    public static void main(String[]args) throws IOException {
        InputStream inputs = new FileInputStream("E:\\file.txt");

        //方式一读取，推荐使用方式一，安全。
        byte[]buff1 = new byte[1024];//申请1k大小的空间，当文件过大时也不会发生内存溢出
        int len =0;
        while ((len=inputs.read(buff1))!=-1){
            System.out.println(new String(buff1,0,len));
        }

       /* //方式二：
        byte []buff2 = new byte[inputs.available()];//直接申请文件大小的字节，容易发生内存溢出。比如我们内存只有3G，文件大小4G.
        //只需要读取一次。
        inputs.read(buff2);
        System.out.println(new String(buff2));

        */
        //记得关闭资源，避免造成灾难
        inputs.close();
    }
}
