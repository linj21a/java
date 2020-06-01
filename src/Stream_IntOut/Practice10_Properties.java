package Stream_IntOut;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

/**
 * public class Properties
 * extends Hashtable<Object,​Object>
 *     Map
 *          --HashTable
 *              --Properties(常与IO流配合使用，用于存储配置信息)
 *          --HashMap
 *          --TreeMap
 *特点：
 *     1、 Properties可以保存到流中或从流中加载。
 *     2、没有泛型，属性列表中的每个键及其对应的值都是一个字符串。
 * 注意事项：
 * 因为Properties继承自Hashtable ，所以put和putAll方法可以应用于Properties对象。
 * 强烈建议不要使用它们，因为它们允许调用者插入其键或值不是Strings 。
 * 应该使用setProperty方法。 如果在包含非String键或值的“受损” Properties对象上调用store或save方法，则调用将失败。
 * 同样，如果在包含非String密钥的“受损” Properties对象上调用，则对propertyNames或list方法的调用将失败。
 *
 * 关于第二个特点——save（不安全），在其 方法store()和Load体现
 *
 * 1、获取指定键的值
 * String getProperty​(String key) 在此属性列表中搜索具有指定键的属性。
 * String getProperty​(String key, String defaultValue) 在此属性列表中搜索具有指定键的属性。
 * 2、设置指定键的值
 * Object setProperty​(String key, String value) 调用 Hashtable方法 put 。  
 * 3、配置文件加载到流中
 * void load​(InputStream inStream) 从输入字节流中读取属性列表（键和元素对）。
 * void load​(Reader reader) 以简单的面向行的格式从输入字符流中读取属性列表（键和元素对）。
 * void loadFromXML​(InputStream in) 将指定输入流上的XML文档表示的所有属性加载到此属性表中。
 *
 * list(PrintStream out);//将配置信息打印到指定的流。
 *
 * 4、配置文件从流中保存到硬盘（配置信息持久化。）
 * void save​(OutputStream out, String comments) 已过时。
 * 如果在保存属性列表时发生I / O错误，则此方法不会抛出IOException。
 * Object setProperty​(String key, String value) 调用 Hashtable方法 put 。
 * void store​(OutputStream out, String comments) 将此 Properties表中的此属性列表（键和元素对）以适合使用 load(InputStream)方法加载到 Properties表的格式写入输出流。
 * void store​(Writer writer, String comments) 将此 Properties表中的此属性列表（键和元素对）以适合使用 load(Reader)方法的格式写入输出字符流。
 * void storeToXML​(OutputStream os, String comment) 发出表示此表中包含的所有属性的XML文档。
 *
 */
public class Practice10_Properties{
    public static void main(String[]args) throws IOException {
        getAndSetDemo();
        loadDemo();
        storeDemo();
        list1Demo();
        
    }

    private static void list1Demo() {
        System.getProperties().list(System.out);//将系统的配置信息打印到控制台// ;
    }

    private static void storeDemo() throws IOException {
        //1、创建集合
        Properties myproperties = new Properties();
        myproperties.setProperty("zhansan","22");
        myproperties.setProperty("wusun","32");
        myproperties.setProperty("lishi","16");
        myproperties.setProperty("wenyiduo","55");

        Writer writer = new FileWriter("E:\\info");


        myproperties.store(writer,"name+你");//一个注意事项,这里别写中文
        /*info文件信息
         * #name+age
         * #Sun May 31 17:56:56 CST 2020
         * lishi=16
         * wusun=32
         * wenyiduo=55
         * zhansan=22
         */
        //写中文
        /*
#name+\u4F60（显示不了中文。）
#Sun May 31 18:03:32 CST 2020
lishi=16
wusun=32
wenyiduo=55
zhansan=22
         */


    }

    private static void loadDemo() {
        Properties myproperties = new Properties();
        myproperties.setProperty("zhansan","22");
        myproperties.setProperty("wusun","32");
        myproperties.setProperty("lishi","16");
        myproperties.setProperty("wenyiduo","55");

        myproperties.list(System.out);//加载到控制台，打印
    }

    private static void getAndSetDemo() {
        Properties myproperties = new Properties();
        myproperties.setProperty("zhansan","22");
        myproperties.setProperty("wusun","32");
        myproperties.setProperty("lishi","16");
        myproperties.setProperty("wenyiduo","55");

        System.out.println("lishi"+myproperties.get("lishi")+"岁");
    }
}
