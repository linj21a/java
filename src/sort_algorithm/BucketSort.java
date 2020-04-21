package sort_algorithm;

public class BucketSort {
    public static void bucketSort(int[] array)//data为待排序数组
    {
        int n = array.length, max = array[0], min = array[0];
        int[][] bask = new int[10][n];//定义10个桶来放数据，桶的索引为0到9,每个桶的数量最多存放n个数，
        //找最大值最小值制定桶的饭量
        for (int i = 1; i < array.length; i++) {
            if (min > array[i])
                min = array[i];
            if (max < array[i])
                max = array[i];
        }
        int delta = (max - min ) / 10+1;//注意这里要加1，不然num会越界
       // System.out.println("MAX:"+max+" min:"+min+" Delta:"+delta);
       // System.out.println("存进数 桶号 该桶元素个数");
        int[] len_bask = new int[n];
        for (int i = 0; i < n; i++)//定义一个数组来记录对应的桶现在吃了多少个数
            len_bask[i] = 0;//初始化0，用于记数

        //开始将数放进桶里
        for (int i = 0; i < n; i++) {//遍历原数组
            int num = (array[i] - min) / delta;//每一个数对应的桶号
            // 放进对应桶号的对应位置
            bask[num][len_bask[num]] = array[i];
            //桶内数的个数加1
            len_bask[num]++;
            //System.out.println(array[i]+"\t"+num+"\t"+len_bask[num]);

        }

        //各个桶分别排序，这里使用插入排序
        for (int i = 0; i < 10; i++) {//遍历桶，进行排序
            //因为我们使用二维数组实现，当前每个桶存放的数值个数为len_bask[i]
            if(len_bask[i]!=0)//对非空的桶排序
                countSort(bask[i], len_bask[i]);
        }
        //合并桶喽
        int k=0;
        for(int i=0;i<10;i++){//遍历桶，进行合并
            if(len_bask[i]!=0)//桶不空
                for(int j=0;j<len_bask[i];j++){
                    array[k++]=bask[i][j];
            }
        }
    }


    public static void countSort(int[]array,int len){
        //找到最大最小值，建立基于这个长度（max-min+1）的一个数组容器来计数，我们可以建立一个下标与存储的数组的0值的映射
        int delta,min=array[0],max=array[0];

        //1.找最大最小值
        for(int i=1;i<len;i++){
            if(array[i]<min)
                min=array[i];//找最小值
            if(array[i]>max)
                max=array[i];//找最大值

        }
        //建立一个用于计数的数组，对应的下标映射实际数组的值
        delta = 0+min;//映射关系就是计数的数组与实际的值相差delta
        int []count_map = new int[max-min+1];
        //count_map里的值都初始化为0；
        for(int a=0;a<count_map.length;a++)
            count_map[a]=0;


        //开始计数
        for(int i=0;i<len;i++)
            //实现计数，array[i]-delta表示array[i]在count_map的数组下标映射，同一个下标则表示相同的数,该数大小为i+delta，++则实现计数
            count_map[array[i]-delta]++;
        //计算完数组以后，我们开始依次放回，默认升序
        int i=0;//用来指示计数数组的下标是否需要移动，当对应的count_map[i]==0,i++

        for(int j=0;j<len;){//填充，j用来控制array下标
            if(count_map[i]>0){
                array[j] =i+delta;//放回一个数
                j++;
                count_map[i]--;//计数器减1；
            }
            else i++;//放完了，就进行放下一个不重复的数
        }



    }
    public static void main(String[]args){
        int []array1 = {12,121,5,45,4,4,74,978,979,7,4,6,64,6,4554,979,44,55,1,215,46,22,6464,7977,797,797,79,9,11};
        long  t1 = System.currentTimeMillis();
        bucketSort(array1);
        System.out.println((System.currentTimeMillis()-t1)+"ms");

        System.out.print("排序以后的数组：");
        for(int a:array1){
            System.out.print(a+" ");
        }
    }
}
