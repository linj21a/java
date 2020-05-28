package Stream_IntOut;

import java.io.*;

/**
 * 编写一个方法 ，实现复制MP3文件。
 * <p>
 * 注意这是字节型文件，我们要用字节流。不能使用字符流。
 * 原因如下:
 * 1、字符流从硬盘读取字节文件数据的时候，不会直接操作，而是先去查编码表，然后转化为字符输入到内存中。
 * 2、如果我们用字符流来读取mp3或者jpg等文件，在查编码表的时候，由于这些不是文本数据，进而其编码形式在编码中没有对应的
 * 此时，系统会将未知编码区的编码返回替代。进而导致源数据的编码与目标数据的编码不一致。
 * <p>
 * 所以我们不能使用字符流来操作非文本文件。当然，是有几率成功的。
 */

public class Practice6_CopyFile_mp3 {
    /**
     * @param args 命令行参数。
     * @throws IOException Io异常，如打开文件失败。
     */
    public static void main(String[] args) throws IOException {
        copyFuntion2();
    }

    /**
     * 方法4：一个一个读，一个一个写，毫无效率。绝对不要用。
     *
     * @throws IOException Io异常，如打开文件失败。
     */
    public static void copyFuntion4() throws IOException {
        FileInputStream fr = new FileInputStream("E:\\0.mp3");
        FileOutputStream fw = new FileOutputStream("E:\\copy4.mp3");

        int len;
        while ((len = fr.read()) != -1) {
            fw.write(len);
        }
        fr.close();
        fw.close();

    }


    /**
     * 使用了fr.available()，不推荐啊！
     *
     * @throws IOException Io异常，如打开文件失败。
     */
    public static void copyFuntion3() throws IOException {
        FileInputStream fr = new FileInputStream("E:\\0.mp3");
        BufferedInputStream bufr = new BufferedInputStream(fr);//将缓冲区封装了起来。
        FileOutputStream fw = new FileOutputStream("E:\\copy3.mp3");
        BufferedOutputStream bufw = new BufferedOutputStream(fw);

        byte[] buff = new byte[fr.available()];//一次申请文件大小的内存，容易造成内存溢出。或创建数组内存的时间过长
        if (bufr.read(buff) != -1)//成功读取，只需要写一次。
            bufw.write(buff);
        bufr.close();
        bufw.close();

    }

    /**
     * 使用了自带缓冲区的类：BufferedInputStream，BufferedOutputStream，推荐！
     *
     * @throws IOException Io异常，如打开文件失败。
     */
    public static void copyFuntion2() throws IOException {
        FileInputStream fr = new FileInputStream("E:\\0.mp3");
        BufferedInputStream bufr = new BufferedInputStream(fr);//将缓冲区封装了起来。
        FileOutputStream fw = new FileOutputStream("E:\\copy2.mp3");
        BufferedOutputStream bufw = new BufferedOutputStream(fw);

        byte[] buff = new byte[1024];//申请1K
        int len;
        while ((len = bufr.read(buff)) != -1) {//从硬盘读取到类对象的缓冲区，再使用read从缓冲区读取到内存。
            bufw.write(buff, 0, len);//直接写入字节。不用刷新。
        }
        bufr.close();
        bufw.close();

    }

    /**
     * 方法1——仅使用FileInputStream、FileOutputStream。自定义缓冲区buff数组，效率上 ，较小缓冲区的时候比方法2快。但是开发用方法2.
     *
     * @throws IOException Io异常，如打开文件失败。
     */
    public static void copyFuntion1() throws IOException {
        FileInputStream fr = new FileInputStream("E:\\0.mp3");
        FileOutputStream fw = new FileOutputStream("E:\\copy1.mp3");

        byte[] buff = new byte[1024];
        int len;
        while ((len = fr.read(buff)) != -1) {//从硬盘读取到自己定义的缓冲区。
            fw.write(buff, 0, len);//直接写入字节。不用刷新。
        }
        fr.close();
        fw.close();
    }
}
