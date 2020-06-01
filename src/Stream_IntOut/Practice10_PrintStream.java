package Stream_IntOut;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * public class PrintStream
 * extends FilterOutputStream
 * implements Appendable, CloseablePrintStream
 * <p>
 * 打印字节输出流。将字节打印到流中。
 * 特点：
 * 1、向另一个输出流添加功能，即能够方便地打印各种数据值的表示。 同时保持其形式上的不变。（实际是变成字符串保持）
 * 2、PrintStream永远不会抛出IOException ;
 * 相反，异常情况仅设置可通过checkError方法测试的内部标志。
 * 3、支持自动刷新，可选地，可以创建PrintStream以便自动刷新;
 * 这意味着flush字节数组写入方法后自动调用，所述一个println方法被调用时，或者一个新行字符或字节（ '\n' ）被写入。
 * PrintStream打印的所有字符都使用给定的编码或字符集转换为字节，如果未指定，则使用平台的默认字符编码。
 * 此类始终使用charset的默认替换字符串替换格式错误且不可映射的字符序列。 当需要更多地控制编码过程时，应使用CharsetEncoder类。
 * <p>
 * <p>
 * PrintWriter类应该在需要写入字符而不是字节的情况下使用。 能够使得写入的字符形式不变。
 * <p>
 * 构造器：（总结起来只有三种）
 * <p>
 * 1、File参数
 * 2、String表示的路径
 * 3、OutputStream out，传入一个输出字节流。
 * <p>
 * 新的方法；
 * 各类打印的方法
 * print()
 * println()会写入换行
 * <p>
 * write(int)——继承FileOutputStream——只写低8位，只写一个字节。
 * print(int)——则是将其转化位字符串，在写。
 * <p>
 * public void print(int i) {
 * write(String.valueOf(i));
 * }
 */

public class Practice10_PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        printStreamDemo();

    }

    public static void printStreamDemo() throws FileNotFoundException {
        PrintStream ps = new PrintStream("E:\\a.txt");//不会自动刷新

        ps.write(97);//int的低8位写入，0000-000-0000-0000-0000-0000-  ‭0110-0001‬ 所以写了a
        ps.write(609);//00000000-0000‭0010-0110-0001‬_低8位和a一样。所以写了也是a
        //因为是字节流。write直接编码写入。所以不需要刷新流。不会自动刷新
        //ps.flush();
        ps.println(97);//写入到 是97和\r\n，因为将其转化为了字符串，然后再编码，而字符的编码必然在一个字节的范围内。
        //9是字符ASCII，7是一个字符。所以这里写入了4个字节。
        //关闭流
        ps.print("abc");
        ps.close();
    }
}
