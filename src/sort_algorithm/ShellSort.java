package sort_algorithm;

public class ShellSort {
    public static void shellSort(int[] array) {
        for (int delta = array.length / 2; delta > 0; delta = delta /= 2) {//控制增量的变化

            for (int i = delta; i < array.length; i++) {//遍历每个组
                int temp = array[i], j;
                //组内排序
                for (j = i - delta; j >= 0 && temp <= array[j]; j -= delta) {
                    array[j + delta] = array[j];
                }
                array[j + delta] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array1 = {12, 121, 5, 45, 4, 4, 74, 978, 979, 7, 4, 6, 64, 6, 4554, 979, 44, 55, 1, 215, 46, 22, 6464, 7977, 797, 797, 79, 9, 11};
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++)

            shellSort(array1);
        System.out.println((System.currentTimeMillis() - t1) + "ms");

        System.out.println("\n排序以后的数组：");
        for (int a : array1) {
            System.out.print(a + " ");
        }
    }
}
