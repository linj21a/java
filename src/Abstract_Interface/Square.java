package Abstract_Interface;

public class Square extends Shape {
    public Square(double height, double weight) {
        super(height, weight);
    }

    //这个时候必须重写父类的抽象方法。否则报错,而且使用注解@Override标识
    @Override
    public double getArea() {
        //可以不使用this，隐式 return this.height*this.weight;
        return height * weight;
    }
}
