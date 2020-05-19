package collectionandmap;

import java.util.*;

/**
 * 集合里边的工具类——Collections和Arrays两个类
 * 抽取了集合里边的
 * 场景联想：假设我们需要一个容器来存储我们的重复元素，同时又要排序。只能使用list存储，但无法保证排序
 * 所以需要一个工具来实现辅助排序。——Collections。sort方法。
 * Collection.sort——List.sort
 */

public class CollectionsDemo {
    public static void main(String[]args){
        List<String> list = new ArrayList<>();
        String[]s = {"jsflsj","aaa","aaaa","aa","ccc","ddd","zzzzdf"};
        Collections.addAll(list, s);
        System.out.println("未排序的列表：\t"+list);
        //开始使用工具类辅助排序
        Collections.sort(list);
        System.out.println("Collection.sort排序：\t"+list);
        mySort(list);
        System.out.println("mySort排序：\t"+list);

        System.out.println("######下面演示带比较器的比较方法########");
        //形式一：
        /*
         Collections.sort(list,new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                return s1.compareTo(s2);
            }
        });//使用匿名内部类的方法来创建比较器子类对象。
         */
        //形式二：lambda方法 Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
        //形式三：方法简写
        Collections.sort(list, String::compareTo);//使用匿名内部类的方法来创建比较器子类对象。
        System.out.println("Collections比较器排序：\t"+list);

        mySortComparator(list, String::compareTo);//注意String没有实现comparator接口。只实现了comparable接口。
        /*
        public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {
         */
        System.out.println("myComparatorSort排序：\t"+list);


    }

    private static <T /* Comparator<? super T>*/>/*因为比较器或者comparable接口一般都是抽取父类共有属性进行比较，故这里使用了泛型的下界*/
    void mySortComparator(List<T> list,Comparator<? super T> cmp) {
        //冒泡排序_使用泛型限制，加强健壮性
        for(int i=0;i<list.size()-1;i++){
            for(int j=i+1;j<list.size();j++){
                if(cmp.compare(list.get(i),list.get(j))>0){//因为String实现看comparable接口，能够比较了。
                    //交换
                    T temp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }
    }

    private static <T extends Comparable<? super T>>/*因为比较器或者comparable接口一般都是抽取父类共有属性进行比较，故这里使用了泛型的下界*/
    void mySort(List<T> list) {
        //冒泡排序_使用泛型限制，加强健壮性
        for(int i=0;i<list.size()-1;i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i).compareTo(list.get(j))>0){//因为String实现看comparable接口，能够比较了。
                    //交换
                    T temp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }
    }
}
