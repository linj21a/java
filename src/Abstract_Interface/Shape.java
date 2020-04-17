package Abstract_Interface;

public abstract class Shape {
    public double height;
    public double weight;

    //构造方法
   public Shape(double height,double weight){
        this.height=height;
        this.weight=weight;
    }
    //
    public abstract double getArea();//抽象类才有抽象方法，而且没有函数体。
}
