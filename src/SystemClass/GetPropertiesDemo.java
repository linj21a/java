package SystemClass;

import java.util.Properties;
import java.util.Set;

/**public final class System——无法被继承
 * System是系统的类，因为构造器是私有的，无法被实例化，
 *  ——常见字段——
 *          static InputStream in “标准”输入流
 *          static PrintStream out “标准”输出流
 *          static PrintStream err “标准”错误输出流。
 *
 * ——常用方法
 * 1、currentTimeMillis()——返回当前时间以毫秒为单位。参照时间为1970年1月1日UTC。
 * 2、static void gc() ——运行垃圾收集器。
 * 3、static String getProperty(String key)——获取指定的键指示的系统属性。
 * 4、（重要）static Properties getProperties()——确定当前系统属性。返回的是Map集合，是同步的HashTable的Property
 * 5、static String setProperty(String key, String value)——设置指定的键指示的系统属性。
 * 6、static String clearProperty(String key)——移除指定的键所指示的系统属性。
 * 7、static Map<String,String> getenv()——返回当前系统环境的一个不可修改的字符串的Map视图。
 */

public class GetPropertiesDemo {
    public static String LINE_SEPARATOR = System.getProperty("line.separator");//System中就是这样封装的，
    //我们可以直接写：System.lineSeparator();来获取。
    /**
     * 展示getProperty方法获取系统的属性信息。
     */
    public static void main(String[]args){
       /* Properties pro = System.getProperties();
        //不同于其他的Map，因为与vector是同一时代的，那个时候还没有泛型。不带泛型，里面的键值对都是K-String，V-String
        Set<String> myst = pro.stringPropertyNames();//只有这个是直接返回字符类型的set
        for(String key:myst){
            String value = pro.getProperty(key);
            System.out.println(key+"::"+value);//会打印一堆系统属性信息，其中一个很重要的东西就是行分割符与文件分割符。
        }*/

        String s = System.getProperty("line.separator");
        //不同的系统行分割符不同，window：\r\n.而linux是\n;为了提高程序的跨平台性，我们需要获取系统的这些属性。
        System.out.println("hello"+s+"world");

        //我们也可以设置自己的属性，比如将自己的类文件路径添加进去
       // System.setProperty("myClassPath","D:\\java");
    }
}
