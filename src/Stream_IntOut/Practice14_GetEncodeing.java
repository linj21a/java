package Stream_IntOut;
/*
练习编码
 */

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Practice14_GetEncodeing {
    public static void main(String[]args) throws IOException {
        System.out.println(System.getProperty("file.encoding"));
        String s = "你a好";
        byte []buff = s.getBytes();//使用默认平台的编码,这里是UTF-8
        for(byte b:buff){
            System.out.print(b+",");
        }//“你好” UTF-8：-28,-67,-96,-27,-91,-67,
        System.out.println(buff.length);
        //解码
        String encode_s = new String(buff,"GBK");
        System.out.println(encode_s);//乱码！因为GBK是2字节编码，所以当编码的UTF-8编码是2的倍数，有可能有解。

        byte[]buff2 = encode_s.getBytes("GBK");
        System.out.println(new String(buff2, StandardCharsets.UTF_8));//你好。
        //当编码的UTF-8编码不是2的倍数，且多出的字节不是ASCII码，或者ASCII处于截断位置。无解。
        //将你好改为：你好人——9个字节。你好a可以解，你a好 无法解。
        //因为用GBK解码是每次解两个字节。a在后面，则可以解。

        //联通问题
        buff2 = "联通".getBytes(StandardCharsets.UTF_8);//UTF-8编码
        for(byte b:buff2){
            System.out.println(Integer.toBinaryString(b&255));
            /*
            1110-1000
            1000-0001
            1001-0100
            1110-1001
            1000-0000
            1001-1010
             */
        }
        buff2 = "联通".getBytes("GBK");//UTF-8编码
        for(byte b:buff2){
            System.out.println(Integer.toBinaryString(b&255));
            /*
            1100-0001
            1010-1010
            1100-1101
            1010-1000
             */
        }
    }
}
