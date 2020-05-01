package Polymorphism;

public class Dog extends Animal {
    private String hobby;

    Dog(String name, int age, String hobby) {
        super(name, age);
        this.hobby = hobby;
    }

    public void sayHello() {
        System.out.println("Dog say:我的爱好是" + this.hobby);
    }

    public void yeild() {
        System.out.println("旺");
    }
}
