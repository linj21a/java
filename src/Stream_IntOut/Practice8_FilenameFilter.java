package Stream_IntOut;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 文件名过滤器——FilenameFilter接口。
 *
 *@FunctionalInterface
 * public interface FilenameFilter实现此接口的类的实例用于过滤文件名。
 * 这些实例用于过滤类File的list方法中的目录列表，以及Abstract Window Toolkit的文件对话框组件。
 *
 * 里边只有一个方法——
 * boolean accept​(File dir, String name)
 * 测试指定文件是否应包含在文件列表中。
 * 参数
 * dir - 找到该文件的目录。
 * name - 文件的名称。
 * 结果
 * true当且仅当名称应包含在文件列表中时; 否则为false 。
 * accept方法，通常与File里的list()方法【只能返回目录名和文件名。包括隐藏目录。】配合使用，用于过滤文件名。
 *
 * 下面演示
 * 1、过滤出java文件名。
 * 2、过滤后缀为txt的
 *

 *
 */

public class Practice8_FilenameFilter {
    public static void main(String[]args){
        javaFilter();
    }

    public static void javaFilter() {

        //注意这里是将目录封装为File对象。
        File file = new File("E:\\java");

        //简单过滤文件目录，使用匿名类创建过滤器子类。
        String [] list = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("java");//返回只以java结尾的文件。
            }
        });
        for(String s:list){
            System.out.println(s);
        }

        //实际上，如果没有传入文件名过滤器，使用默认的过滤——就是全都不过滤

        //实际上过滤过程就是：现使用默认的过滤方法，将文件名全存到一个数组，然后对这个字符数组逐一遍历
        //满足过滤条件的就存到一个新数组 ，返回这个新的字符数组。这就是文件名过滤器的原理。
    }
}
