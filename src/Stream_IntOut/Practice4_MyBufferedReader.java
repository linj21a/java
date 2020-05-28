package Stream_IntOut;

import java.io.FileReader;
import java.io.IOException;

/**
 * 手写自己的BufferedReader，实现两个方法——
 * 1、int read()，从缓冲区读取一个字符并返回其整数，读取到末尾返回-1；
 * 2、String readLine()，一次读取一行，读取到末尾返回null
 */

public class Practice4_MyBufferedReader {
    private FileReader r;
    //1、定义一个字符缓冲区用于缓存字符
    char[] buff = new char[1024];

    //2、定义一个指针标记当前读取的位置。当读取满了就重置为0，进行下一次的读取。
    int pos = 0;
    //3、定义一个计数器，用于计算从硬盘中读取的数据值，当其递减为0，说明缓冲区的数据已经被读取完，需要重新从硬盘读取。
    int count = 0;

    /**
     * 构造器
     *
     * @param r 传入的文件输出流对象 FileReader r;
     */
    public Practice4_MyBufferedReader(FileReader r) {
        this.r = r;
    }

    /**
     * 实现BufferReader的read方法——每次缓冲区读取一个字符，读取到末尾返回-1；
     */
    public int myRead() throws IOException {
        //基于下面的代码进行优化
        if (count == 0) {
            count = r.read(buff);
            pos = 0;
        }
        if (count < 0)
            return -1;
        char ch = buff[pos++];
        count--;
        return ch;
        //1、当计数器=0，我们需要从硬盘里边读取数据存放到缓冲区
        /*if(count==0){
            count = r.read(buff);//读取的数据存放到缓冲区buff
            //加个判断，是否文件已经读取完毕
            if(count<0){
                return -1;
            }
            pos=0;//注意这里是重新从硬盘读取数据了，所以角标要归零。
            char ch = buff[pos];
            pos++;//指针往下移
            count--;
            return ch;//这里会发生转型。char转化为int。
        }else if(count>0){
            char ch = buff[pos];
            pos++;//指针往下移
            count--;
            return ch;//这里会发生转型。char转化为int。
        }else
            return -1;//count<0,说明数据已经读完了。*/

    }

    /**
     * 实现一次读取一行的功能，利用了自己的read方法，每次从自己的缓冲区中读取一行。返回字符串
     *
     * @return 返回该行字符串。
     */
    public String myReadLine() throws IOException {
        StringBuilder sb = new StringBuilder();//用来存放行数据的临时缓冲区容器
        int len;
        while ((len = myRead()) != -1) {
            //注意判断换行符号
            if (len == '\r')
                continue;
            if (len == '\n')
                return sb.toString();//完读取一行
            sb.append((char) len);
        }
        //当剩下的数据没有'\n'的时候，我们如何将剩下的数据返回呢？
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public void close() throws IOException {//关闭流
        r.close();
    }
}
