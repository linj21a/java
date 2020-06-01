package Stream_IntOut;

import java.io.File;
import java.io.IOException;

/**
 * 练习使用
 * 1、删除和创建方法
 * delete()删除该File对象文件，可以是目录或者文件。
 * createNewFile()创建该File对象文件
 * mkdir()创建一级目录
 * mkdirs()创建多级目录
 *
 * 2、展示isFile、isDirectory、isHidden();_注意要和exits()搭配使用
 *      * 文件的封装形式决定了这些方法的结果。
 */

public class Practice8_File_isDemo {
    public static void main(String[] args) throws IOException {
        isDemo2();
    }
    /**
     * 展示isFile、isDirectory、isHidden();_注意要和exits()搭配使用
     * 文件的封装形式决定了这些方法的结果。
     */
    private static void isDemo2() throws IOException {


        //第一个，将目录封装为对象
        File file = new File("E:\\C");
        if (file.exists()) {
            System.out.println(file.isFile());//false
            System.out.println(file.isDirectory());//true
            System.out.println(file.isHidden());//false

        }
        //第二个，将文件封装为对象。
        File file1 = new File("E:\\a1.txt");
        if (file1.exists()) {
            System.out.println(file1.isFile());//true
            System.out.println(file1.isDirectory());//false
            System.out.println(file1.isHidden());//false

        }

        //现在演示a2.txt是目录的情况。
       // File file2 = new File("E:\\a2.txt");
       /* boolean res = file2.mkdir();//创建为目录
        if(res){
            System.out.println(file2.isFile());//false
            System.out.println(file2.isDirectory());//true
            System.out.println(file2.isHidden());//false
        }*/
        //演示a2是文件情况。
        File file3 = new File("E:\\a2");
        boolean res = file3.createNewFile();
        if(res){
            System.out.println(file3.isFile());//true
            System.out.println(file3.isDirectory());//false
            System.out.println(file3.isHidden());//false
        }

        //当然，一般情况不会出现这些古怪的情形。


    }

    public static void isDemo1() /*throws IOException*/{
        //将目录封装为File对象
        File file = new File("E:\\AB");

        //虽然我们认为是目录封装为File但是使用创建的话，就是一个文件对象。
        boolean res;
//        res= file.createNewFile();//既然涉及创建文件，可能有IOException
//        System.out.println(res);

        if (file.exists()) {
            //删除该目录
            res = file.delete();
            System.out.println("删除" + res);
        } else {
            res = file.mkdir();
            System.out.println("创建" + res);//单级目录

        }

        //创建多级目录
        File file2 = new File("E:\\A\\B\\C");
        //if(!file2.exists()){//发现使用mkdir()无法创建多级目录，即打印res等false，
//            res = file2.mkdir();
        res = file2.mkdirs();//make directories——E:\A\B\C
        System.out.println("创建多级目录" + res);

        //此时调用delete()来删除多级目录，只能删除最内部一级。
        res = file2.delete();
        System.out.println("删除多级目录" + res);//E:\A\B

//            注意当目录下有文件，或者当前文件被IO流操作，是无法删除目录或者对应的文件的。

        //E:\C\新建文本文档.txt
        File file3 = new File("E:\\C");
        res = file3.delete();
        System.out.println("目录下有文件时能否删除" + res);//目录下有文件时能否删除false


        //}

    }
}
