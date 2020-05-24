package CollectionDemoandArrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 集合转为数组，允许修改数组。
 * 使用集合框架里边的toArray方法，返回的类型是Object
 * 使用具体的类的toArray方法返回对应的集合元素类型
 */

public class CollectionsToArrayDemo {
    public static void main(String[]args){
        Collection<String> c = new ArrayList<String>();
        c.add("a");
        c.add("ab");
        c.add("abv");
        c.add("ag");


        String[]a = c.toArray(new String[5]);
        //需要指定长度，当元集合的数组长度小于该length，直接使用该数组，且多出的元素初始化为null
        //指定的长度小于元集合的长度，则使用原集合的元素size作为数组的长度。
        for(String b:a){
            System.out.println(b);
        }

        //可以修改数组的值
        a[4]="aljdl";
        System.out.println(a[4]);
        c.add("dl");


    }
}
