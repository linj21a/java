package RegexLearning;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 正则练习2：对IP地址排序
 * 如164.4.5.2;
 * 164.3.6.7;
 * 164.7.88.7;
 * <p>
 * //数字越小越靠前。
 * 做法2：
 *
 */
public class Test1_SortIPAddress2 {
    public static void main(String[]args){
        String IPs = "196.255.100.6 196.255.100.2 196.255.88.7 127.0.0.1 3.3.3.3";

        //第一步，因为字符串的排序是按照字典顺序来排序的，则我们可以使用补0的操作
        //如127和3比较：127——003比较即可。
        IPs = IPs.replaceAll("(\\d+)","00$1");
        /*
00196.00255.00100.006
00196.00255.00100.002
00196.00255.0088.007
00127.000.000.001
003.003.003.003
         */
        //第三步，将位数统一为3位：
        IPs = IPs.replaceAll("0+(\\d{3})","$1");

        //第二步，先去除空格提取IP地址
        String[] strIps = IPs.split(" +");
        for(String s:strIps){
            System.out.println(s);
        }
        /*
196.255.100.006
196.255.100.002
196.255.088.007
127.000.000.001
003.003.003.003
         */
        //使用容器进行排序
        TreeSet<String> myset = new TreeSet<>(Arrays.asList(strIps));

        for(String s:myset){
            System.out.println(s.replaceAll("\\b0+(\\d+)\\b","$1"));
        }
        /*
3.3.3.3
127.0.0.1
196.255.88.7
196.255.10.2
196.255.10.6——不加边界判断的时候，："0+(\\d+)"
         */

        //现在改为："\\b0+(\\d+)\\b"
        /*
3.3.3.3
127.0.0.1
196.255.88.7
196.255.100.2
196.255.100.6
         */


    }


}
