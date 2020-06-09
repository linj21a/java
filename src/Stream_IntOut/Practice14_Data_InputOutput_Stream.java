package Stream_IntOut;

import java.io.*;

/**如果只需要操作基本数据——使用Data Stream
 *public class DataInputStream
 * extends FilterInputStream
 * implements DataInput数据输入流允许应用程序以与机器无关的方式从底层输入流中读取原始Java数据类型。
 * 应用程序使用数据输出流来写入稍后可由数据输入流读取的数据。
 * DataInputStream对于多线程访问不一定安全。 线程安全是可选的，是本课程中方法用户的责任。
 *
 * 从以下版本开始：
 * 1.0
 *
 * 构造器只有一个：
 * DataInputStream​(InputStream in) 创建使用指定的基础InputStream的DataInputStream。
 *
 * 特有方法：
 * static String readUTF​(DataInput in) 从流in读取以modified UTF-8格式编码的Unicode字符串的表示; 然后将此字符串作为String返回。
 * int skipBytes​(int n) 参见 skipBytes方法 DataInput的总合同。
 * void readFully​(byte[] b) 参见 readFully方法 DataInput的总合同。
 * void readFully​(byte[] b, int off, int len) 见的总承包 readFully的方法 DataInput 。
 * ######################################################
 * public class DataOutputStream
 * extends FilterOutputStream
 * implements DataOutput数据输出流允许应用程序以可移植的方式将原始Java数据类型写入输出流。
 * 然后，应用程序可以使用数据输入流来重新读取数据。
 * 从以下版本开始：
 * 1.0
 * 构造器只有一个
 * DataOutputStream​(OutputStream out) 创建新数据输出流以将数据写入指定的基础输出流。
 * 特有方法：（其他方法与RandomAccessFile或者ObjectOutputStream类似）
 * int size() 返回计数器 written的当前值，即 written写入此数据输出流的字节数。
 * void writeUTF​(String str) 使用 modified UTF-8编码以与机器无关的方式将字符串写入基础输出流。
 *
 * 注意writeUTF方法写入的字符串会带有UTF的标识符。
 */

public class Practice14_Data_InputOutput_Stream {
    public static void main(String[]args) throws IOException {
        dataWriterDemo();
        System.out.println("写入完毕！开始读取！");
        dataReadDemo();
        System.out.println("读取完毕！");
    }

    public static void dataReadDemo() throws IOException {
        DataInputStream In = new DataInputStream(new FileInputStream("E:\\data.txt"));
        /*boolean b = In.readBoolean();
        double d = In.readDouble();
        float f = In.readFloat();
        System.out.println("布尔值"+b+"双精度浮点值"+d+"单精度浮点值"+f);*/
        String utf_s = In.readUTF();
        System.out.println("使用writeUTF()写，用readUTF()读出来是："+utf_s);
        In.close();
    }

    public static void dataWriterDemo() throws IOException {
        //1、创建流
        DataOutputStream out = new DataOutputStream(new FileOutputStream("E:\\data.txt"));
       /* out.writeBoolean(true);//写一个布尔型
        out.writeDouble(1.233);//写一个double型
        out.writeFloat(1.2f);//写一个float型*/
        /*
        实际记事本中打开
        ?蠛^5?|?櫃?
        解析不了的。
         */
        out.writeUTF("你好！");
        /*
        ?蠛^5?|?櫃? 	浣犲ソ锛?
         */

        //当只写了 out.writeUTF("你好！");记事本解析为：	你好。共11个字节。原因在于UTF编码会加入一些标识，然后中文3个字节。共
        //6个字节，而标识占5字节。
        out.close();
    }

}
