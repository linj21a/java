package classandobject;

public class InterfaceTest1 implements InterfaceDemo<String> {

    @Override
    public void show(String s) {
        System.out.println("字符串内容为："+s);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    public static void main(String[]args){
        InterfaceTest1 it = new InterfaceTest1();
        it.show("jier");
    }
}
