package Polymorphism;

public class Cat extends Animal {
    private String hobby;

    public Cat(String name, int age, String hobby) {
        super(name, age);
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }

    public void sayHello() {
        System.out.println("Cat say:我的爱好是" + this.hobby);
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
