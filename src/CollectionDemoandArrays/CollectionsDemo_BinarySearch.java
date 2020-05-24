package CollectionDemoandArrays;

import java.util.*;

/**
 * 折半查找——binarySearch()对于的集合必须能排序，且要有角标，也就是list
 * 用于已经排好序的集合list
 */


public class CollectionsDemo_BinarySearch {
    public  static void main(String[]args){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("ab");
        list.add("ac");
        list.add("aaa");
        list.add("aba");
        list.add("aba");
        list.add("aba");
        list.add("aca");
        //先排序，存储的对象类型必须能够知道大小——实现comparable接口或comparator比较器
        Collections.sort(list);
        System.out.println("列表元素: "+list);
        //开始折半查找,
        int result = Collections.binarySearch(list,"aba");
        System.out.println("aba"+"角标位置: "+result);

        //查找最大值最小值max，min方法；
        System.out.println("max:"+Collections.max(list));
        System.out.println("min:"+Collections.min(list));
        //将已有的比较器逆转
        //Collections.reverseOrder(Comparator<String>);

        //逆序输出列表
        Collections.reverse(list);
        System.out.println("逆序列表: "+list);

        //replaceAll方法——将list的这样的元素全部换为指定的元素——相当于多次进行set（indexof（“aba”），“qqqq");
        Collections.replaceAll(list,"aba","qqqq");
        System.out.println("replaceAll方法后列表: "+list);
        while(list.indexOf("qqqq")!=-1){
            list.set(list.indexOf("qqqq"),"aba");
        }
        System.out.println("set(indexof)换回列表: "+list);

        //随机打乱shuffle（）
        Collections.shuffle(list);
        System.out.println("随机打乱列表: "+list);
        Collections.shuffle(list,new Random(123));
        System.out.println("随机种子123打乱列表: "+list);

        //其他方法：fill(list<? ectends T>，T)填充，将集合所有的元素填充为指定元素
        Collections.fill(list,"fill");
        System.out.println("fill填充列表: "+list);

        //很重要的小方法——枚举转集合，集合转枚举
        Enumeration<String> a = Collections.enumeration(list);
        System.out.println("集合转枚举类型");
        while(a.hasMoreElements()){
            System.out.print(a.nextElement()+" ");
        }
        System.out.println();
        list = Collections.list(a);
        System.out.println("使用list转化枚举为集合: "+list);

    }
}
