package Stream_IntOut;

import java.io.*;

/**
 * System.out对应控制台输出流。
 * public static finale OutputStream out;
 * <p>
 * OutputStreamWriter：
 * public class OutputStreamWriter
 * extends WriterOutputStreamWriter是从字符流到字节流的桥接器：
 * 使用指定的charset将写入其中的字符编码为字节。 它使用的字符集可以通过名称指定，也可以明确指定，或者可以接受平台的默认字符集。
 * 每次调用write（）方法都会导致在给定字符上调用编码转换器。 生成的字节在写入底层输出流之前在缓冲区中累积。
 * 请注意，传递给write（）方法的字符不会被缓冲。所以要加入刷新
 * <p>
 * 为了获得最高效率，请考虑在BufferedWriter中包装OutputStreamWriter，以避免频繁的转换器调用。 例如：
 * <p>
 * Writer out
 * = new BufferedWriter(new OutputStreamWriter(System.out));
 * <p>
 * 直接子类：
 * FileWriter
 * 该子类的方法全部来自OutputStreamWriter！
 */

public class Practice6_System_out_OutputStreamWriter {
    public static void main(String[] args) throws IOException {
        readKey5();
    }

    /**
     * 使用字符流转化字节流来操作System.out系统输出流。
     * 使用OutputStreamWriter
     *
     * @throws IOException 异常
     */
    public static void readKey5() throws IOException {
        /*
        InputStream ips = System.in;
        OutputStream ops = System.out;

        InputStreamReader inputSR = new InputStreamReader(ips);
        OutputStreamWriter outputSW = new OutputStreamWriter(ops);


        //再对这个字符流进行装饰，用缓冲区对象加快效率。
        BufferedReader bufr = new BufferedReader(inputSR);
        BufferedWriter bufw = new BufferedWriter(outputSW);*/

        //标准的写法
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));


        //这个时候我们就能使用缓冲区字符流的读取一行的方法。注意因为现在是字符流，所以现在可以支持输入汉字 。
        String len;
        while ((len = bufr.readLine()) != null) {
            if (len.equals("over")) {
                break;
            } else {

                //System.out.println(len.toUpperCase());
                bufw.write(len.toUpperCase());//因为是字符流
                //写入换行符
                bufw.newLine();
                //注意刷新流。
                bufw.flush();
            }
        }//该流同样不需要关。

    }

    /**
     * 使用字节转化为字符流的——InputStreamReader;
     * 字节流中通向字符流的桥梁。
     *
     * @throws IOException 可能抛出IO异常
     */
    public static void readKey4() throws IOException {
        InputStream ips = System.in;
        InputStreamReader inputSR = new InputStreamReader(ips);

        //再对这个字符流进行装饰，用缓冲区对象加快效率。
        BufferedReader bufr = new BufferedReader(inputSR);

        //这个时候我们就能使用缓冲区字符流的读取一行的方法。
        String len;
        while ((len = bufr.readLine()) != null) {
            if (len.equals("over")) {
                break;
            } else
                System.out.println(len.toUpperCase());
        }//该流同样不需要关。

    }

}
