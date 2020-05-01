package Stream_IntOut;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 为了读取方便，Java 提供了用来读取字符文件的便捷类——FileReader。该类的构造方法有如下两种重载形式。
 * FileReader(File file)：在给定要读取数据的文件的情况下创建一个新的 FileReader 对象。其中，file 表示要从中读取数据的文件。
 * FileReader(String fileName)：在给定从中读取数据的文件名的情况下创建一个新 FileReader 对象。其中，fileName 表示要从中读取数据的文件的名称，
 * 表示的是一个文件的完整路径。
 * <p>
 * 在用该类的构造方法创建 FileReader 读取对象时，默认的字符编码及字节缓冲区大小都是由系统设定的。要自己指定这些值，
 * 可以在 FilelnputStream 上构造一个 InputStreamReader。
 * <p>
 * <p>
 * 字符流和字节流的操作步骤相同，都是首先创建输入流或输出流对象，即建立连接管道，建立完成后进行读或写操作，最后关闭输入/输出流通道。
 * <p>
 * <p>
 * Java 提供了写入字符文件的便捷类——FileWriter，该类的构造方法有如下 4 种重载形式。
 * FileWriter(File file)：在指定 File 对象的情况下构造一个 FileWriter 对象。其中，file 表示要写入数据的 File 对象。
 * FileWriter(File file,boolean append)：在指定 File 对象的情况下构造一个 FileWriter 对象，如果 append 的值为 true，
 * 则将字节写入文件末尾，而不是写入文件开始处。
 * FileWriter(String fileName)：在指定文件名的情况下构造一个 FileWriter 对象。其中，fileName 表示要写入字符的文件名，表示的是完整路径。
 * FileWriter(String fileName,boolean append)：在指定文件名以及要写入文件的位置的情况下构造 FileWriter 对象。
 * 其中，append 是一个 boolean 值，如果为 true，则将数据写入文件末尾，而不是文件开始处。
 */

public class FileRead_Test {
    public static void main(String[] args) {
        File f = new File("E:/words.txt");
        FileReader fi = null;
        try {
            if (f.exists()) {
                System.out.println("读取文件完成！");//专门用来读字符的
                //创建文件输入流
                fi = new FileReader(f);
                //开始读文件
                char[] buff = new char[1024];//使用字符数组
                int len;
                System.out.println("源文件的内容为");
                while ((len = fi.read(buff, 0, buff.length)) != -1) {
                    System.out.print(new String(buff, 0, len));
                }

            } else {
                System.out.println("读取文件失败，请检查路径！");
            }


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                assert fi != null;
                fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
