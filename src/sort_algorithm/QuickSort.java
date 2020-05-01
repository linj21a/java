package sort_algorithm;

/**
 * 目的：展示快速排序算法
 */

public class QuickSort {
    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(int[] array, int begin, int end) {

        if (begin >= 0 && end >= 0 && begin < end) {
            int i = begin, j = end;
            //以第一个为基准值
            int base = array[begin];
            while (i < j)//哨兵j先移动
            {
                if (array[j] < base)//每找到一个小于基准值的
                    for (; i < j; i++) {
                        if (array[i] > base) {//就找一次大于基准值的进行交换，交换一次就回去继续下一轮交换
                            swap(array, i, j);
                            break;
                        }
                        //找不到比基准大的也能实现i往右移动。
                    }
                if (i == j)//因为现在i不清楚是从哪里出来的我们需要判断是break出来还是i==j
                    break;
                j--;//否则我们继续找下一个小于基准值的数

            }
            if (begin != j)//同一个数则不用交换基准值
                swap(array, begin, j);//交换基准值，实现小于基准值的都在左边，大于基准值的都在右边

            //递归
            quickSort(array, 0, j - 1);//左半部分
            quickSort(array, j + 1, end);//右半部分

        }

    }

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

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 5, 5, 6, 6, 0, 0, 1, 2, 5, 55, 555, 7777};
        for (int arr : array) {
            System.out.print(arr + " ");
        }
        System.out.println();
        new QuickSort().quickSort(array);
        for (int arr : array) {
            System.out.print(arr + " ");
        }
    }

}
