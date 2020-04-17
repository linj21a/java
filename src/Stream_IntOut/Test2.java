package Stream_IntOut;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Java 中常见编码说明如下：
 * ISO8859-1：
 * 属于单字节编码，最多只能表示 0~255 的字符范围。
 * GBK/GB2312：
 * 中文的国标编码，用来表示汉字，属于双字节编码。GBK 可以表示简体中文和繁体中文，而 GB2312 只能表示简体中文。GBK 兼容 GB2312。
 * Unicode：
 * 是一种编码规范，是为解决全球字符通用编码而设计的。UTF-8 和 UTF-16 是这种规范的一种实现，此编码不兼容 ISO8859-1 编码。Java 内部采用此编码。
 * UTF：
 * UTF 编码兼容了 ISO8859-1 编码，同时也可以用来表示所有的语言字符，不过 UTF 编码是不定长编码，每一个字符的长度为 1~6 个字节不等。
 * 一般在中文网页中使用此编码，可以节省空间。
 *
 * 在程序中如果处理不好字符编码，就有可能出现乱码问题。例如现在本机的默认编码是 GBK，但在程序中使用了 ISO8859-1 编码，
 * 则就会出现字符的乱码问题。就像两个人交谈，一个人说中文，另外一个人说英语，语言不同就无法沟通。为了避免产生乱码，程序编码应与本地的默认编码保持一致。
 */
//本地的默认编码可以使用 System 类查看。Java 中 System 类可以取得与系统有关的信息，所以直接使用此类可以找到系统的默认编码。方法如下所示：
//public static Properties getProperty()

//如果要实现编码的转换可以使用 String 类中的 getBytes(String charset) 方法，此方法可以设置指定的编码，该方法的格式如下：

public class Test2 {
    public static void main(String[] args)throws Exception {
        // 获取当前系统编码
        System.out.println("系统默认编码：" + System.getProperty("file.encoding"));//UTF-8
        //定义一个文件对象，参数为文件的地址，直接使用构造函数。
        //程序启动时会检测该文件是否存在，如果不存在则创建；如果存在则删除它再创建。
        File f = new File("E:" + File.separator + "test.txt");
        // 实例化输出流，使用向上转型
        //因为File 类不能访问文件内容本身，如果需要访问文件内容本身，则需要使用输入/输出流。
        OutputStream out = new FileOutputStream(f);//必须在main函数那里声明可能抛出的异常
        // 指定ISO8859-1编码
        byte b[] = "C语言中文网，你好！".getBytes("UTF-8");
        // 保存转码之后的数据，调用out方法写入对象
        out.write(b);
        // 关闭输出流
        out.close();

        //下面我们使用File来读取这个文件里面的东西
        //返回当前 File 对象大小
        System.out.println(f.length());//28字节大小
    }
}
