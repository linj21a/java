package Stream_IntOut;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * 演示带行号的LineNumberReader_Reader的子类
 * 构造器：
 * 两个
 * 1、 public LineNumberReader(Reader in) {
 * super(in);
 * }
 * 2、 public LineNumberReader(Reader in, int sz) {
 * super(in, sz);
 * }
 * <p>
 * 常用方法：
 * 1、设置行号起始：
 * public void setLineNumber(int lineNumber) {
 * this.lineNumber = lineNumber;
 * }
 * 2、获取行号数
 * public int getLineNumber() {
 * return lineNumber;
 * }
 * <p>
 * 缓冲的字符输入流，用于跟踪行号。 该类定义了方法setLineNumber(int)和getLineNumber() ，分别用于设置和获取当前行号。
 * 默认情况下，行号从0开始。此数字在读取数据时每line terminator递增一次，并且可以通过调用setLineNumber(int)进行更改。
 * 但请注意， setLineNumber(int)实际上并未更改流中的当前位置; 它只会更改getLineNumber()返回的getLineNumber() 。
 * <p>
 * 通过换行符（'\ n'），回车符（'\ r'）或回车符后面的任何一行，行被认为是terminated 。
 */

public class Practice5_LineNumberReader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("E:\\file.txt");
        LineNumberReader lnr = new LineNumberReader(fr);

        //设置行号：
        lnr.setLineNumber(0);//设置行的起始序号，
        String len;
        while ((len = lnr.readLine()) != null) {
            System.out.println(lnr.getLineNumber() + ":" + len);
        }
    }
}
