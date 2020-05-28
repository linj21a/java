package Stream_IntOut;

import java.io.FileReader;
import java.io.IOException;

public class Practice4_MyBufferedReader_test {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("E:\\file.txt");
        Practice4_MyBufferedReader bufr = new Practice4_MyBufferedReader(fr);
        String len;//默认初始化为null

        //一行一行的读取
        while ((len = bufr.myReadLine()) != null) {
            System.out.println(len);
        }
        bufr.close();
    }
}
