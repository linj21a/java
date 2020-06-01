package Stream_IntOut;

import classandobject.Person;

import java.io.*;

/**
 * 场景：进行一次网上交易，突然服务器中断，我们必须时时刻刻将交易的相关类的信息保存。
 * 等服务器恢复，我们在重新加载该类，则能恢复之前的交易状态，维持数据不变。
 *
 * 也就是说我们需要能够对类、对象进行保存到硬盘等外设。使得对象持久化。
 * ——ObjectOutputStream
 *
 * public class ObjectOutputStream
 * extends OutputStream
 * implements ObjectOutput, ObjectStreamConstants
 * ObjectOutputStream将Java对象的基本数据类型和对象写入OutputStream。
 * 可以使用ObjectInputStream读取（重构）对象。
 * 可以通过使用流的文件来完成对象的持久存储。 如果流是网络套接字流，则可以在另一个主机或另一个进程中重新构建对象。
 *
 * 只有支持java.io.Serializable接口的对象才能写入流。 每个可序列化对象的类都被编码，包括类的类名和签名，对象的字段和数组的值，
 * 以及从初始对象引用的任何其他对象的闭包。 ——serializableVersionID
 *
 * writeObject方法用于将对象写入流。 任何对象，包括字符串和数组，都是用writeObject编写的。
 * 可以将多个对象或基元写入流中。
 * ！！！必须从相应的ObjectInputStream中读取对象，这些对象具有与写入时相同的类型和顺序。 （其—serializableVersionID相同才可以
 * 读取，否则会抛出异常：InvalidClassException
 *
 * 也可以使用DataOutput中的适当方法将基本数据类型写入流中。 也可以使用writeUTF方法编写字符串。
 *
 * 对象的默认序列化机制会写入对象的类，类签名以及所有非瞬态（不用transient标示的）和非静态字段的值。
 * 对其他对象的引用（瞬态或静态字段除外）也会导致这些对象被写入。 使用引用共享机制对对单个对象的多个引用进行编码，
 * 以便可以将对象的图形恢复为与写入原始图像时相同的形状。
 *
 * 例如，编写一个可以由ObjectInputStream中的示例读取的对象：
 *
 *
 *   FileOutputStream fos = new FileOutputStream("t.tmp");
 *       ObjectOutputStream oos = new ObjectOutputStream(fos);
 *
 *       oos.writeInt(12345);
 *       oos.writeObject("Today");
 *       oos.writeObject(new Date());
 *
 *       oos.close();
 *
 */

public class Practice12_ObjectOutputStream {
    public static void main(String[]args) throws IOException, ClassNotFoundException {
//        writeObjectDemo();
//        System.out.println("写入Person对象完毕！");
        readObjectDemo();
    }

    public static void readObjectDemo() throws IOException, ClassNotFoundException {
        //ObjectInputStream只能用来读取由ObjectOutputStream写入的对象。
        // 而且要存储对象的serialVersionUID与字节码文件的serialVersionUID相同才可反序列化。读取该对象。
        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("E:\\Object.txt"));
        Person p = (Person)ooi.readObject();//当对应的serialVersionUID不同，会报错，无法加载保存到硬盘的对象。

        /*
        报错信息
        Exception in thread "main" java.io.InvalidClassException: classandobject.Person;
        local class incompatible: stream classdesc serialVersionUID = 2564213078493790751,
        local class serialVersionUID = -4578207210445382436

        所以一般为了防止当存放了对象，而对类的一些属性修改了。进而导致的ID不一致
        通常使用显示声明ID,当然一般不要修改。
         */
        System.out.println(p.getName()+" :"+p.getAge());
        //接下来演示静态变量无法写入对象时存储到硬盘。
        //将age改为了静态。
        /*
        结果：lisi :0，明明我们存放的不该是lisi 22吗?说明静态变量根本没有存进去。
         */

        //接下来演示transient关键字
        //将age改为 private transient int age;
        /*
         * 结果lisi :0，明明我们存放的不该是lisi 22吗?说明非瞬态的变量根本没有存进去。
         * 所以transient就这个作用。
         * 而当我们有一些变量，我们不想写入对象时将其写入硬盘，但它又不是静态的时候，
         *         我们可以声明它为瞬时的——关键字transient
         */
        ooi.close();
    }

    public static void writeObjectDemo() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\Object.txt"));//一般以object后缀结尾，表示对象持久化文件。
        oos.writeObject(new Person("lisi",22));//当没有该对象没有实现Serializable接口，就会无法序列化。
        //报错Exception in thread "main" java.io.NotSerializableException: classandobject.Person
        oos.close();
        /*
        注意写入内容是：
        对象的类，类签名以及所有非瞬态（不用transient标示的）和非静态字段的值。
        对其他对象的引用（瞬态或静态字段除外）也会导致这些对象被写入。
        因为静态变量处于方法区的静态方法区，也就是堆中。

        而当我们有一些变量，我们不想写入对象时将其写入硬盘，但它又不是静态的时候，
        我们可以声明它为瞬时的——关键字transient
         */
    }
}
