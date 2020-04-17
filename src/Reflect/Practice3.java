package Reflect;

import java.lang.reflect.Constructor;

/**
 * 通过反射获取构造方法
 * 为了能够动态获取对象构造方法的信息，首先需要通过下列方法之一创建一个 Constructor 类型的对象或者数组。
 * getConstructors()
 * getConstructor(Class<?>…parameterTypes)
 * getDeclaredConstructors()
 * getDeclaredConstructor(Class<?>...parameterTypes)
 *
 * 如果是访问指定的构造方法，需要根据该构造方法的入口参数的类型来访问。
 */
class Book{
    String name;
    int id,price;

    //构造方法,私有则我们无法调用
    private Book(){};
    //有参非私有
    protected Book(String name,int id){
        this.name = name;
        this.id = id;
    }
    //可变参数,并且声明可能抛出的异常
    public Book(String... strings)throws NumberFormatException{
        if(0<=strings.length){
            id = Integer.valueOf(strings[0]);
        }
        else{
            price = Integer.valueOf(strings[1]);
        }

    }
    //输出图书的信息
    public void print(){
        System.out.println("name"+name+",id"+id+"，price"+price);
    }
}

public class Practice3 {
    public static void main(String[]args){
        //获取动态类Book
        Class book = Book.class;
        //获取构造方法,加s表示获取所有的构造方法，不加则需要指明类型
        Constructor[] declareContructors = book.getDeclaredConstructors();

        //遍历所有的构造
        for(int i=0;i<declareContructors.length;i++) {
            Constructor con = declareContructors[i];
            //判断构造方法的参数是否可变
            System.out.println("查看是否允许带可变数量的参数：" + con.isVarArgs());
            System.out.println("该构造方法的入口参数依次为：");
            //获取所有的参数类型
            Class[] parameterTypes = con.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.println("" + parameterTypes[j]);
            }
            System.out.println("该构造方法可能抛出的异常类型为：");
            Class[] exceptionTypes = con.getExceptionTypes();
            for (int j = 0; j < exceptionTypes.length; j++) {
                System.out.println(" " + parameterTypes[j]);
            }
            //创建一个未实例的Boo类的实例
            Book book1 = null;
            while (book1 == null) {
                try {//如果该成员的访问权限为private，则抛出异常
                    if (i == 1) {
                        //通过执行两个带参数的构造方法实例化book
                        book1 = (Book) con.newInstance("Jva教程", 10);
                    } else if (i == 2) {
                        book1 = (Book) con.newInstance();
                    } else{
                        Object[] parameters = new Object[]{new String[]{"100", "200"}};
                    book1 = (Book) con.newInstance(parameters);
                }
            }catch(Exception e){
                System.out.println("创建对象时抛出异常，下面执行setAccessible方法");
                con.setAccessible(true);//设置允许访问私有成员
            }
        }
        book1.print();
        System.out.println("=============================\n");

        }
    }

}
