package Stream_IntOut;

import java.io.*;
import java.util.Date;

/**
 * 因为FilenameFilter只能过滤文件名，无法对File进行过滤。这样只能单纯过滤。过滤后要使用
 * 过滤的文件是做不到的。除非创建。
 * <p>
 * 进而有了对文件过滤的方法，便于过滤文件，然后使用过滤的文件的属性。继续操作。
 * 对应的接口是:FileFilter接口。
 * <p>
 * 这是一个功能接口，因此可以用作lambda表达式或方法引用的赋值目标。
 * <p>
 * --------------------------------------------------------------------------------
 *
 * //@FunctionalInterface //函数式接口，可以使用lambda表达式。
 * public interface FileFilter抽象路径名的过滤器。
 * 可以将此接口的实例传递给File类的listFiles(FileFilter)方法。
 * 只有一个抽象方法——boolean accept​(File pathname) 测试指定的抽象路径名是否应包含在路径名列表中。
 * <p>
 * 作用是用来深度遍历文件目录。
 */

public class Practice8_FileFilter {
    static int count = 0;//定义一个计数器，计算java文件的个数。
    static long size = 0L;//定义一个文件计算总的java文件数大小
    static int lineNumber = 0;//定义一个文件用于遍历java文件里边的代码行数。

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Program Files\\JetBrains\\JavaLearningStory");
        fileDeepTraver(file);
        System.out.println("从3月到6月初以来，创建的总文件数量：" + count +
                " 总代码大小：" + size + "字节 总代码行数：" + lineNumber);
    }

    /**
     * 深度遍历文件目录——D:\Program Files\JetBrains\JavaLearningStory
     * 只返回java的文件。返回其绝对路径。打印在控制台中。
     */
    public static void fileDeepTraver(File file) throws IOException {
        //static int l=2;因为静态方法是编译时就确定了，其与类的静态成员变量位于同一位置
        //进而java不允许静态方法定义静态变量。方法里边的变量只能是局部变量。

        File[] files = file.listFiles();
//        for(File f:files){
//            System.out.println(f);
//        }

        //开始深度遍历
        if (files != null)
            for (File file1 : files) {
                //取出该文件对象
                if (!file1.isDirectory()) {//是文件
                    if (file1.getName().endsWith("java"))//只输出后缀为java的文件——绝对路径和修改时间。
                    {
                        count++;
                        long length = file1.length();
                        size += length;
                        System.out.println(file1.getAbsolutePath() +
                                " 修改时间" + new Date(file1.lastModified()) + " 大小：" + length + "字节");
                        //对代码进行行数的统计。
                        lineNumber += lineNumberCount(file1);
                    }
                }
                //是目录的话就继续递归
                fileDeepTraver(file1);
            }
    }

    public static int lineNumberCount(File file1) throws IOException {
        int i = 0;
        Reader fr = new FileReader(file1);
        LineNumberReader line = new LineNumberReader(fr);
        while (line.readLine() != null) {
            i++;
        }

        return i;
    }
}
