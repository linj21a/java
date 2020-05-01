package Polymorphism;

/**
 * 需求：测试多态的条件:
 * 1.满足继承关系
 * 2.使用向上转型
 * 3.方法重写
 */

public class test_1 {
    public static void main(String[] args) {
        //创建父类Animal
        Animal an = new Animal("祖宗", 223);


        //Animal
        an.sayHello();

        //cat
        an = new Cat("Tom", 6, "catch mouse");//向上转向，必须有继承关系
        an.sayHello();//方法重写

        //dog
        an = new Dog("Jimmy", 8, "catch cat");
        an.sayHello();
        Dog dog = (Dog) an;
        dog.sayHello();
        dog.yeild();
    }
}
