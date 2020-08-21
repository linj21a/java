package Stream流AndMethodFerence;

import java.util.Arrays;

/**
 * 什么是方法引用?因为一些方法是重复的，lambda表达式创建的接口里面所写的抽象方法再次写了同样的方法。
 * 我们这样做毫无疑问是低效率的。我们可不可以利用之前写过的代码呢》当然可以。
 * 那就是方法应用：格式：对象::其方法。
 * 使用前提：优化lambda表达式，即对应的参数是一个函数式接口。
 *
 * 方法引用有
 * 1、类.静态方法
 * 2、对象.成员方法
 * 3、this、super也是对象
 * 4、int[].new,this.new,person.new;引用其构造器
 */
public class MethodFerence01_What {
    public static void display(String mess,PrintText printText){
        printText.print(mess);
    }

    public static int[] getLength(int i,ArrayConstruct arrayConstruct) {
        return arrayConstruct.builderArray(i);

    }

    public static void main(String[] args) {
        /* display("方法引用",(m)->System.out.print(m));*/

        /*
         * 分析，打印方法存在过：System.out.println
         * 可以使用方法引用，对应的对象就是静态对象out，打印流
         */
        display("方法引用",System.out::println);//注意方法引用不需要参数。只需要引用名字就可。因为可推到。
     /*   int []a = getLength(10,(i)->new int[i]);
        System.out.println(Arrays.toString(a));*/
        /*
        分析，int[]存在构造器，代码重复，而且参数是一个lambda接口。则可以使用方法引用。
         */
        int[]b = getLength(10,int[]::new);
        System.out.println(Arrays.toString(b));
    }

}
