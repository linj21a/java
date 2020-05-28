package Stream_IntOut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 练习键盘录入
 * 键盘是一个输入设备，那么必然有一个系统输入流类与之对应我们才能进行输入。
 * 它就是System.in;
 * 这是一个静态共享输入类
 * public static finale InputStream in;
 */

public class Practice6_System_in_InputStreamReader {
    public static void main(String[] args) throws IOException {
        readKey4();
//        System.out.println((int)'r'+" "+(int)'\n');// \r是整数145，\n是10，我们这里的enter就是对应了 \n
    }

    /**
     * 使用字节转化为字符流的——InputStreamReader;
     * 字节流中通向字符流的桥梁。
     */
    private static void readKey4() throws IOException {
        /*InputStream ips = System.in;
        InputStreamReader inputSR = new InputStreamReader(ips);

        //再对这个字符流进行装饰，用缓冲区对象加快效率。
        BufferedReader bufr = new BufferedReader(inputSR);*/
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        //这个时候我们就能使用缓冲区字符流的读取一行的方法。
        String len;
        while ((len = bufr.readLine()) != null) {
            if (len.equals("over")) {
                break;
            } else
                System.out.println(len.toUpperCase());
        }//该流同样不需要关。

    }

    /**
     * 创建一个方法，进行键盘的录入
     * 其中输入over表示结束。
     * 一般我们是不读取 \r,\n的。
     *
     * @throws IOException 异常
     */
    private static void readKey3() throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStream ins = System.in;

        //从键盘读取一个字符
        int len;
        while ((len = ins.read()) != -1) {//循环读取,发现很像readLine()
            switch (len) {
                case '\r':
                    continue;
                case '\n':
                    String temp = sb.toString();
                    if ("over".equals(temp)) {
                        return;
                    } else System.out.println(temp);
                    sb.delete(0, sb.length());
                    break;
                default:
                    sb.append((char) len);
            }

        }//这是阻塞式方法，会等到输入，读取到了数据才执行，未读取数据会一直等。

        ins.close();

    }

    private static void readKey2() throws IOException {
        InputStream ins = System.in;
        //从键盘读取一个字符,这里使用来4个read方法，说明读取4个字符。
//        包括了\r，\n

        int len1 = ins.read();//这是阻塞式方法，会等到输入，读取到了数据才执行，未读取数据会一直等。
        System.out.println(len1);//这个流一般我们不能关。否则之后无法使用。
        int len2 = ins.read();//这是阻塞式方法，会等到输入，读取到了数据才执行，未读取数据会一直等。
        System.out.println(len2);//这个流一般我们不能关。否则之后无法使用。
        int len3 = ins.read();//这是阻塞式方法，会等到输入，读取到了数据才执行，未读取数据会一直等。
        System.out.println(len3);//这个流一般我们不能关。否则之后无法使用。
        int len4 = ins.read();//这是阻塞式方法，会等到输入，读取到了数据才执行，未读取数据会一直等。
        System.out.println(len4);//这个流一般我们不能关。否则之后无法使用。

    }

    private static void readKey1() throws IOException {
        InputStream ins = System.in;

        //从键盘读取一个字符
        int len = ins.read();//这是阻塞式方法，会等到输入，读取到了数据才执行，未读取数据会一直等。

        System.out.println((char) len);//这个流一般我们不能关。否则之后无法使用。
        ins.close();
//        int len2 = ins.read();//Exception in thread "main" java.io.IOException: Stream closed,此时我们无法再使用键盘的输入流in对象
    }
}
