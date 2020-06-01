package Stream_IntOut;

import java.io.*;

/**
 * 因为FileReader和FileWriter都是使用默认的系统编码表进行解码编码。
 * 无法满足我们的一些要指定编码表的需求。
 * 继而我们需要使用转换流。
 * 他们是可以指定编码表的
 * InputStreamReader
 * OutputStreamWriter
 * GBK——中文默认2个字节
 * UTF-8改进了UNICODE编码的浪费空间的缺点。中文编码3个字节。
 * <p>
 * 什么时候使用转换流？
 * 1、源或者目的的设备时字节流，但是操作的却是文本数据。这个时候可以使用转换流。作为桥梁。
 * 2、一旦文本数据要求制定编码表，必须使用转换流。
 * <p>
 * 注意！一般File开头的类都是已经使用了默认编码表。
 */

public class Practice7_InputStreamReader_OutputStreamWriter {
    public static void main(String[] args) throws IOException {
     /*   writeChinese();
        readChinese();
        */
        writeMyEncode();
        readMyEncode();
    }

    public static void readMyEncode() throws IOException {
        InputStreamReader ipr = new InputStreamReader(new FileInputStream("E:\\a1.txt"), "GBK");
        //不加编码时，等价于FileReader fr = new FileReader("E:\\a1.txt");，实际上FileReader就是InputStreadReader的指定了特定编码的子类，
        //用于操作文本数据。
        char[] buff = new char[100];
        int len = ipr.read(buff);
        System.out.println(new String(buff, 0, len));
        System.out.println(ipr.getEncoding());//发现除了英文编码一致，中文编码以及乱码了。
    }

    public static void writeMyEncode() throws IOException {
        OutputStreamWriter opw = new OutputStreamWriter(new FileOutputStream("E:\\a1.txt"), "GBK");
        opw.write("使用自己指定的编码GBK");//中文两个字节，英文一个字节，这里共21个字节。
        opw.close();
    }

    public static void readChinese() throws IOException {
        FileReader fr = new FileReader("E:\\a.txt");
        char[] buff = new char[100];
        int len = fr.read(buff);
        System.out.println(new String(buff, 0, len));//6 字节 (6 字节)发现是6个字节。
        System.out.println(fr.getEncoding());//说明本机默认编码是UTF-8

    }

    public static void writeChinese() throws IOException {
        FileWriter fw = new FileWriter("E:\\a.txt");
        fw.write("你好");
        fw.close();
    }
}
