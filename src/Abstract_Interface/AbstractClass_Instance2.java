package Abstract_Interface;
abstract  class A{
    private String s;
    public void setS(String s){
        this.s = s;
    }
    public String getS(){
        return this.s;
    }
    public abstract void show();
    public static A newInstance(){
        return new A(){public void show(){
            System.out.println("匿名内部类实际就是一个A的子类");
        }};
    }
}

public class AbstractClass_Instance2 {
    public static void main(String[]args){
        A a = A.newInstance();
        a.show();
    }
}
