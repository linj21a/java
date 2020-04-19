package java基础;

public class String_Test {
    public static void main(String[]args){
        String a1 = "123";//字面量赋值，由虚拟机创建对象存储在方法区的运行常量池
        String b1 = "123";//查找运行常量池是否有该内容，然后直接栈中创建b1指向该地址
        System.out.println("a1==b1?"+(a1==b1)+" a1="+a1+" b1="+b1);//所有a1地址等于b1

        //String是不可变字符串指的是值不能改变，但是我们使用字面量重赋值相当于修改地址
        a1 = "hello";
        b1 = "hello";
        System.out.println(a1==b1);//地址引用修改相同，都是指向常量池里边的hello

        //
        String a2 = new String("hello");
        System.out.println(a1==a2);//比较地址引用，有new就是在堆区开辟了内存，地址引用不同，false
        //修改一下a2，然后使得
        String b2 = a1+"hello";//只有有一个不是字面量，都会使用new，b2 = ”hellohello“，b2的值在堆区

        a1 = "hellohello";
        System.out.println(b2+" "+a1);
        System.out.println(a1==b2);//因为b2用了new，那么必然在堆区开辟内存，则地址引用必然不同，false

        String b3 = b2;//不是字面量，就用来new
        System.out.println(b3==b2);//地址引用就不同，都是在堆区，则==比较内容 true
        System.out.println(b3==a1);//比较地址引用，不同 false

        System.out.println("______________________________");




    }


    }
