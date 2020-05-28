package Stream_IntOut;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 继承体系
 * java.lang.Object
 * java.io.Writer
 * java.io.OutputStreamWriter
 * java.io.FileWriter
 * FileWriter是Writer字符流的子类，FileWriter用于编写字符流。
 * 九个构造器：
 * 1、FileWriter​(File file) 给 File写一个 FileWriter ，使用平台的 default charset
 * 2、FileWriter​(FileDescriptor fd) 构造一个 FileWriter给出的文件描述符，使用该平台的 default charset 。
 * 3、FileWriter​(File file, boolean append) 在给出要写入的 FileWriter下构造 File ，并使用平台的 default charset构造一个布尔值，指示是否附加写入的数据。
 * 4、FileWriter​(File file, Charset charset) 构造一个FileWriter给予File编写和charset 。
 * 5、FileWriter​(File file, Charset charset, boolean append) 构造FileWriter给出File写入， charset和一个布尔值，指示是否附加写入的数据。
 * 6、FileWriter​(String fileName) 构造一个 FileWriter给出文件名，使用平台的 default charset
 * 7、FileWriter​(String fileName, boolean append) 使用平台的 default charset构造一个 FileWriter给定一个文件名和一个布尔值，指示是否附加写入的数据。
 * 8、FileWriter​(String fileName, Charset charset) 构造一个FileWriter给出文件名和charset 。
 * 9、FileWriter​(String fileName, Charset charset, boolean append) 构造一个FileWriter给定一个文件名， charset和一个布尔值，指示是否附加写入的数据。
 * <p>
 * 常用的构造器是：1、6、7、8、9.指定编码形式charset， append - 布尔值如果为 true ，则数据将写入文件的末尾而不是开头，支持续写。
 * 方法常用的：
 * 没有属于自己的方法，都是继承过来的方法。
 * <p>
 * 声明方法的类 java.io.OutputStreamWriter
 * flush, getEncoding, write, write, write
 * 声明方法的类 java.io.Writer
 * append, append, append, close, nullWriter, write, write
 * <p>
 * 常用的是write、append、flush、close、getEncoding。
 * <p>
 * 异常
 * IOException - 如果指定的文件存在但是是目录而不是常规文件，则不存在但无法创建，或者由于任何其他原因无法打开
 */

public class Practice1_FileWriter {
    private static final String LINE_SEPARATOR = System.lineSeparator();//获取系统的行分割符号。windows：\r\n,linux:\n

    public static void main(String[] args) throws IOException {
        //模拟输入输出
        FileWriter fw = new FileWriter("E:\\file.txt", true);//不指定append，则每次打开，只要写入就会覆盖原内容。

        // 原本的内容：file先存到缓冲区里边。现在写入了 HELLO WORLD
        fw.write("HELLO WORLD NN", 0, 12);//发现文件真的被续写了
        for (int i = 0; i < 10; i++) {
            fw.write("HELLO WORLD" + LINE_SEPARATOR);
        }
        fw.close();


    }
}
