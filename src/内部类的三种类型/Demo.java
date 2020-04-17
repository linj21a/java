package 内部类的三种类型;

public class Demo {//外部类的属性只有public与默认属性
    public class Demo_Demo{//不使用static的就是实例内部类，有的地方也称为非静态内部类
        public void printInfo(){//内部类则三种属性，private，public，protected
            System.out.print("我是内部类，你儿子！");
        }
    }
    public void printInfo(){
        System.out.print("我是外部类 ，你爸爸！");
    }
    public static void main(String[]args){

        //创建外部类对应的对象
        Demo de = new Demo();

        //创建内部类的对象,两个new
        Demo.Demo_Demo de_de = new Demo().new Demo_Demo();
        de_de.printInfo();
        de.printInfo();
    }



}
