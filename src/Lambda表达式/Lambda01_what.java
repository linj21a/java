package Lambda表达式;

import java.util.Arrays;

/**
 * 函数式编程思想
 * 函数式编程（英语：functional programming）或称函数程序设计、泛函编程，是一种编程范式，它将电脑运算视为函数运算，并且避免使用程序状态以及易变对象。
 * 其中，λ演算（lambda calculus）为该语言最重要的基础。而且，λ演算的函数可以接受函数当作输入（引数）和输出（传出值）。
 *
 * 比起指令式编程，函数式编程更加强调程序执行的结果而非执行的过程，倡导利用若干简单的执行单元让计算结果不断渐进，逐层推导复杂的运算，
 * 而不是设计一个复杂的执行过程。
 *
 * 在函数式编程中，函数是第一类对象，意思是说一个函数，既可以作为其它函数的参数（输入值），
 * 也可以从函数中返回（输入值），被修改或者被分配给一个变量。
 *
 * 我们关注的是得到的结果而不是过程。
 *
 * 1、演示冗余的Runnable代码：
 *  new Thread(new Runnable() {
 * /            @Override
 *             public void run() {
 *                 System.out.println("我是使用匿名内部类实现的线程任务");
 *             }
 *         }).start();
 *
 *         而利用了runnable是函数式接口，我们在java8以后可以写作lambda表达式。简化书写。有时候还可以节省不必要的性能开销。
 *
 * 编程语言分为：
 * 纯函数式编程语言；
 * 非纯函数式编程语言；
 * 其他函数式编程语言。
 *
 *
 * 函数式编程的理论基础是Lambda演算，其本身是一种数学的抽象但不是编程语言。另一个组合逻辑是比它更加古老和基础的数学根基。
 * 两者都是为了更好的表达数学基础才被开发的。[7]
 */

public class Lambda01_what {
    public static void main(String[] args) {
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是使用匿名内部类实现的线程任务");
            }
        }).start();*/

        new Thread(()-> System.out.println("我是使用lambda表达式来创建的线程，参数必须是一个函数式接口。即只含有一个抽象方法。")).start();

    }







}
