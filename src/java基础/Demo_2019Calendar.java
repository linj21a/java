package java基础;

import java.util.Calendar;
import java.util.Scanner;

/**
 * 需求：根据用户输入的月份，查询2019年对应月份的日历
 */

public class Demo_2019Calendar {
    public static void main(String[] args) {
        //创建日历对象
        Calendar year_calendar = Calendar.getInstance();
        //设置为2019年1月1日
        year_calendar.set(2019, 0, 1);//实际的calendar对象所表示的日期为2019年1月1日

        //开始计算对应月份的日历

        //月份对应的天数
        int[] day_num = new int[3];
        day_num[0] = 28;
        day_num[1] = 30;
        day_num[2] = 31;
        System.out.println("请输入你想要查看的月份");
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        if (month < 1 || month > 12)//输入的月份不合格默认输出一月
            month = 1;
        int num = JudgeMonth(month, day_num);

        //设定星期几
        char[] title = {'日', '一', '二', '三', '四', '五', '六'};

        //定义二维数组，存储对应的日历
        int[][] dayArray = new int[6][7];//最多能排7行。
        //我们获取1号是星期几先
        int index = year_calendar.get(Calendar.DAY_OF_WEEK) - 1;
        //定义一个day记录打印的天数
        int day = 0;
        for (int i = index; i < 7; i++) {
            // 填充第一周的日期数据，即日历中的第一行
            dayArray[0][i] = ++day;
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (day > num) {
                    i = 6;//直接退出。
                    break;
                }
                dayArray[i][j] = day;
                day++;
            }
        }

        //开始打印日历
        System.out.println("------2019 年 " + month + " 月--------\n");
        //打印星期几
        for (int i = 0; i < 7; i++) {
            System.out.print(title[i] + "\t");
        }
        System.out.print("\n");

        // 输出二元数组daysArray中的元素
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (dayArray[i][j] == 0) {
                    if (i != 0) {
                        // 到月末，则完成显示日历的任务，停止该方法的执行
                        return;
                    }
                    System.out.print("\t");
                    continue;
                }
                System.out.print(dayArray[i][j] + "\t");
            }
            System.out.print("\n");


        }

    }

    //定义一个函数用于判断该月是几天
    public static int JudgeMonth(int month, int[] day_num) {
        //小于等于7月，奇月有31天
        if (month < 8) {
            if (month % 2 != 0)//奇数
                return day_num[2];
            else if (month != 2)//不是2月的偶数
                return day_num[1];
            else return day_num[0];
        } else {
            if (month % 2 == 0)
                return day_num[2];
            else
                return day_num[1];
        }
    }

}
