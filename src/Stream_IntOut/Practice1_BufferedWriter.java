package Stream_IntOut;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * BufferWriter是将缓冲区buff数组封装为了对象，避免了直接从硬盘中读取字节再转化为字符的可能低效率
 * 继承关系；
 * java.lang.Object
 * java.io.Writer
 * java.io.BufferedWriter
 * <p>
 * 将文本写入字符输出流，缓冲字符，以便有效地写入单个字符，数组和字符串。
 * 可以指定缓冲区大小，或者可以接受默认大小。 对于大多数用途，默认值足够大。
 * <p>
 * 提供了一个newLine（）方法，它使用平台自己的行分隔符概念，由系统属性line.separator定义。
 * 并非所有平台都使用换行符（'\ n'）来终止行。 因此，调用此方法终止每个输出行比直接编写换行符更为可取。
 * <p>
 * 构造器：
 * BufferedWriter​(Writer out) 创建使用默认大小的输出缓冲区的缓冲字符输出流。 默认大小一般足够大了。
 * BufferedWriter​(Writer out, int sz) 创建一个使用给定大小的输出缓冲区的新缓冲字符输出流。
 * <p>
 * 常用方法
 * void flush() 刷新流。
 * void newLine() 写一个行分隔符。
 * void write​(char[] cbuf, int off, int len) 写一个字符数组的一部分。
 * void write​(int c) 写一个字符。
 * void write​(String s, int off, int len) 写一个字符串的一部分。
 * void write(String s)写入字符串。
 * <p>
 * test：练习使用缓存区对象写入文件
 */

public class Practice1_BufferedWriter {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("E:\\file.txt");
        BufferedWriter bufw = new BufferedWriter(fw);
        bufw.write("abcdse");//先写入到缓冲区中，然后刷新流的时候才写入硬盘。
        bufw.newLine();//将写入行分割符号封装为了一个方法。仅这个有。利用了line.separator
        bufw.write("cdc");
        bufw.close();//关闭流对象，关闭前执行刷新流。
    }

}
