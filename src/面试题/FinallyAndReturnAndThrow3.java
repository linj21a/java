package 面试题;


public class FinallyAndReturnAndThrow3 {
    public static void main(String[]args){
        displayTest();
    }
    private static void displayTest() {
        try{
            System.out.println(2/0);//异常发生
        }catch (Exception e){
            System.out.println("displayTest's catch");
            throw new RuntimeException("除数为0");
        }finally {
            System.out.println("displayTest's finally");
            throw new RuntimeException("俺会覆盖catch的异常");

        }
    }

//    private static void div() {
//        try{
//            System.out.println(1/0);
//        }catch (Exception e){
//            System.out.println("div's catch");
//            throw e;
//        }finally {
//            System.out.println("div's finally");
//        }
//    }
}
