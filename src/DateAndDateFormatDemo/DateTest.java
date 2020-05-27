package DateAndDateFormatDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 给定两个日期 ，如何求其之间的相差的天数？
 */

public class DateTest {
    public static void main(String[]args) throws ParseException{
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个日期（格式为yyyy--MM--dd）:");
        String input1 = sc.nextLine();
       // sc.nextLine();
        System.out.println("请输入第二个日期（格式为yyyy--MM--dd）:");
        String input2 = sc.nextLine();
        
        countDays(input1,input2);
        
        
    }

    private static void countDays(String input1, String input2) throws ParseException {
        SimpleDateFormat myformat = new SimpleDateFormat("yyyy--MM--dd");
        Date date1 = myformat.parse(input1);
        Date date2 = myformat.parse(input2);
        System.out.println(input1+"与"+input2+"相差"
                +Math.abs(date1.getTime()-date2.getTime())/1000/60/60/24+"天");
    }


}
