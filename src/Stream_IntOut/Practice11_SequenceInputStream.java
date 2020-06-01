package Stream_IntOut;

import java.io.*;
import java.util.*;


/**
 * 序列流：
 * 因为一个流只能关联一个源（文件），多个源才能关联多个文件
 * 进而我们如果要同时操作多个文件，将其汇合为一个文件需要创建三个对象，分别操作。
 * <p>
 * 所以有了序列流，使得一个对象能操作多个流，进而依次操作多个文件。
 * 实现诸如：将文件1，文件2，文件3.。。等都写入到文件A的需求。
 * <p>
 * 该流是字节流。可以操作字符、媒体，图片等数据。
 * 应用：文件切割——当文件达到上传限制，现将文件按需划分上传为文件碎片，进而下载的时候将文件碎片下载并合并即可得到源文件。
 * <p>
 * public class SequenceInputStream
 * extends InputStreamSequenceInputStream表示其他输入流的逻辑串联。 它从一个有序的输入流集合开始，从第一个读取到文件结束，
 * 然后从第二个读取，依此类推，直到最后一个包含的输入流到达文件末尾。
 * 从以下版本开始：
 * 1.0
 * <p>
 * 构造器：
 * 1、SequenceInputStream​(InputStream s1, InputStream s2)
 * 通过记住两个参数来初始化新创建的 SequenceInputStream ，这两个参数将按顺序读取，首先是 s1 ，然后是 s2 ，
 * 以提供要从此 SequenceInputStream读取的字节。
 * 2、SequenceInputStream​(Enumeration<? extends InputStream> e) //枚举型。泛型为InputStream的子类。
 * 通过记住参数初始化新创建的 SequenceInputStream ，该参数必须是 Enumeration ，它生成运行时类型为 InputStream 。
 * <p>
 * 至于常用方法同字节输入流一致。
 */

public class Practice11_SequenceInputStream {
    public static void main(String[] args) throws IOException {
        // sequenceInputStreamDemo1();
        sequenceInputStreamDemo2();
    }

    /**
     * 构造器1演示
     *
     * @throws IOException 可能发生异常
     */
    public static void sequenceInputStreamDemo1() throws IOException {

        //构造器1演示
        InputStream ip1 = new FileInputStream("E:\\A3.TXT");
        InputStream ip2 = new FileInputStream("E:\\a.txt");
        SequenceInputStream seqInStream = new SequenceInputStream(ip1, ip2);

        FileOutputStream fileOutput = new FileOutputStream("E:\\sequencers.txt");

        byte[] buff = new byte[1024];
        int len;
        while ((len = seqInStream.read(buff)) != -1) {//读\r\n
            fileOutput.write(buff, 0, len);
        }
        fileOutput.close();
        seqInStream.close();
        System.out.print("写入完成。");
    }

    /**
     * 构造器2演示
     *
     * @throws IOException 可能发生异常
     */
    public static void sequenceInputStreamDemo2() throws IOException {
        //枚举的方式一
      /*  Vector<FileInputStream> myfile = new Vector<>();
        myfile.add(new FileInputStream("E:\\A3.TXT"));
        myfile.add(new FileInputStream("E:\\a.txt"));
        myfile.add(new FileInputStream("E:\\sequencers.txt"));

        Enumeration<FileInputStream> files = myfile.elements();//因为Vector是同步的，所以效率特别低。*/

        //方式二
        ArrayList<FileInputStream> myfile = new ArrayList<>();
        myfile.add(new FileInputStream("E:\\A3.TXT"));
        myfile.add(new FileInputStream("E:\\a.txt"));
        myfile.add(new FileInputStream("E:\\sequencers.txt"));
        /*final Iterator<FileInputStream> it = myfile.iterator();
        Enumeration<FileInputStream> files = new Enumeration<FileInputStream>() {
            @Override
            public boolean hasMoreElements() {//匿名内部类访问局部变量必须为final类型。
                return it.hasNext();
            }
            @Override
            public FileInputStream nextElement() {
                return it.next();
            }
        };*/

        //方式三，因为方式二的繁琐，进而我们可以使用已经包装好的集合工具类的方法。实际上他的原理就是上面的那个。
        Enumeration<FileInputStream> files = Collections.enumeration(myfile);


        SequenceInputStream sequenceInputStream = new SequenceInputStream(files);
        //一样可以使用装饰，使用缓冲区。
        BufferedReader bufr = new BufferedReader(new InputStreamReader(sequenceInputStream));

        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter
                (new FileOutputStream("E:\\sequencers2.txt")));

        String len;
        while ((len = bufr.readLine()) != null) {//不读\r\n
            bufw.write(len);
            bufw.newLine();
        }
        bufw.close();
        bufr.close();
        System.out.print("写入完毕。");

    }

}
