package Stream_IntOut;

import java.io.*;

/**
 * 使用缓冲区输入流和缓冲区输出流实现复制文件的功能。
 * 并简单处理IO异常
 */

public class Practice3_BufferedWriter_BufferedReader_Copy {
    public static void main(String[] args) {
        FileWriter fw = null;
        FileReader fr = null;
        BufferedWriter bufw = null;
        BufferedReader bufr = null;
        try {
            fw = new FileWriter("E:\\file_copy2.txt");
            fr = new FileReader("E:\\file.txt");
            bufw = new BufferedWriter(fw);
            bufr = new BufferedReader(fr);

            String line;
            while ((line = bufr.readLine()) != null) {
                bufw.write(line);
                //写入换行符
                bufw.newLine();
                //刷新一次流对象
                bufw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null)
                try {
                    assert bufr != null;
                    bufr.close();
                } catch (IOException e) {
                    throw new RuntimeException("无法关闭fr流对象");
                }
            if (fw != null)
                try {
                    assert bufw != null;
                    bufw.close();
                } catch (IOException e) {
                    throw new RuntimeException("无法关闭fw流对象");
                }
        }
    }

}
