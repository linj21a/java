package 内部类的三种类型;

public class Local_Class {
    //局部内部类是指在一个方法中定义的内部类。
    public void sayHello(){
        //局部内部类只在当前方法中有效。
        class Local_inner{//局部内部类与局部变量一样，不能使用访问控制修饰符（public、private 和 protected）和 static 修饰符修饰。
            //局部内部类中不能定义 static 成员。既然是局部变量自然不能声明static成员
            public void sayHello(){
                System.out.println("我是局部内部类，在方法里边定义的类！");
            }
        }
        System.out.println("我是包含该局部内部类的方法，局部内部类我儿子！");

        new Local_inner().sayHello();//在该方法里面调用局部内部类的方法，使用匿名内部类一次

    }
    public static void main(String[]args){
        Local_Class local = new Local_Class();
        local.sayHello();

    }
}
