package 面试题;

/**
 * 重写父类方法，权限注意要大于或者等于父类的方法
 * 注意静态方法的重写
 */
class A {
    private int num = 5;

    public int getNum() {
        return num;
    }

    private void show() {
        System.out.println("爸爸");
    }

    public static void say() {
        System.out.println("laoba");
    }

}

public class OverrideTest extends A {
    //@Override，这里无法加上重写注解，因为父类方法是私有的，编译器无法访问，所以无法知道父类是否有该方法
    public void show() {//没有实现覆盖父类的方法
        System.out.println("儿子");
    }

    public static void say() {//当把静态去掉，会报错，无法覆盖父类方法, 要么都是静态，要么都不是静态方法。
        System.out.println("son");
    }

    public static void main(String[] args) {
        A test = new OverrideTest();//一个对象两种形态，这就是多态
        test.say();//向上转型，调用当前指向的类型的方法，比如这里test指向的是OverrideTest，本来应该打印儿子，但是因为是静态方法，破坏了多态性
        OverrideTest son = (OverrideTest) test;
        son.say();//Son是OverrideTest类型，所以调用该类的say
        System.out.println(son.getNum());//私有成员变量一样会被继承,私有方法也是！
    }
}

