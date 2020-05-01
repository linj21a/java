package sort_algorithm;

import java.lang.reflect.Array;

/**
 * 冒泡排序算法
 */

public class Bubble_Sort {
    /**
     * @param array 传入的数组
     * @param i     交换的数组下标
     * @param j     交换的数组下标
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    /**
     * @param array 传入数组，升序排序
     */
    public static void bubbleSort(int[] array) {
        bubbleSort(array, true);

    }

    /**
     * @param array    传入数组
     * @param exchange 选择升序还是降序，true表示升序
     */
    public static void bubbleSort(int[] array, boolean exchange) {//重载，exchange标志表示为升序排序还是降序排序
        boolean flag = true;//是否已经发生交换
        for (int i = 1; i < array.length && flag; i++)//控制次数，第几趟排序，只需要n-1趟
        {
            //如果没有交换我们直接可以进行下一趟了。
            //说明一下flag，array[array.length-i-1]本身就是最大值了，那这一轮我们就没必要进行冒泡了嘛，它都已经冒泡好了，所有我们直接下一轮
            flag = false;
            for (int j = 0; j < array.length - i; j++)//i表示进行的趟数，每一趟能排好一个数，只需要排剩下的array.length-i个数
                if (exchange ? array[j] > array[j + 1] : array[j] < array[j + 1])//控制升序还是降序
                {
                    swap(array, j, j + 1);
                    flag = true;
                }
            System.out.println("第" + i + "趟,冒泡上去的是" + array[array.length - i]);
            for (int arr : array) {
                System.out.print(arr + " ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        int[] array = {45, 12, 65, 89, 66, 99, 32, 564, 78};
        Bubble_Sort.bubbleSort(array);
    }
}


