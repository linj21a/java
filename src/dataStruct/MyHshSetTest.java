package dataStruct;

/**
 * 测试自己手写的HashSet
 *
 */

public class MyHshSetTest {
    public static void main(String[]args){
        MyHashSet<Integer> myHashSet= new MyHashSet(5);
        myHashSet.add(1);
        myHashSet.add(21);
        myHashSet.add(31);
        myHashSet.add(41);
        myHashSet.add(5);
        myHashSet.add(55);
        myHashSet.add(6);
        myHashSet.add(5555);
        //myHashSet.add(55555);
        System.out.println("元素的个数："+myHashSet.size());
        myHashSet.show();
        Integer a = myHashSet.remove(6);
        System.out.println("删除了"+a.intValue());
        System.out.println("元素的个数："+myHashSet.size());
        myHashSet.show();
        //System.out.println(myHashSet.get(5));

        MyHashSet<String> ms = new MyHashSet<>(5);
        ms.add("abc");
        ms.add("abcd");
        ms.add("bca");
        ms.add("dbca");
        System.out.println("abc".hashCode()+" "+"bca".hashCode());
        ms.show();


    }
}
