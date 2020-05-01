package 面试题;

/**
 * 练习子类的创建过程
 * super的隐式
 */
class fu {
    private int num = 2;

    public fu() {//第二步来到这里
        System.out.println("fu run!");
        show();//调用show，因为现在fu son = new zi();//，多态，成员函数编译看左边，运行看是否有重写，
    }

    public void show() {
        System.out.println("我是老爸");
    }
}

class zi extends fu {
    static {
        //静态代码块
        System.out.println("我是静态代码块,类的字节码文件只要一加载，我就会运行！因为类的字节码文件只加载一次，我就只能运行一次！");
    }

    private int num = 9;

    {
        //构造代码块
        System.out.println("构造代码块运行(\"只要有对象的创建，我就会执行！\"),打印num" + num + "，num的值是显式初始化的！");
    }

    public zi() {//第一步public zi();
        //第二步，隐式调用super（）——public fu（）
        //第四步，显示初始化，现在num=9;
        //第五步构造代码块运行
        num = 12;
        System.out.println("fu run" + num + "，num的值现在我重新赋值了。");

    }

    public void show() {//第三步show（），发现num是0，说明在加载类的信息进栈的时候，在堆里边开辟对象时，进行了默认初始化
        System.out.println("我是儿子" + num + "，num的值是默认初始化的！");
    }
}

public class SuperandThis {
    public static void main(String[] args) {
        fu son = new zi();

    }
}
