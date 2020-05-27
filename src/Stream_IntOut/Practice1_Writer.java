package Stream_IntOut;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * IO流分字符流和字节流（包括输入流和输出流）
 * 只涉及两个动作——读、写。
 * 读：将外设上的数据读取到内存中，即输入。
 * 写：将内存里边的数据写入外设，就是输出。
 *
 * 字符流的由来：
 *      字节流读文字的字节数据，并不直接操作数据，而是根据指定的编码表获取对应的文字信息。再对这个文字进行操作。
 *      简单点说就是——字节流+编码类。
 * IO流体系
 * 字节流最顶层：InputStream（输入流）
 *              OutputStream（输出流）
 * 字符流最顶层：Reader(读，输入流)
 *              Writer(写、输出流)
 *
 * 现在先学习Writer
 * public abstract class Writer
 * extends Object
 * implements Appendable, Closeable, Flushable
 * 抽象字符流顶层父类，用于写入字符流的抽象类。 子
 * 类必须实现的唯一方法是write（char []，int，int），flush（）和close（）。
 * 但是，大多数子类将覆盖此处定义的一些方法，以提供更高的效率，附加功能或两者兼而有之。
 *
 * 子类：BufferedWriter ，
 * CharArrayWriter ， FilterWriter ， OutputStreamWriter ， PipedWriter ， PrintWriter ， StringWriter
 *
 * 既然是抽象类我们就需要找一个子类来玩一下：FileWriter
 *
 * 需求：需要将用户的数据写入到硬盘里边。
 *
 */

public class Practice1_Writer {
    public static void main(String[]args)throws IOException {
        Writer fw =  new FileWriter("E:file.txt");//打开一个Writer流——字符输出流

        fw.write("file先存到缓冲区里边。");//这样写，是不会立即输出的。而是将字符串先暂存到字符缓冲区。

        //执行写入的方法只有刷新缓冲区。
//        fw.flush();//会立即将缓冲区的内容输出到目标地址（文件所在地），然后刷新缓冲区。
        //中文3个字节，英文1个字节所以输出的文件大小为31字节。

        fw.close();//方法二：使用close关闭输出流，关闭前会调用flush刷新一次缓冲区。此后该流无法被使用

//        fw.write("slj");//会报错Exception in thread "main" java.io.IOException: Stream closed，流已经关闭。


    }
}
