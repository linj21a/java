package Arraydata;

public class Notice_Demo {
    public static void main(String[] args) {
        int[] score;
        score = new int[2];
        score[0] = 1;
        score[1] = 2;
        System.out.println("形式1：" + score[0] + " " + score[1]);

        int[] score1 = new int[2];
        score1[0] = 1;
        score1[1] = 2;
        System.out.println("形式2：" + score1[0] + " " + score1[1]);

        int[] score2 = new int[]{1, 2};
        System.out.println("形式3：" + score2[0] + " " + score2[1]);

        int[] score3 = {1, 2};
        System.out.println("形式4：" + score3[0] + " " + score3[1]);


    }

}
