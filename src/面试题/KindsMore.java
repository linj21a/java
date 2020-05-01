package 面试题;

class Animal {
    void eat() {
        System.out.println("动物在吃饭");
    }

    void name() {
        System.out.println("animal");
    }
}

class Dog extends Animal {
    @Override
    void eat() {
        System.out.println("狗吃骨头");
    }

    void catchCat() {
        System.out.println("我会抓猫");
    }
    //int name(){注意了，这里编译不通过，不允许有与父类返回值不桶的同名函数
    //     System.out.println("父类的是void name，子类是 int name");
    //     return 1;
    //}
}

class Cat extends Animal {
    @Override
    void eat() {
        System.out.println("猫吃鱼");
    }

    void catchMouse() {
        System.out.println("我会抓老鼠");
    }
}

public class KindsMore {
    public static void main(String[] args) {
        //1.多态，向上转型，安全，
        Animal an = new Cat();
        Animal an1 = new Dog();
        an1.eat();//Dog的eat
        // 现在an能都用的方法、变量都必须都在Animal里有的方法，变量，因为Cat继承了其方法，所以多态就是调用了子类所继承的方法
        an.eat();//Cat重写了eat，是否能使用决定于Animal是否有eat，至于执行效果是谁，优先决定于子类
        an.name();
        //an.catMouse();报错，这是Cat里的特有方法，Animal不能调用。

        //2、向下转型，这种类型是安全的向下转型
        Cat cat = (Cat) an;
        cat.eat();

        //Cat an1 = new Animal();//编译错误，不允许


        // Animal an2 = new Animal();
        // Cat cat1 = (Cat)an2;//这种类型是不安全的，根据内存的大小都知道便，就好像c++那样不知道如何填充。所以会报错，说不能转换
        // cat1.eat();
        System.out.println("展示多态的好处——提高程序的扩展性！");
        eat(new Cat());
        eat(new Dog());
        eat(new Animal());

    }

    public static void eat(Animal a) {
        a.eat();//多态的好处，提高延展性
        //2、不能使用子类的新特性，除非加向下转型，这个时候就需要Instanceof关键字了
        if (a instanceof Cat) {//只能用于引用类型
            Cat c = (Cat) a;
            c.catchMouse();
        } else if (a instanceof Dog) {
            Dog g = (Dog) a;
            g.catchCat();
        }
        System.out.println();
    }
}
