package classandobject;

public class InterfaceTest2<E> implements InterfaceDemo<E> {
    @Override
    public void show(E e) {
        System.out.println("字符串的toString方法："+e.toString());
    }
    public static void main(String[]args){
        InterfaceTest2<String> it = new InterfaceTest2<>();
        it.show("jailer");
        it.Test(new Person("zsazsa",23));
        System.out.println(it.Test2(new Person("zanySan",43)));
    }
    public <A> void Test(A a){
        System.out.println("泛型方法1"+a.hashCode());
    }
    public <C> int Test2(C c){
        System.out.println("泛型方法1"+c.hashCode());
        return 2;
    }
}
