package Stream_IntOut;

import java.io.*;

/**
 * BufferedReader 写缓冲区，
 * 继承关系
 * java.lang.Object
 * java.io.Reader
 * java.io.BufferedReader
 * 构造器：
 * BufferedReader​(Reader in) 创建使用默认大小的输入缓冲区的缓冲字符输入流。
 * BufferedReader​(Reader in, int sz) 创建使用指定大小的输入缓冲区的缓冲字符输入流。
 *
 * 方法：
 * Stream<String> lines() 返回 Stream ，其元素是从此 BufferedReader读取的行。
 * void mark​(int readAheadLimit) 标记流中的当前位置。
 * boolean markSupported() 判断此流是否支持mark（）操作。
 * int read() 读一个字符。  ——常用
 * int read​(char[] cbuf, int off, int len) 将字符读入数组的一部分。 ——常用
 * String readLine() 读一行文字。  ——常用
 * boolean ready() 判断此流是否可以读取。
 * void reset() 将流重置为最新标记。
 * long skip​(long n) 跳过字符。
 *
 * readLine()原理：流对象先使用其read()方法从硬盘上读取文件数据写入到缓冲区中，然后调用
 * BufferedReader的read()方法从缓冲区中读取数据，暂存到一个临时容器，判断换行符（\r,\n）
 * 使得每次只读取一行并返回该行数据字符串
 *
 * test：使用BufferedReader演示读取一个文件
 */

public class Practice2_BufferedReader {
    public static void main(String[]args) throws IOException {
        FileReader fr = new FileReader("E:\\file.txt");
        BufferedReader bufr = new BufferedReader(fr);
        String len;//默认初始化为null

        /*//单个读取
        while((len=bufr.read())!=-1){
            System.out.println((char)len);
        }*/

        //一行一行的读取
        while((len=bufr.readLine())!=null){
            System.out.println(len);
        }
        bufr.close();
    }

}
