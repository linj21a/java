package Stream_IntOut;

import java.io.*;

public class Practice10_PrintWriter {
    public static void main(String[]args) throws IOException {

        printWriteDemo1();//从控制台输入，然后直接输出到文件中。
    }

    private static void printWriteDemo1() throws IOException {
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));//注意使用转换流
        //System.in是InputStream类型。
        //PrintWriter mywriter = new PrintWriter(System.out,true);//也可以是文件对象。支持使用自动刷新对象。
        PrintWriter mywriter = new PrintWriter(new File("E:\\A3.TXT"));//直接打印到A3文件里边。

        String len;
        while((len=bufr.readLine())!=null){
            if(len.equals("over")){
                return;//退出。
            }
            mywriter.println(len);//打印字符流，保持其形式,写入len和一个空格。该方法线程同步。
            //注意，这里是字符，需要编码，所以要刷新。不想刷新是不能写入的。
            mywriter.flush();
        }
        bufr.close();
        mywriter.close();
    }
}
