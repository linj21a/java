package 匿名内部类;

public class Out {
    void show() {
        System.out.println("调用 Out 类的 show() 方法");
    }
}

class TestAnonymousInterClass {
    //在这个方法中构造一个匿名内部类
    private void show() {
        new Out()//内部类的使用
        {
            //获取匿名内部类的实例
            void show()//重写show
            {
                System.out.println("调用匿名类中的 show() 方法");
            }
        }.show();//调用内部类的方法，自己写的show
    }

    public static void main(String[] args) {
        TestAnonymousInterClass test = new TestAnonymousInterClass();
        test.show();
    }
}