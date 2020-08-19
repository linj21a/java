package Lambda表达式;



/**
 * Lambda表达式，用于函数式接口，当方法只有一个时则是函数式接口。
 * Lambda由三部分组成：
 * 1、(),表示参数，有参则在括号里写出来。没有参数则空着
 * 2、->,表示将括号的参数传递
 * 3、方法体，一些执行语句。
 * <p>
 * 利用Lambda表达式来简化使用匿名内部类来传递线程任务。
 *
 * 凡是可以通过上下文可以推到出来的参数，都可以省略。
 * 1、参数列表，多个参数，则参数的定义可以省略
 * 2、如果参数只有一个，则（）可以省略、参数的定义省略
 * 3、如果语句只有一条，则{}可以省略。无论返回值是否有，分号、返回值、{}都可以省略
 *
 * 注意：要省略{},return,;必须满足上面三条。
 */

public class LambdaDemoOfThread {
    public static void main(String[] args) {
        //原来的方式：
      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"创建线程");
            }
        }).start();*/

        //使用Lambda的方式简化
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "创建线程")).start();

        //当语句有多句时
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "创建线程");
            System.out.println("多条语句要用大括号括起来，函数的写法，一条语句可以省略大括号。");
        }).start();

        // new Thread(r->System.out.println(Thread.currentThread().getName()+"创建线程"));错误写法
       /* System.out.println(new Caculation() {
            @Override
            public int caculationInt(int x, int y) {
                return x+y;
            }
        });*/
      /*  System.out.println((Caculation) (x, y) -> x+y);*/
        System.out.println((Caculation) Integer::sum);

       // ArrayList<String> list = new ArrayList<>();//后面的泛型 可以省略。因为前面可以推到。

    }
}
