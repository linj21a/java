package Stream_IntOut;

import java.io.File;

/**
 * 通过遍历目录可以在指定的目录中查找文件，或者显示所有的文件列表。File 类的 list() 方法提供了遍历目录功能，该方法有如下两种重载形式。
 * 1. String[] list()
 * 该方法表示返回由 File 对象表示目录中所有文件和子目录名称组成的字符串数组，如果调用的 File 对象不是目录，则返回 null。
 * <p>
 * 提示：list() 方法返回的数组中仅包含文件名称，而不包含路径。但不保证所得数组中的相同字符串将以特定顺序出现，特别是不保证它们按字母顺序出现。
 * 2. String[] list(FilenameFilter filter)
 * 该方法的作用与 list() 方法相同，不同的是返回数组中仅包含符合 filter 过滤器的文件和目录，如果 filter 为 null，则接受所有名称。
 */

/*
String path = "C:/config/"; // 指定目录位置
        File f = new File(path); // 创建File对象
        if (f.exists()) {
            f.delete();
        }
        f.mkdir(); // 创建目录
    }
 */

public class TraveseTest {

    public static void main(String[] args) {
        // separator会调用getSeparator();返回对应系统的目录
        String path = "E:" + File.separator;// 拼凑出可以适应操作系统的路径,使用File里的静态常量，自动获取系统里的是/还是\
        File f = new File(path); // 建立File变量,并设定由f变量变数引用
        System.out.println("文件名称\t\t文件类型\t\t文件大小");
        // System.out.println("===================================================");
        String[] fileList = f.list(); // 调用不带参数的list()方法

        for (String s : fileList) { // 遍历返回的字符数组
            System.out.print(s + "\t\t");
            System.out.print((new File(path, s)).isFile() ? "文件" + "\t\t" : "文件夹" + "\t\t");
            System.out.println((new File(path, s)).length() + "字节");//发现有一些文件读取的大小是错误的
        }
        System.out.println("使用过滤器过滤，只检查txt，sys结尾的文件，目录");
        //使用过滤器FileFilter
        String[] fileFile_List = f.list(new File_guolu());
        assert fileFile_List != null;
        for (String s : fileFile_List) {
            System.out.print(s + "\t\t");
            System.out.print((new File(path, s)).isFile() ? "文件" + "\t\t" : "文件夹" + "\t\t");
            System.out.println((new File(path, s)).length() + "字节");//发现有一些文件读取的大小是错误的
        }
    }
}
