package RegexLearning;

import java.util.HashMap;

/**
 * 正则练习2：对IP地址排序
 * 如164.4.5.2;
 * 164.3.6.7;
 * 164.7.88.7;
 * <p>
 * //数字越小越靠前。
 */

public class Test1_SortIPAddress {
    public static void main(String[] args) {
        String s1 = "196.255.100.6";
        String s2 = "196.255.100.2";
        String s3 = "196.255.88.7";
        String s4 = "127.0.0.1";
        String s5 ="3.3.3.3";

        String []strings = {s1,s2,s3,s4,s5};
        System.out.println("未排序之前：");
        for(String s:strings){
            System.out.print(s+" ");
        }
        for(int x=0;x<strings.length-1;x++){
            int res = compareIP(strings[x],strings[x+1]);
            //System.out.println(res);
            if (res>0){
                String temp = strings[x];
                strings[x]=strings[x+1];
                strings[x+1]=temp;
            }
        }
        System.out.println("\n排序以后：");
        for(String s:strings){
            System.out.print(s+" ");
        }
    }

    /**
     * 比较IP地址的前后，如果IP地址相同，则返回0
     * 若S1>S2,则返回正数
     * 反之返回负数
     * @param s1 要匹配的IP地址1
     * @param s2 要匹配的IP地址2
     * @return 返回值类型为in
     */
    public static int compareIP(String s1, String s2) {
        if (s1 == null || s2 == null)
            throw new RuntimeException("传入字符串为空！");
        if (s1.equals(s2))
            return 0;
        //1、先将其按照IP的4部分划分：
        String regex = "\\.";//直接使用split进行切割
        String[] s1s = s1.split(regex);
        /*for(String s:s1s){
            System.out.println(s);
        }*/
        String[] s2s = s2.split(regex);
        for (int x = 0; x < s1s.length; x++) {
            if (Integer.parseInt(s1s[x]) > Integer.parseInt(s2s[x]))
                return -1;
            else if (Integer.parseInt(s1s[x]) < Integer.parseInt(s2s[x])) {
                return 1;
            } //s1s比s2s对应的位置的元素小，则其排序较前s1s>s2s


        }
        return 0;//全都相等


    }
}
