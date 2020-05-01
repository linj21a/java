package sort_algorithm;

import javax.swing.*;

public class StraightInsertionSort {
    //从右边第二个数字开始，在与前面的子序列进行比较，找到属于自己的位置进行插入
    public static void straghtInsertSort(int[] array) {
        //
        straghtInsertSort(array, true);//默认进行升序
    }

    public static void straghtInsertSort(int[] array, boolean flag) {
        if (flag) {
            for (int i = 1; i < array.length; i++) {//从第二个数开始
                int temp = array[i], j, k = 0, q = i - 1;
                for (j = q; j >= k && temp < array[j]; j--)//array[i]是要插入的数
                    //即从j到i-1这些数都需要往后面移动一位，空出的位置给array[i]插入，
                    array[j + 1] = array[j];//每比较一次我们就知道这个数需要往后面诺出一个位置了。
                array[j + 1] = temp;//注意这里要加1
                System.out.println("插入位置是" + i + ",插入的数字是" + temp);
            }
        } else {
            for (int i = 1; i < array.length; i++) {//从第二个数开始,默认第一个数是最小的
                int temp = array[i], start = 0, end = i - 1, mid = -1;
                for (; end >= start; )//array[i]是要插入的数
                {
                    mid = start + (end - start) / 2;
                    if (array[mid] < temp)
                        end = mid - 1;
                    else //元素相同时，我们也插入后面，肯能破坏稳定性
                        start = mid + 1;
                }
                //移动元素
                for (int len = i - 1; len >= start; len--) {
                    array[len + 1] = array[len];
                }
                array[start] = temp;
                System.out.println("插入位置是" + start + ",插入的数字是" + temp);

            }

        }
    }

    public static void main(String[] args) {
        int[] array1 = {12, 121, 5, 45, 4, 4, 74, 978, 979, 7, 4, 6, 64, 6, 4554, 979, 44, 55, 1, 215, 46, 22};
        int[] array2 = {12, 121, 5, 45, 4, 4, 74, 978, 979, 7, 4, 6, 64, 6, 4554, 979, 44, 55, 1, 215, 46, 22};
        long t1 = System.currentTimeMillis();

        straghtInsertSort(array1);//优化
        System.out.println((System.currentTimeMillis() - t1) + "ms");

        System.out.println("\n排序以后的数组：");
        for (int a : array1) {
            System.out.print(a + " ");
        }
    }
}
