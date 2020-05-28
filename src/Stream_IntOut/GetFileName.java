package Stream_IntOut;

import java.io.*;

/**
 * 编写一个Java文件，实现提取对应目录下的文件名，文件路径并保存到fileName文件中
 */

public class GetFileName {

    public static void main(String[] args) throws IOException {
        File[] array = null;
        StringBuilder s = new StringBuilder(700);
        String path = "E:\\百度网盘下载\\java学习路线\\第一阶段 基础javaEE\\黑马程序员_历经5年锤炼(适合初学者入门)\\";
        FileOutputStream fw = new FileOutputStream("E:\\第二阶段大纲.txt");//默认会覆盖原内容。
        getFileName(path, s, fw);

        for (int i = 0; i < s.length(); i++) {
            fw.write((s.charAt(i) + "").getBytes());
        }

    }

    private static void getFileName(String path, StringBuilder s, FileOutputStream fw) throws IOException {
        File f = new File(path);
        File[] array = f.listFiles();
        for (int i = 0; i < array.length; i++) {

            if (array[i].isFile()) {//判断是否为文件
                //fname.append(array[i].getName());
                System.out.println("文件名\t" + array[i].getName());
                s.append(array[i].getName() + "\n");


            } else if (array[i].isDirectory() && !(array[i].getName().equals("历经5年锤炼(适合初学者入门的Java基础视频Code"))) {
                System.out.println("\t" + array[i].getName() + "\t");
                getFileName(array[i].getPath(), s, fw);
                System.out.println("---------------------");
            }


        }


    }
}
