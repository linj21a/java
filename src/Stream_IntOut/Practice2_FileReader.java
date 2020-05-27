package Stream_IntOut;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 下面学习FileReader类
 * public class FileReader
 * extends InputStreamReader
 * 使用默认缓冲区大小从字符文件中读取文本。 从字节到字符的解码使用指定的charset或平台的default charset 。
 * FileReader用于读取字符流。 要读取原始字节流，请考虑使用FileInputStream
 * 从以下版本开始：
 * 1.1
 * 构造器有五个：
 * 从以下版本开始：
 * FileReader​(File file) 使用平台 FileReader ，在 File读取时创建一个新的 FileReader 。
 * FileReader​(FileDescriptor fd) 使用平台 default charset创建一个新的 FileReader ，给定 FileDescriptor进行读取。
 * FileReader​(File file, Charset charset) 创建一个新的FileReader ，给出File读取和charset 。
 * FileReader​(String fileName) 使用平台 default charset创建一个新的 FileReader ，给定要读取的文件的 名称 。
 * FileReader​(String fileName, Charset charset) 给定要读取的文件的名称和FileReader ，创建一个新的FileReader 。
 *
 * 理解：先建立一个字符输入流与一个文件相关联，一样会调用window的硬盘资源。
 *
 */

public class Practice2_FileReader {
    public static void main(String[]args) throws IOException {
        FileReader fw = new FileReader("E:\\file.txt");
        char[]buff = new char[1024];//常常定义为1024的整数次幂，这样在下面的while里边读取的次数较少，加快效率。
        int len=0;
        while((len=fw.read(buff))!=-1){//可能抛出异常二
            System.out.println(new String(buff,0,len));
        }

        //用完记得关闭资源
        fw.close();
    }

}
