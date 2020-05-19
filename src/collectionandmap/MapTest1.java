package collectionandmap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 给定一个字符串，统计里面的每个字母所出现的次数
 * 如String s = "AFKHFGHFKLSDAHFKHFGIOWEUFWEFO";
 * 使用map，利用了键不允许重复的特性，值value来存放对于的次数
 * 要有序——TreeMap
 * 无序（存入与取出一致）——HashMap
 *                      ——有序——LinkedHashMap
 *
 *
 *
 */

public class MapTest1 {
    public static void main(String[]args){
        String s = "all--A-LJL+Hiterative";
        CharNumCounts1(s);
        CharNumCounts2(s);
    }

    private static void CharNumCounts2(String s) {
        //将字符串转化为字符数组
        char[] ch = s.toCharArray();
        Map<Character,Integer> temp = new TreeMap<>();
        for(int i=0;i<s.length();i++){
            if(!(ch[i]>='a'&&ch[i]<='z'||ch[i]>='A'&&ch[i]<='Z'))
                continue;
            Integer value = temp.get(ch[i]);
           /* if(value==null){
                temp.put(ch[i],1);
            }//我们发现无论空不空都要执行put操作，只不过value不一样而已
            else{
                temp.put(ch[i],value+1);
            }*/
           int count =1;//因为ch[i]至少存一次，即至少value=1
           if(value!=null){
               count=value+1;//重复，就是在上次的value上+1；
           }
           //继而提升了一点点效率
            temp.put(ch[i],count);
        }
        System.out.println(temp.toString());
        //现在我们需要一个方法返回元素和次数构成的字符串——方法2
        MapToString(temp);

    }

    private static void MapToString(Map<Character, Integer> temp) {
        StringBuilder sb = new StringBuilder();
        Iterator<Character> it = temp.keySet().iterator();
        while(it.hasNext()){
            Character key = it.next();
            Integer value = temp.get(key);
            sb.append(key+"("+value+")");
        }
        System.out.println(sb);
        /*
         * 当存入的字符串里边含有其他字符，不是纯字母时，
         * 我们要统计次数怎么办？
         * String s = jalkdjf12-3fds-edhfsdhkd3409;
         * 加一个判断——是不是字符啊？是就存不是就下一个。
         */
    }

    private static void CharNumCounts1(String s) {
        TreeMap<String,Integer> temp = new TreeMap<>();
        for(int i=0,a=0;i<s.length();i++){
            String key = s.substring(i,i+1);
//            System.out.println(key);
            if(temp.get(key)==null){
                temp.put(key,1);
            }
            else{
                int count = temp.get(key);
                count++;
                temp.put(key,count);
            }
        }//出现的元素都加入键里边,同时统计次数

        Set<String> count = temp.keySet();
        for(Iterator<String> it = count.iterator();it.hasNext();){
            String key = it.next();
            System.out.println(key+"出现的次数为："+temp.get(key));
        }
    }
}
