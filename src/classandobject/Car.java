package classandobject;

public class Car {
    public int num;
    public String name;

    public void run() {
        System.out.println(num + " " + name);
    }

    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = c1;
        c1.run();
        c2.run();
        c1.name = "猪猪";
        c2.run();
        System.out.println(c1 + " " + c2);//发现对应的哈希码一致，说明对象之间的赋值属于引用地址，大家都指向同一个地址。类似于向上转型。

    }
}
