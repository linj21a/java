package Stream_IntOut;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

/**
 * 练习使用File类的常用方法：
 * 1、获取属性
 * long getFreeSpace() 通过此抽象路径名返回分区 named中未分配的字节数。  即文件剩余可写空间
 *
 * String getName() 返回此抽象路径名表示的文件或目录的名称。
 * String getParent() 返回此抽象路径名父项的路径名字符串，如果此路径名未指定父目录，则返回 null 。
 *
 * 基于上面的方法，将父目录转化一个文件对象
 * File getParentFile() 返回此抽象路径名父项的抽象路径名，如果此路径名未指定父目录，则返回 null 。
 *
 * String getPath() 将此抽象路径名转换为路径名字符串。 ——返回Path
 *
 * boolean exists() 测试此抽象路径名表示的文件或目录是否存在。
 *
 * String getAbsolutePath() 返回此抽象路径名的绝对路径名字符串。返回绝对路径
 *
 * 将该绝对路径封装为一个绝对目录文件对象。
 * File getAbsoluteFile() 返回此抽象路径名的绝对形式。
 *
 * File getCanonicalFile() 返回此抽象路径名的规范形式。
 * String getCanonicalPath() 返回此抽象路径名的规范路径名字符串。
 *
 * long lastModified() 返回上次修改此抽象路径名表示的文件的时间。
 * long length() 返回此抽象路径名表示的文件的长度。
 *
 * 2、判断可读可写性
 * boolean canRead() 测试应用程序是否可以读取此抽象路径名表示的文件。
 * boolean canWrite() 测试应用程序是否可以修改此抽象路径名表示的文件。
 * boolean createNewFile() 当且仅当具有此名称的文件尚不存在时，以原子方式创建由此抽象路径名命名的新空文件。
 * boolean exists() 测试此抽象路径名表示的文件或目录是否存在。
 * 
 * boolean isAbsolute() 测试此抽象路径名是否为绝对路径。
 *
 * 一下两个方法要注意创建文件对象的过程，毕竟a.txt可能是文件也可能是目录。且文件不存在时都返回false
 * 所以用之前要记得判断是否存在
 * boolean isDirectory() 测试此抽象路径名表示的文件是否为目录。  
 * boolean isFile() 测试此抽象路径名表示的文件是否为普通文件。
 *
 * boolean isHidden() 测试此抽象路径名指定的文件是否为隐藏文件 
 *
 * 3、创建与删除
 * boolean mkdir() ——一级目录，创建此抽象路径名指定的目录。
 * boolean mkdirs() _多级目录，创建此抽象路径名指定的目录，包括任何必需但不存在的父目录。
 * boolean delete()_注意创建文件对象的形式，当目录下有文件，则该目录无法删除。
 * 当是多级目录，只能删除最后一个目录。
 *
 */

public class Practice8_File_Common_Method {
    public static void main(String[]args){
        commonMethod();
    }

    private static void commonMethod() {
        File file = new File("E:\\a1.txt");

        //获取信息：
        String name = file.getName();//文件名
        String path = file.getPath();//相对路径
        String abs_path = file.getAbsolutePath();//绝对路径
        long length = file.length();//文件大小是long型。
        long time = file.lastModified();//上次的修改时间，毫秒数。

//        现在格式化时间。
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        Date fileTime = new Date(time);
        String src_fileTime = dateFormat.format(fileTime);

        String parent = file.getParent();//获取父目录
        boolean read = file.canRead();//判断是否可读
        boolean write = file.canWrite();//判断是否可写。

        //打印
        System.out.println("file name: "+name+"\npath: "+path+"\nabs_path: "+abs_path
        +"\nfile size:"+length+"字节"+"\n修改时间: "+src_fileTime+"\n父目录: "+parent);

        System.out.println("是否可读："+read+"\n"+"是否可写："+write);

    }
}
