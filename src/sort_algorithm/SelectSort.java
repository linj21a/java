package sort_algorithm;

public class SelectSort {
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min])
                    min = j;//每次我们从剩下的数里边找最小值
            }
            //然后交换
            if (i != min)//如果最小值是它自己我们就不用交换了。
                swap(array, i, min);
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
        int[] array = {45, 12, 65, 89, 66, 99, 32, 564, 78};
        for (int arr : array) {
            System.out.print(arr + " ");
        }
        System.out.println();
        SelectSort.selectSort(array);
        for (int arr : array) {
            System.out.print(arr + " ");
        }
    }
}
