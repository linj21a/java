package 内部类的三种类型;

/*非静态内部类不能有静态成员，实例内部类、
 */
public class Practice_Not_Static {
    int num = 5;

    class Inner1 {//非静态成员类，实例内部类
        int num = 4;

        void show() {
            System.out.println("this" + this.num);//使用当前的this
            System.out.println("Inner1.this" + Inner1.this.num);
            System.out.println("Practice_Not_Static.this" + Practice_Not_Static.this.num);
        }
    }
    //-----------------------------------------------------------------------------------------

    Inner1 i = new Inner1(); // 使用时不需要创建外部类实例

    public void method1() {
        Inner1 i = new Inner1(); // 不需要创建外部类实例
    }

    //静态方法需要创建外部类实例
    public static void method2() {
        Inner1 i = new Practice_Not_Static().new Inner1();
    }

    class Inner2 {
        Inner1 i = new Inner1(); // 不需要创建外部类实例
    }
}

//在实例内部类中，可以访问外部类的所有成员。
class OtherClass {
    public int a = 100;
    static int b = 100;
    final int c = 100;
    private int d = 100;

    public String method1() {
        return "实例方法1";
    }

    public static String method2() {
        return "静态方法2";
    }

    class Inner {
        int a2 = a + 1; // 访问public的a
        int b2 = b + 1; // 访问static的b
        int c2 = c + 1; // 访问final的c
        int d2 = d + 1; // 访问private的d
        String str1 = method1(); // 访问实例方法method1
        String str2 = method2(); // 访问静态方法method2
    }

    public static void main(String[] args) {
        Inner i = new OtherClass().new Inner(); // 创建内部类实例
        System.out.println(i.a2); // 输出101
        System.out.println(i.b2); // 输出101
        System.out.println(i.c2); // 输出101
        System.out.println(i.d2); // 输出101
        System.out.println(i.str1); // 输出实例方法1
        System.out.println(i.str2); // 输出静态方法2


        Practice_Not_Static.Inner2 l = new Practice_Not_Static().new Inner2(); // 需要创建外部类实例
        //打印hashcode
        System.out.println(l.hashCode());

        //打印类的包，$加类名加哈希码
        System.out.println(l);
        new Practice_Not_Static().new Inner1().show();
    }
}
    /*
    在外部类中不能直接访问内部类的成员，而必须通过内部类的实例去访问。
    如果类 A 包含内部类 B，类 B 中包含内部类 C，则在类 A 中不能直接访问类 C，
    而应该通过类 B 的实例去访问类 C。

    外部类实例与内部类实例是一对多的关系，也就是说一个内部类实例只对应一个外部类实例，
    而一个外部类实例则可以对应多个内部类实例。

    如果实例内部类 B 与外部类 A 包含有同名的成员 t，
    则在类 B 中 t 和 this.t 都表示 B 中的成员 t，而 A.this.t 表示 A 中的成员 t。
     */

