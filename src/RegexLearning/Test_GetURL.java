package RegexLearning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式练习4之网络爬虫
 * 选择一个URL地址，利用正则表达式爬取自己要的内容。
 * 比如现在爬取tomcat官网里边的网址
 *
 */

public class Test_GetURL {
    public static void main(String[]args) throws IOException {
        URL myUrl = new URL("http://tomcat.apache.org/index.html");
        BufferedReader br = new BufferedReader(new InputStreamReader(myUrl.openStream()));
        String myregex = "(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]";//最优秀的网址匹配
        Pattern p = Pattern.compile(myregex);
        String buff;
        while((buff=br.readLine())!=null){
            Matcher m = p.matcher(buff);
            while(m.find()){
                System.out.println(m.group());
            }


        }
        br.close();
    }
}
