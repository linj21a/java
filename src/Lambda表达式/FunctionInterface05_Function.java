package Lambda表达式;

import java.util.function.Function;

public class FunctionInterface05_Function {
    public static int getInt(String s, Function<String,Integer>function){//将字符串变为整数
        return function.apply(s);
    }
    public static Object getInput(String s){
        return Function.identity().apply(s);
    }
    public static String getUppercase(String s,Function<String,String>function1,Function<String,String>function2){
        return function1.compose(function2).apply(s);//function2 先对输入的数据进行apply，得到的结果再作为function1的输入

    }
    public static String getString(String s,Function<String,Integer>function1,Function<Integer,String>function2){
        return function1.andThen(function2).apply(s);//function1先对输入apply，function2再将结果apply
        //等价于
        /*
        int i = function1.apply(s);
        return function2.apply(i);
         */
    }

    public static void main(String[] args) {
        //该为方法引用：
        System.out.println(getInt("1000", Integer::parseInt));

        /*System.out.println(getInt("1000",(t)->Integer.parseInt(t)));*/
        System.out.println("args = " +getInput("我能返回输入的参数") );
        System.out.println(getUppercase("    abcS   dddDD",(s)->s=s.trim()+"function1",(s)->s=s.toUpperCase()+"function2"));

        //将字符串转化为整数，将该整数加10，然后返回其字符串
        System.out.println(getString("100",(s)->Integer.parseInt(s)+10,(i)->Integer.toString(i)));
    }
}
