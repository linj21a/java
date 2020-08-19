package Lambda表达式;

/**
 * 返回值的函数式接口一样可以用Lambda表达式。
 *
 * 关于格式的省略问题：
 * Lambda的表达式 ：可推到则可省略。
 * 即凡是通过上下文来推导得出的都可以省略。一般Lambda的表达式省略的可以有：数据类型，返回值，{},;
 *
 * 1、如果代码只有一行，则可以省略大括号{}，省略分号、省略返回值，要省略则这三个要一起省略
 * 2、如果参数列表有多个，则可以省略参数类型。
 * 3、如果参数只有一个，则可以将类型省略，()省略。
 * 4、如果没有参数，则（）不可省略。空着。
 *
 */

public class Lambda03_ReturnValue {
    public static void main(String[] args) {
        new Lambda03_ReturnValue().getSum(3,4,new Lambda03_Calculator(){

            @Override
            public int sum(int a, int b) {
                return a+b;
            }
        });

        new Lambda03_ReturnValue().getSum(3,4,(a,b)->a+b);
        //IDEA会提示简化，即方法引用。
        new Lambda03_ReturnValue().getSum(3,4, Integer::sum);

        //有函数值和参数类型只有一个时：
        new Lambda03_ReturnValue().getType(4,(int a)->a+4);
        new Lambda03_ReturnValue().getType(5,a->a+5);//类型省略，()省略，只有一语句，则return，；{}都省略。
        new Lambda03_ReturnValue().getType(5, new Lambda03_Test() {//原本的写法
            @Override
            public int getE(int a) {
                return a+7;
            }
        });

    }
    public void getSum(int a,int b,Lambda03_Calculator calculator){
        int result =  calculator.sum(a,b);
        System.out.println(result);
    }
    public void getType(int a,Lambda03_Test test){
       System.out.println(a+test.getE(a));
    }
}
