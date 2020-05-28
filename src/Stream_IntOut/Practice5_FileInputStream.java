package Stream_IntOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 字节输入流——InputStream
 * public class FileInputStream
 * extends InputStreamA FileInputStream
 * 从文件系统中的文件获取输入字节。 可用的文件取决于主机环境。
 * FileInputStream用于读取诸如图像数据的原始字节流。 要读取字符流，请考虑使用FileReader 。
 * <p>
 * 构造器：
 * FileInputStream​(File file) 通过打开与实际文件的连接来创建 FileInputStream ，该文件由文件系统中的 File对象 file命名。
 * FileInputStream​(FileDescriptor fdObj) 使用文件描述符 fdObj创建 FileInputStream ，该文件描述符表示与文件系统中实际文件的现有连接。
 * FileInputStream​(String name) 通过打开与实际文件的连接来创建 FileInputStream ，该文件由文件系统中的路径名 name命名。
 * 常用方法：
 * 1、int read() 从此输入流中读取一个字节的数据。
 * 2、int read​(byte[] b) 从此输入流 b.length最多 b.length字节的数据读 b.length字节数组。
 * 3、int read​(byte[] b, int off, int len) 从此输入流 len最多 len字节的数据读入一个字节数组。
 * 4、long skip​(long n) 跳过并从输入流中丢弃 n字节的数据。
 * 5、int available() 返回可以从此输入流中读取（或跳过）的剩余字节数的估计值，而不会被下一次调用此输入流的方法阻塞。
 * 6、void close() 关闭此文件输入流并释放与该流关联的所有系统资源。
 * <p>
 * <p>
 * 需要使用close()关闭资源。
 * <p>
 * API Note:
 * 要释放此流使用的资源，应直接或通过try-with-resources调用close() 。
 * 子类负责清理子类获取的资源。 应修改覆盖finalize()以执行清理的子类，以使用备用清理机制（如Cleaner）并删除重写finalize方法。
 */

public class Practice5_FileInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream inputs = null;
        try {
            inputs = new FileInputStream("E:\\file.txt");
            //方式一读取，推荐使用方式一，安全。
            byte[] buff1 = new byte[1024];//申请1k大小的空间，当文件过大时也不会发生内存溢出
            int len = 0;
            while ((len = inputs.read(buff1)) != -1) {
                System.out.println(new String(buff1, 0, len));
            }
       /* //方式二：
        byte []buff2 = new byte[inputs.available()];//直接申请文件大小的字节，容易发生内存溢出。比如我们内存只有3G，文件大小4G.
        //只需要读取一次。
        inputs.read(buff2);
        System.out.println(new String(buff2));
        */
            //记得关闭资源，避免造成灾难
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputs != null)
                inputs.close();
        }

    }
}
