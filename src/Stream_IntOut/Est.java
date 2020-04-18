package Stream_IntOut;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Est {

        public static void main(String[] args) {
            FileInputStream fis = null; // 声明FileInputStream对象fis
            FileOutputStream fos = null; // 声明FileOutputStream对象fos
            try {
                File srcFile = new File("E:/java/HelloWorld.java");
                fis = new FileInputStream(srcFile); // 实例化FileInputStream对象
                File targetFile = new File("E:/java/HelloWorld.java."); // 创建目标文件对象，该文件不存在
                fos = new FileOutputStream(targetFile); // 实例化FileOutputStream对象
                byte[] bytes = new byte[1024]; // 每次读取1024字节
                int i = fis.read(bytes);
                while (i != -1) {
                    fos.write(bytes, 0, i); // 向D:\HelloJava.txt文件中写入内容
                    i = fis.read(bytes);
                }
                System.out.println("写入结束！");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    assert fis != null;
                    fis.close(); // 关闭FileInputStream对象
                    assert fos != null;
                    fos.close(); // 关闭FileOutputStream对象
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

