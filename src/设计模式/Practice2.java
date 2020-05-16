package 设计模式;

public class Practice2 {
    private String name = "猪猪";
    private static Practice2 test1 = null;//创建一个本类实例，且static

    private Practice2() {
    }//构造方法私有化

    public static Practice2 getInstance() {//创建能返回的实例，static实现大家使用同一个对象
        if(test1==null){
            test1 = new Practice2();
        }
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
        Practice2 test = Practice2.test1;//本类main可以调用该private对象，但是假设我们封装，别人就只能通过getInstance
        Practice2 test2 = new Practice2();
        if(test!=null)
            test.say();
        test2.say();

    }


}
