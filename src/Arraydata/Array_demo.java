package Arraydata;

import java.util.Scanner;

public class Array_demo {
    /**
     *  步骤分析:
     *             1.打印地图  ---- 二维数组的遍历
     *     初始坐标 array[1][1]
     *     结束坐标 array[1][9]
     *             2.如何让0走起来
     *     通过修改 横纵坐标 让'P'走起来
     *     如何碰到墙 '#' 不移动
     *     可以先把要走的位置元素 取出来判断一下 是不是墙
     *     是墙就不动 不是墙再进行移动
     *     3.循环输入(循环的停止条件 结束坐标位置 从' '变成'0')
     *     如果有明确的停止循环的条件 就使用while循环比较方便
     */
    public static void main(String[] args) {
        // 有8个一维数组 每个一维数组中有10个元素
        char[][] array = {
                //y   0   1   2   3   4   5   6   7   8   9
                    {'#','#','#','#','#','#','#','#','#','#'},//0 ----- x
                    {'#','P',' ',' ',' ',' ','#','#',' ',' '},//1
                    {'#','#',' ','#','#','#','#','#',' ','#'},//2
                    {'#',' ',' ',' ',' ','#','#','#',' ','#'},//3
                    {'#',' ','#','#',' ','#',' ',' ',' ','#'},//4
                    {'#',' ','#','#',' ','#',' ','#','#','#'},//5
                    {'#',' ',' ',' ',' ',' ',' ','#','#','#'},//6
                    {'#','#','#','#','#','#','#','#','#','#'},//7
        };
        // 打印地图
        printMap(array);
        // 声明要用的变量 起始
        int x = 1;
        int y = 1;
        // 结束
        int ex = 1;
        int ey = 9;
        Scanner scanner = new Scanner(System.in);
        // 提示输入 w a s d
        while (array[ex][ey] != 'P') {
            System.out.println("请输入w a s d进行移动");
            // 接收输入的值
            String string = scanner.nextLine();
            // 判断往哪里移动
            switch (string) {
                case "w": case "W":
                    if (array[x - 1][y] != '#') {
                        // 把原来的改空格
                        array[x][y] = ' ';
                        // 向左移动
                        x = x - 1;
                        array[x][y] = 'P';
                    }
                    break;
                case "a": case"A":
                    if (array[x][y - 1] != '#') {
                        // 把原来的改空格
                        array[x][y] = ' ';
                        // 向左移动
                        y = y  - 1;
                        array[x][y] = 'P';
                    }
                    break;
                case "s": case"S":
                    if (array[x + 1][y] != '#') {
                        // 把原来的改空格
                        array[x][y] = ' ';
                        // 向左移动
                        x = x + 1;
                        array[x][y] = 'P';
                    }
                    break;
                case "d": case"D":
                    // 判断是不是墙
                    if (array[x][y + 1] != '#') {
                        // 把原来的改空格
                        array[x][y] = ' ';
                        // 向左移动
                        y = y  + 1;
                        array[x][y] = 'P';
                    }
                    break;
                default:
                    break;
            }
            // 修改完毕后 再打印一遍地图
            printMap(array);
        }
        System.out.println("恭喜通关!");
    }

    // 打印地图的方法
    public static void printMap(char[][] array) {
        System.out.print(" ");
        for(int i=0;i<10;i++){
            System.out.print(i+"");
        }
        System.out.println();
        int j=0;
        for (char[] chars : array) {
            System.out.print(j+"");
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
            j++;
        }
    }
}
