package sort_algorithm;

/**
 * RadixSort：基数排序，先依据各个位数来进桶，然后拷贝回数组，
 * 接着到十位，百位。。。。
 */

public class RadixSort {
    public static void radixSort(int[]array){
        int n=1;//表示从个位开始
        int max=array[0];//最大的数默认a【0】
        int [][]baske=new int[10][array.length];//因为位数只能是0~9，所以我们建立了10个桶，每个桶最多容纳array.length个数
        //我们又是用二维数组表示桶，则一样需要一个数组来记录该桶里面存了多少个数
        int []len_bask = new int[array.length];
        for(int i=0;i<array.length;i++){
            len_bask[i]=0;//初始化为0
            if(max<array[i])
                max = array[i];
        }
        int k=0;//用来控制array数组赋值下标
        //找到该数组里最大是数有几位
        while(max!=0){
            for (int value : array) {
                //取最低位的数值出来
                int lsd = (value / n) % 10;
                baske[lsd][len_bask[lsd]] = value;//位数相同的进同一个桶，
                len_bask[lsd]++; // 同时桶内数的个数加1
            }
            //现在将桶内的数取出来合并

            for(int i=0;i<10;i++){//外围控制桶的下标
                if(len_bask[i]!=0)//桶不空
                {
                    for(int j=0;j<len_bask[i];j++){//控制桶内
                        array[k]=baske[i][j];
                        k++;
                }
                 len_bask[i]=0;//遍历完该桶内的数，桶内的数就没有了。
                }
            }
            //继续进行下一个位
            k=0;
            n *=10;
            max/=10;//，同时我们让最大值位数降1，假设刚才是max=9，我们就只需要比较一个位数了。

        }
    }
    public static void main(String[]args){
        int []array1 = {12,121,5,45,4,4,74,978,979,7,4,6,64,6,4554,979,44,55,1,215,46,22,6464,7977,797,797,79,9,11};
        long  t1 = System.currentTimeMillis();
        radixSort(array1);
        System.out.println((System.currentTimeMillis()-t1)+"ms");

        System.out.print("排序以后的数组：");
        for(int a:array1){
            System.out.print(a+" ");
        }
    }
}
