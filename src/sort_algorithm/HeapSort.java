package sort_algorithm;

public class HeapSort {
    public static void heapSort(int[]array){
        //1.对传入的数组进行建立堆，这里默认建立最小堆
        heapSort(array,true);
    }
    public static void heapSort(int[]array,boolean minheap){
        for(int i=array.length/2-1;i>=0;i--){
            //创建最小最大堆,默认最小堆
            sift(array,i,array.length-1,minheap);

        }
        System.out.print("当前的神器堆数组： ");
        for(int arr:array){
            System.out.print(arr+" ");
        }
        System.out.println();
        //排序，使用直接选择排序
        for(int j=array.length-1;j>0;j--){
            //现在的数组第一个就是根结点，最小值所在，进行交换，把它放到最右边
            swap(array,0,j);

            //
            System.out.print("现在建立堆的数组长"+(j+1)+",最小的数为"+array[j]+"\n"+"----");
            //重新建立堆
            sift(array,0,j-1,minheap);//将剩下的j-1个数，把它们调整为堆, 实质上是自上而下，自左向右进行调整的
            System.out.print("调整后的神器堆数组： ");
            for(int arr:array){
                System.out.print(arr+" ");
            }
            System.out.println();

        }
    }
    //建立堆的方法

    /**
     * 私有方法，只允许被堆排序调用
     * @param array 要排序数组
     * @param parent 双亲结点
     * @param end 数组长度
     * @param minheap 是否建立最小堆
     */
    private  static void sift(int[]array,int parent,int end,boolean minheap){
        int child = 2*parent+1;//利用公式，创建child是parent的左孩子，+1则是右孩子
        int value = array[parent];//获取当前双亲结点值
        for(;child<end;child=child*2+1){//有效范围内进行构建

            //注意这里的child必须小于end，防止越界，建立最小堆，右孩子如果比左孩子小，我们就将现在的孩子换到右孩子
            //因为现在如果右孩子大于双亲，自然左孩子也大于双亲
            if(child<end&&(minheap?array[child]>array[child+1]:array[child]<array[child+1]))//比较左孩子与右孩子的大小
                child++;//右孩子如果比左孩子大，我们就将现在的孩子换到右孩子

            //判断是否符合最小堆的特性， 如果右孩子大于双亲，自然左孩子也大于双亲，符合
            if(minheap?value>array[child]:value<array[child]){
               // array[parent]=array[child];//右孩子没有大于双亲，我们将其值赋予其双亲
                swap(array,parent,child);
                parent = child;//然后我们更新双亲结点和孩子结点
            }
            //如果不是，说明已经符合我们的要求了。
            else
                break;

        }
    }
    public static void swap(int[]array,int i,int j){
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;

    }
    public static void main(String[]args){
        int[]array;
        array = new int[]{1,1,1,1,1,55,15,55,55,8};
        System.out.println("原数组为：");
        for(int arr:array){
            System.out.print(arr+" ");
        }
        System.out.println();
        HeapSort.heapSort(array);

    }


}
