package Abstract_Interface;
abstract class Fu{
    public Fu(){
        System.out.println("父类构造器");
    }
    public abstract void show();
}
 class Zi extends Fu{
    public Zi(){
        System.out.println("子类构造器");
    }
    @Override
    public void show(){
    System.out.println("子类的show方法");
    }
}

public  class AbstractClass_Instance {
    public static void main(String...s){
        Fu fu = new Zi();
        fu.show();
    }
}
