package Stream_IntOut;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 编写一个类实现将一个文件复制到另外一个地方。
 * 标准形式
 * 方法一：使用fw.read()一个一个的读取
 * 方法二：使用fw.read(buff)一次读取一个数组长度。效率高！。
 */

public class Practice3_WriteAndReader_Copy {
    private static final int BUFF_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("E:\\file.txt");
            fw = new FileWriter("E:\\file_copy.txt");

            //开始拷贝
            int len = 0;
            char[] buff = new char[BUFF_SIZE];
            while ((len = fr.read(buff)) != -1) {
                fw.write(buff, 0, len);
            }
            System.out.println("复制成功！");

        } catch (IOException e) {
            throw new RuntimeException("文件找不着，复制失败");
        } finally {
            if (fw != null)
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException("fw关闭失败");
                }
            if (fr != null)
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException("fr关闭失败");
                }
        }
    }
}
