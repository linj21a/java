package 设计模式;



public class Test1 {
    public static void main(String[]args){
        //Practice1 test = new Practice1();//无法使用new实例化一个对象
        Practice1 test1 = Practice1.getInstance();
        Practice1 test2 = Practice1.getInstance();//仅能通过一个方法。
        test1.say();
        test2.say();
        test1.setName("小小");
        test2.say();//实现共享
    }
}
