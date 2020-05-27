package 面试题;

/**
 * try-catch-finally
 * 中return的关系
 * 1、仅try中有return
 * 仅 catch中有return
 * 仅 finally中有return
 *
 * 2、try与catch有return
 * try与finally中有return
 * catch与finally中有return
 *
 * 3、都有return
 */

public class FinallyAndReturnAndThrow {
    public static void main(String[]args){
//        System.out.println(test1());
//        System.out.println(test2());
        System.out.println(test3());


    }

    private static int test1() {//try有return
        try{
            return 1;
        }finally {
            System.out.println("finally1");
        }
    }

    private static int test2() {//try与catch中有catch
        try{
            System.out.println("haha"+1/0);
            return  4;
        }catch(Exception e){
            return 2;
        }finally {
            System.out.println("finally2");
        }
    }

    private static int test3() {//当finally中有返回值则直接返回，不再去执行try或者catch的return

        try{
            System.out.println("try语句");
            return 1;
        }catch(Exception e){
            return 2;
        }finally {
            System.out.println("finally4");
            return 3;
        }
    }
    private static int test4() {
        int result=0;
        try{
            System.out.println("try语句"+1/result);//抛出异常
            return result;
        }catch(Exception e){//捕抓
            return result+1;
        }finally {
            System.out.println("finally3");
            result=100;
            System.out.println(result);

        }
    }

}
