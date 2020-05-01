package Polymorphism;

public class Cat extends Animal {
    private String hobby;

    Cat(String name, int age, String hobby) {
        super(name, age);
        this.hobby = hobby;
    }

    public void sayHello() {
        System.out.println("Cat say:我的爱好是" + this.hobby);
    }
}
