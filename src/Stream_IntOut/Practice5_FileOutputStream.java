package Stream_IntOut;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutputStream 是OutputStream的直接子类之一
 * public class FileOutputStream
 * extends OutputStream文件输出流是用于将数据写入File或FileDescriptor的输出流。 文件是否可用或是否可以创建取决于底层平台。 特别是某些平台允许一次仅打开一个文件以供写入FileOutputStream （或其他文件写入对象）。 在这种情况下，如果涉及的文件已经打开，则此类中的构造函数将失败。
 * FileOutputStream用于写入诸如图像数据的原始字节流。 要编写字符流，请考虑使用FileWriter
 *
 * API Note:
 * 要释放此流使用的资源，应直接或通过try-with-resources调用close() 。 子类负责清理子类获取的资源。
 * 应修改覆盖finalize()以执行清理的子类，以使用备用清理机制（如Cleaner）并删除重写finalize方法。
 *
 * 构造器：与对应的字符流十分相似的构造函数。append的意义一致。
 * FileOutputStream​(File file) 创建文件输出流以写入由指定的 File对象表示的文件。
 * FileOutputStream​(FileDescriptor fdObj) 创建要写入指定文件描述符的文件输出流，该文件描述符表示与文件系统中实际文件的现有连接。
 * FileOutputStream​(File file, boolean append) 创建文件输出流以写入由指定的 File对象表示的文件。
 * FileOutputStream​(String name) 创建文件输出流以写入具有指定名称的文件。
 * FileOutputStream​(String name, boolean append) 创建文件输出流以写入具有指定名称的文件。
 *
 * 常用方法：
 * 2、protected void finalize() 不推荐使用，要删除：此API元素将在以后的版本中删除。finalize方法已被弃用，将被删除。
 * 3、FileChannel getChannel() 返回与此文件输出流关联的唯一FileChannel对象。
 * 4、FileDescriptor getFD() 返回与此流关联的文件描述符。
 *
 * 最常用：
 * 1、void close() 关闭此文件输出流并释放与此流关联的所有系统资源。——要做的
 * 5、void write​(byte[] b) 将指定字节数组中的 b.length字节写入此文件输出流。
 * 6、void write​(byte[] b, int off, int len) 将从偏移量 off开始的指定字节数组中的 len字节写入此文件输出流。
 * 7、void write​(int b) 将指定的字节写入此文件输出流。
 */

public class Practice5_FileOutputStream {
    public static void main(String[]args) throws IOException {
        FileOutputStream outs = new FileOutputStream("E:\\OutStreamDemo.txt");

        outs.write("abcsefldj".getBytes());

        //不需要刷新流就已经写入了，与字符流的write不同。它不需要缓冲区解析。
        outs.flush();//实际上，FileOutputStream根本就没有实现flush。
        outs.close();//注意关闭资源，资源关闭一定要做的。
    }
}
