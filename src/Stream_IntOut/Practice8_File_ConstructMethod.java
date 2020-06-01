package Stream_IntOut;

import java.io.File;

/**
 * IO流使用来 操作文件里边的数据的
 * 但是无法操作文件的属性——如大小，修改时间，目录等。
 * File对象于是就产生了。
 * <p>
 * public class File
 * extends Object
 * implements Serializable, Comparable<File>
 * <p>
 * 将文件与其目录路径名、其他属性进行封装，成为一个类。
 * 构造器：
 * 1、File​(String pathname) 通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
 * 2、File​(String parent, String child) 从父路径名字符串和子路径名字符串创建新的 File实例。
 * 实际就是将第一个构造器的文件路径分割出父目录和文件名
 * 3、File​(File parent, String child) 从父抽象路径名和子路径名字符串创建新的 File实例。
 * 而这个构造器则是将父目录封装为了一个文件对象。
 * <p>
 * 4、File​(URI uri) 通过将给定的 file: URI转换为抽象路径名来创建新的 File实例。
 * <p>
 * 所以文件对象可以是文件夹或者文件
 * File
 */

public class Practice8_File_ConstructMethod {
    public static void main(String[] args) {
        fileConstructDemo();
    }

    private static void fileConstructDemo() {
        //第一个构造器
        File file1 = new File("a.txt");//绝对目录

        //第二个构造器，更加便于修改，灵活
        File file2 = new File("E:\\", "a.txt");

        //第三个构造器，将父目录封装为了file对象
        File file3 = new File(new File("E:\\"), "a.txt");

        //打印出每个文件对象的属性——文件名，绝对路径，相对路径
        System.out.println("file1 name:" + file1.getName() + " " +
                "absPath:" + file1.getAbsolutePath() + " Path: " + file1.getPath()+"Parent: "+file1.getParent());
        //注意此时File("a.txt");path就是a.txt，意味则父目录为null

        System.out.println("file2 name:" + file2.getName() + " " +
                "absPath:" + file2.getAbsolutePath() + " Path: " + file2.getPath());
        System.out.println("file3 name:" + file3.getName() + " " +
                "absPath:" + file3.getAbsolutePath() + " Path: " + file3.getPath());

        //说明一点：相对路径是相对一个路径下是表述
        //getPath()方法是构造的文件对象所给的路径是什么就是什么，而绝对路径则不会变化。
        //如File("a.txt");path就是a.txt,File("c:\\de\\a.txt")path就是c:\de\a.txt




    }
}
