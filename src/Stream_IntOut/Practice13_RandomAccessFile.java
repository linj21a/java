package Stream_IntOut;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile
 *第一：它不是IO四大体系里边的类（InputStream，OutputStream、Reader、Writer）
 * 第二：public class RandomAccessFile extends Object
 * 第三：它这个对象既能读又能写，位于Java.io包里边。
 * 所以说明它内部封装了输入输出流对象。
 *
 * 第四：该对象内部维护了一个大型byte数组，可以通过指针访问数组内容。
 * 所以支持文件指针。
 *
 * 4.1设置文件指针：seek(int).为了发生数组截断现象，一般该指针的设置有限制。
 * 4.2获取文件指针：getFilePointer()
 *
 * 第五：该对象的目的和源只能是文件
 * 因为其构造器只有两个：
 * RandomAccessFile​(File file, String mode) 创建随机访问文件流，以便从File参数指定的文件中读取，也可以选择写入。
 * RandomAccessFile​(String name, String mode) 创建随机访问文件流，以便从具有指定名称的文件进行读取，并可选择写入该文件。
 *
 * mode的支持格式："r","rw","rws","rwd"
 *
 * public class RandomAccessFile
 * extends Object
 * implements DataOutput, DataInput, Closeable此类的实例支持读取和写入随机访问文件。
 * 随机访问文件的行为类似于存储在文件系统中的大量字节。
 * 有一种游标或索引到隐含数组中，称为文件指针 ;
 * 输入操作从文件指针开始读取字节，并使文件指针超过读取的字节数。
 * 如果在读/写模式下创建随机访问文件，则输出操作也可用; 输出操作从文件指针开始写入字节，并使文件指针超过写入的字节。
 * 写入隐含数组当前末尾的输出操作会导致数组被扩展。
 * 文件指针可以通过读取getFilePointer方法和由设置seek方法。
 * 通常，对于此类中的所有读取例程，如果在读取了所需的字节数之前达到文件结尾，则抛出EOFException （这是一种IOException ）。
 * 如果由于文件结尾之外的任何原因无法读取任何字节，则抛出IOException以外的EOFException 。
 * 特别是，如果流已经关闭， IOException可能抛出IOException 。
 *
 * 从以下版本开始：
 * 1.0
 */

public class Practice13_RandomAccessFile {
    public static void main(String[]args) throws IOException {
        writeReadDemo();
    }

    public static void writeReadDemo() throws IOException {
        RandomAccessFile rda = new RandomAccessFile(new File("E:\\randomAccess.txt"),"rw");
        rda.write("abc".getBytes());
        rda.write(97);//注意这个方法与printStream的一样，只写整数的低8位。

        //要写一个int类型需要4个字节。
        rda.writeInt(609);//这个能全都写进行，从高位开始写。
        /*
        此时用记事本打开：abca  a
       abc3个字节
       97是一个整数但是只写入了一个字节
       609是一个整数，使用了writeInt写入了4个字节。
         */
        //下面我们可以去读以下；必须按字节规律去读，否则发生数组截断乱码。
        rda.seek(0);//注意写的过程里边文件指针已经移动了。我们需要重设置指针。
        // 这里我们虽然随机设置，但是读取需要按照字节的规律。否则容易乱码。
        byte[]b = new byte[3];
        rda.read(b);
        System.out.println(new String(b));
        b = new byte[1];
        rda.read(b);
        System.out.println(new String(b));
        int k;
        k = rda.readInt();
        System.out.println(k);
        System.out.print("读取完毕。");
        rda.close();//关闭打开的流。
    }
}
/*
特有方法：

第一：写方法
1、写基本类型
void writeBoolean​(boolean v) 将 boolean写入文件作为单字节值。
void writeDouble​(double v) 双参数传递给转换 long使用 doubleToLongBits方法在类 Double ，然后写入该 long值到该文件作为一个八字节的数量，高字节。
void writeFloat​(float v) 浮子参数的转换 int使用 floatToIntBits方法在类 Float ，然后写入该 int值到该文件作为一个四字节数量，高字节。
void writeInt​(int v) 将 int写入文件为四个字节，高字节优先。
void writeLong​(long v) 将 long写入文件为8个字节，高字节优先。
void writeShort​(int v) 将 short写入文件为两个字节，高字节优先。
2、写字符串
void writeChars​(String s) 将字符串作为字符序列写入文件。
void writeUTF​(String str) 使用 modified UTF-8编码以与机器无关的方式将字符串写入文件。
void writeBytes​(String s) 将字符串作为字节序列写入文件。
3、写指定的字节或者写指定的int转为byte
void write​(int b) 将指定的字节写入此文件。
void writeByte​(int v) 将 byte写入文件作为单字节值。
void writeChar​(int v) 将 char作为双字节值写入文件，高字节优先。

第二：对应的读方法
int skipBytes​(int n) 尝试跳过 n字节的输入，丢弃跳过的字节。
1、读基本类型（有符号和无符号）
boolean readBoolean() 从此文件中读取 boolean 。
byte readByte() 从该文件中读取带符号的8位值。
char readChar() 从此文件中读取字符。
double readDouble() 从此文件中读取 double 。
float readFloat() 从此文件中读取 float 。
int readInt() 从此文件中读取带符号的32位整数。
long readLong() 从此文件中读取带符号的64位整数。
short readShort() 从该文件中读取带符号的16位数字。
int readUnsignedByte() 从该文件中读取无符号的8位数。
int readUnsignedShort() 从此文件中读取无符号的16位数字。
2、读指定字节长度
void readFully​(byte[] b) 从当前文件指针开始，将此文件中的 b.length字节读入字节数组。
void readFully​(byte[] b, int off, int len) 从当前文件指针开始，将此文件中的 len字节精确读入字节数组。
3、读字符串
String readLine() 从此文件中读取下一行文本。
String readUTF() 从此文件中读取字符串。


第三：返回关联对象
FileChannel getChannel() 返回与此文件关联的唯一FileChannel对象。
FileDescriptor getFD() 返回与此流关联的opaque文件描述符对象。



 */
