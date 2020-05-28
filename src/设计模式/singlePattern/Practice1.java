package 设计模式.singlePattern;

/**
 * 设计模式：对问题行之有效的解决方法，其实是一种思想。
 * <p>
 * 1.单例设计模式：
 * 解决问题：保证一个类在内存里的对象唯一性
 * 必须对多个程序使用同一个配置信息时，就要保证该对象的唯一性，如果使用全是静态成员的类，生命周期太长。
 * <p>
 * 如和保证对象的唯一性呢？
 * 1、不允许其他程序使用new来创建对象。
 * 2、在该类内创建一个本类实例对象
 * 3、对外提供一个方法可以让其他程序获取该对象
 * <p>
 * getInstance（）
 */

public class Practice1 {
    private String name = "猪猪";
    private static Practice1 test1 = new Practice1();//创建一个本类实例，且static，饿汉式

    private Practice1() {
    }//构造方法私有化

    public static Practice1 getInstance() {//创建能返回的实例，static实现大家使用同一个对象
        return test1;
    }//而且可以在该函数上面添加泛型限制。

    public void say() {
        System.out.println("hello,这是单例设计模式的格式标准喔！");
        System.out.println("我叫" + name);
    }

    public void setName(String str) {
        this.name = str;

    }

    public static void main(String[] args) {
        Practice1 test = Practice1.test1;//本类main可以调用该private对象，但是假设我们封装，别人就只能通过getInstance
        Practice1 test2 = new Practice1();
        test.say();
        test2.say();

    }


}
