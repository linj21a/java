package Abstract_Interface;

public class Triangle extends Shape {
    public Triangle(double height,double weight){
        super(height,weight);
    }
    //重写抽象方法
    public double getArea(){
        return 0.5*height*weight;
    }
}
