package Polymorphism;

public class Animal {
    public String name;
    public int age;

    //构造方法
    Animal(String name, int age) {
        this.age = age;
        this.name = name;
    }

    //用于重写，多态的方法
    public void sayHello() {
        System.out.println("Animal say its age is " + this.age + " name is " + this.name);

    }
}
