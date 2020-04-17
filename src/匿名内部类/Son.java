package 匿名内部类;

public class Son {
    public  class Father_1 extends Father{//内部类，而且是实例内部类，非静态内部类
        public int strong(){
            return super.strong()+1;
        }
    }
    public  class Mother_1 extends Mother{////内部类，而且是实例内部类，非静态内部类
        public int kind(){
            return super.kind()+1;
        }
    }
    public int getStrong(){
        //使用匿名内部类
        return new Father_1().strong();
    }
    public int getKind(){
        //使用匿名内部类
        return new Mother_1().kind();
    }

    public static void main(String[]args){
        Son son = new Son();
        System.out.println("强壮指数"+son.getKind());
        System.out.println("和蔼指数"+son.getStrong());
    }

}
