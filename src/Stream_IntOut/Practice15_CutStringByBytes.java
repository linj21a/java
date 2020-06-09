package Stream_IntOut;

import java.io.UnsupportedEncodingException;

/**
 * "ab你好"将类似的字符串按照指定的字节数获取其字串，要求不能乱码！
 *
 * 如："ab你好"如果是GBK编码，就是6个字节
 * 按2个字节获取字串得——ab
 * 按3个字节获取 得——ab
 * 按4个字节获取得——ab你
 * 按5个字节得——ab你
 * 按6个字节得——ab你好
 *
 * 如果是UTF-8编码，则该段字符字节数得算以下才知道。因为有一些中文有可能只用1字节存储。如“人 ”
 *
 *
 * 逻辑——根据编码的特性，分配字节数。且基本上除了UTF-16\32不兼容ASCII码其余都兼容。
 * ASCII为单字节且为正数。
 * 中文除了GBK有些许中文是一负一正的编码值外，其余基本是正数。
 *
 * 所以我们解决这个问题的关键：
 * 1、编码字节数、编码的格式
 * 2、英文字符的编码值是正是负，中文字符编码值的正负
 */

public class Practice15_CutStringByBytes {
    public static void main(String[]args) throws UnsupportedEncodingException {
        String src = "你好啊john，我是Amy,我也是人";
        String charset = "GBK";//编码格式3个字节一般是中文。2个字节也可能是中文。
        byte[]buff = src.getBytes(charset);
        System.out.println(src+" 该字符的编码为：");
        for(byte b:buff){
            System.out.print(b+" ");//现把编码打印出来喵以下。
        }
        System.out.println();
        for(int len=1;len<=buff.length;len++){
            String subString = cutStringByBytes(buff,len,charset);//len是指定的字节数。
            System.out.println("最大字节数为"+len+"的字串为："+subString);
        }
    }
    public static String cutStringByBytes(byte[]bytes,int len,String charset) throws UnsupportedEncodingException {
        if(bytes==null)
            return null;
        if(len<=0)
            return null;
        if(len>bytes.length)
            len = bytes.length;
        int count=0;
        for(int x=len-1;x>=0;x--){
            if(bytes[x]<0){//中文编码值的个数
                count++;
            }
            else
                break;
        }
        if(charset.equals("GBK")){

            if(count%2==0){//说明中文编码字节没有单下来。如ab你共4个字节。count=2，说明“你”的字节都在。
                return new String(bytes,0,len,charset);
            }else if(len==1){
                return null;
            }
            else{
                return new String(bytes,0,len-1,charset);//说明此时只得到了汉字的一个编码值。即部首。
            }
        }else if(charset.equals("UTF-8")){
            if(count%3==0){//说明中文编码字节没有单下来
                return new String(bytes,0,len,charset);
            }else if(count%3==1){//说明中文单下了一个字节。
                return new String(bytes,0,len-1,charset);
            }
            else{
                return new String(bytes,0,len-2,charset);//说明此时只得到了汉字的一个编码值。即部首。
            }

        }else{
            return new String(bytes);//此时默认是ISO8859-1单字节编码。
        }





    }

}
