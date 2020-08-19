package Finding_Algorithm;

/**
 *  Fibonacci查找
 */

public class FibonacciSearch {
    public static void main(String[]args){
        int []a = {5,12,33,44,55,66,77,88,99,100,220,444};
        int value = 444;//要查找的数
        //进行fibonacci查找
        int position = fibonacciSearch(a,value);
        System.out.println("查找"+value+"的下标位置是"+position);
    }

    /**
     * 创建斐波那契数列
     * @return 斐波那契数列
     */
    private static int[] fibonacci(){
        int n = 30;//默认创建100项
        int []f = new int[n];
        f[0]=1;
        f[1]=1;
        for(int i=2;i<n;i++){
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }

    private static int fibonacciSearch(int []data,int value) {
        int []f = fibonacci();//获取斐波那契数列
        int low =0,mid=0;
        int len = data.length;
        int high = len-1;

        //1、寻找f(n)略大于数组长度
        int k=0;
        while(len>f[k]){
            k++;
        }
        //2、创建临时数组
        int []temp = new int[f[k]];
        for(int i=0;i<f[k];i++){
            if(i<len)
                temp[i]=data[i];
            else temp[i]=data[len-1];
        }
      /*  for(int i:temp){
            System.out.print(i+" ");
        }
        System.out.println();*/

        //3、开始查找
        while(low<=high){
            mid = low+f[k-1]-1;
            if(temp[mid]<value){//右半部分
                low = mid+1;
                k = k-2;//f(n)=f(n-1)+f(n-2);
            }else if(temp[mid]>value){//左半部分
                high = mid-1;
                k = k-1;
            }else{
                if(mid<=high)//查找到了
                    return mid;
                else
                    return high;//但是位于temp填充的部分，等于high
            }

        }
        return -1;//查找失败。
    }
}
