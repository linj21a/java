package Stream_IntOut;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * OutputStream是字节输出流
 * public abstract class OutputStream
 * extends Object
 * implements Closeable, Flushable此抽象类是表示输出字节流的所有类的超类。顶层父类
 *
 * 输出流接受输出字节并将它们发送到某个接收器。
 * 需要定义OutputStream的子类的应用程序必须始终至少提供一个写入一个输出字节的方法。
 *
 * 直接子类：
 * ByteArrayOutputStream ， FileOutputStream ， FilterOutputStream ， ObjectOutputStream ， PipedOutputStream
 *
 * 我们找到FileOutputStream子类来演示
 *
 * 该父类的方法：
 * void close() 关闭此输出流并释放与此流关联的所有系统资源。
 * void flush() 刷新此输出流并强制写出任何缓冲的输出字节。
 * static OutputStream nullOutputStream() 返回一个新的 OutputStream ，它丢弃所有字节。
 * void write​(byte[] b) 将 b.length字节从指定的字节数组写入此输出流。
 * void write​(byte[] b, int off, int len) 将从偏移量 off开始的指定字节数组中的 len字节写入此输出流。
 * abstract void write​(int b) 将指定的字节写入此输出流。
 */

public class Practice5_OutputStream {
    public static void main(String[]args) throws IOException {
        OutputStream outs = new FileOutputStream("E:\\OutStreamDemo.txt");

        outs.write("abcsefldj".getBytes());

        //不需要刷新流就已经写入了，与字符流的write不同。它不需要缓冲区解析。
        outs.flush();//实际上，FileOutputStream根本就没有实现flush。
        outs.close();//注意关闭资源，资源关闭一定要做的。

    }
}
