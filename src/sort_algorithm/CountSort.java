package sort_algorithm;

/**
 * 目的：练习计数排序
 */


public class CountSort {
    public static void countSort(int[] array) {
        countSort(array, true);//默认升序排序
    }

    public static void countSort(int[] array, boolean flag) {
        //找到最大最小值，建立基于这个长度（max-min+1）的一个数组容器来计数，我们可以建立一个下标与存储的数组的0值的映射
        int delta, min = array[0], max = array[0];

        //1.找最大最小值
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];//找最小值
            if (array[i] > max)
                max = array[i];//找最大值

        }
        //建立一个用于计数的数组，对应的下标映射实际数组的值
        delta = 0 + min;//映射关系就是计数的数组与实际的值相差delta
        int[] count_map = new int[max - min + 1];
        //count_map里的值都初始化为0；
        for (int a = 0; a < count_map.length; a++)
            count_map[a] = 0;


        //开始计数
        for (int i = 0; i < array.length; i++)
            //实现计数，array[i]-delta表示array[i]在count_map的数组下标映射，同一个下标则表示相同的数,该数大小为i+delta，++则实现计数
            count_map[array[i] - delta]++;
        //计算完数组以后，我们开始依次放回，默认升序
        int i = 0;//用来指示计数数组的下标是否需要移动，当对应的count_map[i]==0,i++
        if (flag) {
            for (int j = 0; j < array.length; ) {//填充，j用来控制array下标
                if (count_map[i] > 0) {
                    array[j] = i + delta;//放回一个数
                    j++;
                    count_map[i]--;//计数器减1；
                } else i++;//放完了，就进行放下一个不重复的数
            }

        } else {
            for (int j = array.length - 1; j >= 0; ) {
                if (count_map[i] > 0) {
                    array[j] = i + delta;//完成一次放回
                    count_map[i]--;//计数器减1；
                    j--;
                } else i++;
            }
        }

    }

    public static void main(String[] args) {
        int[] array1 = {12, 121, 5, 45, 4, 4, 74, 978, 979, 7, 4, 6, 64, 6, 4554, 979, 44, 55, 1, 215, 46, 22, 6464, 7977, 797, 797, 79, 9, 11};
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++)

            countSort(array1);
        //countSort(array1,false);
        System.out.println((System.currentTimeMillis() - t1) + "ms");

        System.out.println("\n排序以后的数组：");
        for (int a : array1) {
            System.out.print(a + " ");
        }
        System.out.println((-10) / 10 / 10);
    }
}
