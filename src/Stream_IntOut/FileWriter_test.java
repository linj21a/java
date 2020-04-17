package Stream_IntOut;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriter_test {
    public static void main(String[]a) throws IOException {
        Scanner input = new Scanner(System.in);
        FileWriter fw =null;//必须定义在外头否则写不进去。
        try{
          fw = new FileWriter("E:\\words.txt");//默认会覆盖原内容。

            //写入内容
            System.out.println("开始写入内容：");
            String c = input.next();
            fw.write(c);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            assert fw!=null;
            fw.close();
            System.out.println("谢谢使用！");
        }


    }
}
