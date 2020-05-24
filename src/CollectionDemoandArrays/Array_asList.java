package CollectionDemoandArrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static java.lang.System.*;

/**
 * Array工具类是用来操作数组的类，将一些方法抽取了，建立了与集合之间的联系
 * 注意事项：当数组的元素是对象的时候，转化的list.size=array.length();
 * 当数组元素是基本类型的时候，直接将数组整个作为list.size()
 *
 * 所以我们是不被允许去修改这个list的。
 *  报错——UnsupportedOperatorException
 *
 * 同时展示JDK5加入的新特性——可变参数（只能有一个，且必须放在参数列表最右，实际上就是将数组的创建封装在了底层）
 * 静态导入，for——each高级语法
 *
 */

public class Array_asList {
    public static void main(String[]args0){
        String[] s = {"aa","aaa","dl","adljl","ll"};
        List<String> l = Arrays.asList(s);//支持可变参数
        for(Iterator<String> it=l.listIterator();it.hasNext();){
            System.out.println(it.next());
        }
        //l.add("aldf");l.remove("dl");
        /*不允许修改，否则报错。不支持增加删除操作
        Exception in thread "main" java.lang.UnsupportedOperationException
	at java.base/java.util.AbstractList.add(AbstractList.java:153)
	at java.base/java.util.AbstractList.add(AbstractList.java:111)
	at CollectionDemoandArrays.Array_asList.main(Array_asList.java:28)

        */


        System.out.println("使用可变参数");
        l = Arrays.asList("a","bn","lsjjfldjl");

        //迭代器遍历
        for(Iterator<String> it=l.listIterator();it.hasNext();){
            //System.out.println(it.next());使用静态导入
            out.println(it.next());
        }
        //使用高级for——each专门用于遍历，简化书写，实际上利用了迭代，能够支持这个语法的都得实现
        // Interface Iterable<T>接口

            /*default void forEach(Consumer<? super T> action)
            执行特定动作的每一个元素的 Iterable直到所有元素都被处理或操作抛出异常。
            Iterator<T> iterator()
            返回类型 T元素的迭代器。  
            default Spliterator<T> spliterator()
            在这 Iterable创建描述元素的 Spliterator */
        for(String a:l){
            out.println(a);
        }
    }
}
