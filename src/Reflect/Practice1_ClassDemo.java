package Reflect;

import classandobject.Person;

/**
 * 反射机制：一个程序在运行的时候可以动态获取类的各类信息：
 * 1、构造器Constructor；2、方法Method；3、成员变量Field。
 * 还能进行判断该类的功能等。
 *
 * 应用：应用程序通过对外提供接口，只要新加的类实现这个接口。并且其写入了该程序的配置文件里边。
 * 应用程序就能利用反射机制创建该类的实例，从而达到将程序的功能进行扩展。
 * Java 反射机制在服务器程序和中间件程序中得到了广泛运用。
 * 在服务器端，往往需要根据客户的请求，动态调用某一个对象的特定方法。
 * 此外，在 ORM 中间件的实现中，运用 Java 反射机制可以读取任意一个 JavaBean 的所有属性，或者给这些属性赋值。
 *
 * 如：Tomcat服务器，提供了处理请求和应答消息的不同应对方式的接口——servlet,只用开发者将希望的处理方式封装为类实现该接口
 * 则Tomcat服务器进行响应客户端的请求时，就能使用该处理的应答方式。使得可扩展性大大的提高。
 *
 * Java 反射机制的优缺点
 * 优点：
 * 能够运行时动态获取类的实例，大大提高系统的灵活性和扩展性。
 * 与 Java 动态编译相结合，可以实现无比强大的功能。
 * 对于 Java 这种先编译再运行的语言，能够让我们很方便的创建灵活的代码，这些代码可以在运行时装配，无需在组件之间进行源代码的链接，更加容易实现面向对象。
 *
 * 缺点：
 * 反射会消耗一定的系统资源，因此，如果不需要动态地创建一个对象，那么就不需要用反射；
 * 反射调用方法时可以忽略权限检查，获取这个类的私有方法和属性，因此可能会破坏类的封装性而导致安全问题。
 *
 * Java 反射机制在一般的 Java 应用开发中很少使用，即便是 Java EE 阶段也很少使用。
 * 反射机制的实现
 * Class类是反射机制实现的基础。然后将构造器、成员变量、方法、注解等封装为对象，放在Java.lang.reflect
 * 的反射包里边。——Constructor、Method、Field、Annotation、Interface等。
 *
 *
 *1、 Class类
 * public final class Class<T>
 * extends Object
 * implements Serializable, GenericDeclaration, Type, AnnotatedElement
 * 类的实例代表一个运行 类 java应用程序的类和接口。枚举是一种阶级和注释是一种接口。
 * 每个数组属于一种体现为 类对象是所有数组的元素类型和维数的共享类。
 * 原始的java类型（ boolean， byte， char， short， int， long， float，和 double），和关键词 void也表示为 类对象。
 * 类没有公共构造函数。相反，当类装入器调用defineClass方法并传递类文件的字节时，Java虚拟机将自动构造类对象。
 *
 * 构造器：
 * 没有构造器
 *
 * 常用方法：
 * 1、先学如何获取Class对象的方法
 * 三种：
 * Object的getClass方法
 * 一个对象实例所具备的字面量class
 * static Class<?>	forName​(String className)
 * 返回与给定字符串名称的类或接口关联的类对象。
 *
 */

public class Practice1_ClassDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        getClass1();
        getClass2();
        getClass3();

        /*System.out.println("s类名称：" + s.getName());
        System.out.println("s是否为接口：" + s.isInterface());//对比instanceOf
        System.out.println("s是否为数组对象：" + s.isArray());
        System.out.println("s父类名称：" + s.getSuperclass().getName());

        System.out.println("s是否为基本类型：" + s.isPrimitive());*/
    }

    /**
     * 第一种方法，获取对象的class字面量。
     * 类的名：Person、获取：Person.class
     * 局限性：写死了，无法动态修改需要的类。
     */

    private static void getClass1() {
        //Person p = new Person("小强",23);
        //使用通配符避免IDEA警告
        Class<?> clazz = Person.class;//这里是类的字面量，这是类的字节码文件，由java虚拟机创建。
        //这里的Class是具备泛型参数的。

        System.out.println("类名.class:"+clazz);

    }

    /**
     * 第二种：使用Object里边所抽取的方法getClass方法
     * 局限性：写死了无法动态修改所需要的类。
     */
    private static void getClass2() {
        Person p = new Person("Lisi",23);
        Class<?> clazz = p.getClass();//这是对象具有的方法
        System.out.println("getClass:"+clazz);
    }

    /**
     * 第三种方法最常用，使用Class.forName(String);
     * 将类连带包路径都写为字符串，然后传入forName（）；
     * 就能获取其字节码文件对象。
     * 如 String s = ".....Person"
     * Class clazz = Class.forName(s);
     * 最常用的开发方法，将s写入配置文件里边。这个时候，我们需要创建新的对象时，只需要
     * 修改配置文件，将其字节码和对应的类名写入即可。可扩展性大大提高。
     *
     * @throws ClassNotFoundException 可能抛出的异常。
     */
    private static void getClass3() throws ClassNotFoundException {
        String s = "classandobject.Person";//必须是项目的src目录下的子包。
        //= "JavaLearningStory.src.classandobject.Person";//这个时候报错了。包路径写错了。
        //我们如果知道要得到的类字节码对象是什么，应该用其泛型
        Class<?> clazz = Class.forName(s);//该方法可能会抛出异常，如果给的字符串指定的类不存在就无法创建该类
        System.out.println("Class.forName(String)："+clazz);

    }
}
