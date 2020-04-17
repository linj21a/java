package 日期查询Demo;
import java.util.Date;
import java.util.Scanner;
//import 日期查询Demo.Exercise;如果是同级目录下可以不用导入
public class Test_Demo {
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            Date date = new Date();
            String monday = Exercise.getMonday(date);
            System.out.print("这周一的日期为【"+monday+"】，");
            String nowStr = Exercise.DateToStr(date);       // 将 Date 类型的日期转换为 String 类型
            int num = Exercise.getTwoDay(nowStr,monday);
            System.out.print("与今天相差【"+num+"】天");

            System.out.println("\n请输入您要查询本周星期几的日期（1表示星期一，2表示星期二…7表示星期日)：");
            String weekNo = input.next();       //获取用户输入的星期
            int no = Integer.parseInt(weekNo);
            //将用户输入的星期转换为int类型，以便使用switch语句
            String strWeekNo = "";
            switch(no) {
                case 1:
                    strWeekNo = "星期一";
                    break;
                case 2:
                    strWeekNo = "星期二";
                    break;
                case 3:
                    strWeekNo = "星期三";
                    break;
                case 4:
                    strWeekNo = "星期四";
                    break;
                case 5:
                    strWeekNo = "星期五";
                    break;
                case 6:
                    strWeekNo = "星期六";
                    break;
                case 7:
                    strWeekNo = "星期日";
                    break;
            }
            System.out.println("本周【"+strWeekNo+"】的日期为："+Exercise.getWeek(nowStr,weekNo));
    }
}
