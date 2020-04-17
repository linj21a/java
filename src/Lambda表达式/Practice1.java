package Lambda表达式;

public class Practice1  {//我们是通过匿名内部类来实现接口

    public  Caculation caculation(char op) {
        Caculation result;
        if (op == '+') {
            //使用匿名内部类来实现该接口,使用方法引用，引用Integer类的求和方法sum
            result = Integer::sum;

        } else{
            //发现编译器会提示可以使用lambda表达式取代
            result = (x, y) -> x - y;
        }

            return result;
    }
    public static void main(String[]args){
        //
        Practice1 pr = new Practice1();
        System.out.println(pr.caculation('+').caculationInt(3,4));

    }
}