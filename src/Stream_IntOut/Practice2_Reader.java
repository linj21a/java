package Stream_IntOut;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Reader 是字符输入流的顶层父类，
 * public abstract class Reader
 * extends Object
 * implements Readable, Closeable用于读取字符流的抽象类。
 * 子类必须实现的唯一方法是read（char []，int，int）和close（）。 但是，大多数子类将覆盖此处定义的一些方法，以提供更高的效率，附加功能或两者兼而有之。
 * 从以下版本开始：
 * 1.1
 * 相关直接的子类：
 * BufferedReader ， CharArrayReader ， FilterReader ， InputStreamReader ， PipedReader ， StringReader ， URLReader
 * 常用的间接子类：
 * FileReader
 *
 * */
public class Practice2_Reader {
    public static void main(String[]args) throws IOException {
        Reader fw = new FileReader("E:\\file.txt");//可能抛出异常一
        char[]buff = new char[1024];//常常定义为1024的整数次幂，这样在下面的while里边读取的次数较少，加快效率。
        int len=0;
        while((len=fw.read(buff))!=-1){//可能抛出异常二
            System.out.println(new String(buff,0,len));
        }
        //记得关闭资源
        fw.close();
    }
}
