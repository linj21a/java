package Abstract_Interface;

public class InterFace_Demo implements Circle_Interface{
    private double radius;

    //定义一个构造方法
    public InterFace_Demo(double radius){
        this.radius = radius;
    }

    //应该加@Override声明为重写
    @Override
    public double getArea(){
        return pai*radius*radius;
    }
    @Override
    public double getLength(){
        return pai *radius*2;
    }

    public static void main(String[]args){
        InterFace_Demo circle = new InterFace_Demo(4);

        //计算面积，接口的抽象方法必须重写
        System.out.println(circle.getArea());

        //计算周长,如果当前类没有重写接口中的默认方法，默认调用接口的该方法 0
        System.out.println(circle.getLength());

        //调用接口里边的静态方法,但是只能自己调用，通过接口名调用
        System.out.println(Circle_Interface.Volume());
    }
}
