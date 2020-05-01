package Stream_IntOut;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 * 目的：动态写入文件内容，创建一个word.txt，从键盘输入，然后从第六个字节开始输出
 * 所谓动态读取是指从文件的任意位置开始访问文件，而不是必须从文件开始位置读取到文件末尾。
 * 动态读取需要用到 Java 中的 RandomAccessFile 类。
 * <p>
 * RandomAccessFile 是 Java 输入/输出流体系中功能最丰富的文件内容访问类，
 * 它提供了众多的方法来访问文件内容，它既可以读取文件内容，也可以向文件输出数据。
 * 由于 RandomAccessFile 可以从任意位置访问文件，所以在只需要访问文件部分内容的情况下，
 * 使用 RandonAccessFile 类是一个很好的选择。
 * <p>
 * RandomAccessFile 对象包含了一个记录指针，用以标识当前读写处的位置，当程序新创建一个 RandomAccessFile 对象时，
 * 该对象的文件记录指针位于文件头（也就是 0 处），当读/写了 n 个字节后，
 * 文件记录指针将会向后移动 n 个字节。除此之外，RandonAccessFile 可以自由移动该记录指针，
 * 既可以向前移动，也可以向后移动。
 * <p>
 * 应用场景：1、向10G文件末尾插入指定内容，或者向指定指针位置进行插入或者修改内容。
 *   2、断点续传，使用seek()方法不断的更新下载资源的位置。
 */

public class MoveFileWrite {
    public static void main(String... args) {

        try {
            System.out.println("系统默认编码：" + System.getProperty("file.encoding"));
            File f = new File("E:/words.txt");
            /*
            创建 RandomAccessFile 对象，以读写方式操作 File 对象。
            定义一个要写入的字符串，再将其进行格式的转换。这样是为了使其写入文件的内容不出现乱码，
            再将转换后的内容写入文件
             */
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            String str = "abc,晴天,阴天a,多云,小雨,大风,中雨,小雪,雷阵雨";
            //编码转化,系统默认的编码是UFT-8
            byte[] sbyte = str.getBytes();
            //写入文件
            raf.write(sbyte);//直接使用write写byte数组类型，
            //打印文件的当前指针
            System.out.println("当前文件指针的位置：" + raf.getFilePointer());
            //移动指针使用seek（）
            raf.seek(7);
            System.out.println("当前文件指针的位置：" + raf.getFilePointer());
            System.out.println("从文件开头跳过6个字节，现在输出的文件内容为：");
            //此时每个字符是用两个字节编码，我们输出时要注意
            // byte []buff = new byte[1024];//改为1024就不会发生byte数组截断
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buff = new byte[3];
            int len = 0;
            //发生截断问题！
            /*
            英文字母：
      字节数 : 1;编码：GB2312
      字节数 : 1;编码：UTF-8

      中文汉字：
      字节数 : 2;编码：GB2312
      字节数 : 3;编码：UTF-8
             */
            while ((len = raf.read(buff)) != -1)//每次读两个字节，read返回读取的字节数，到末尾返回-1
            {
                byteArrayOutputStream.write(buff, 0, len);

            }
            System.out.print(new String(byteArrayOutputStream.toByteArray()) + "");
        } catch (IOException e) {
            System.out.println(e);
        }


    }


}
