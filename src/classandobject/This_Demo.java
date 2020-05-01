package classandobject;

public class This_Demo {

    private double radius;

    public This_Demo(double radius) {
        this.radius = radius;
    }

    public This_Demo() {
        this(1.0); // call the upper initializer.
        this.radius = 2.0; // just to indicate that the this(parameters...) must be called first.
    }

    public static void main(String args[]) {
        String n = null;
        System.out.println(n.length());
    }
}
