package Lambda表达式;

/**
 * 性能浪费的例子：
 * 日志打印
 */

public class FunctionInterface02 {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "c";
        /*new FunctionInterface02().log(1,s1+s2+s3);//无论级别level等不等于1，字符串拼接都会进行*/
        new FunctionInterface02().log(1,()->s1+s2+s3);



    }
  /*  public void log(int level,String mess){
        if(level==1)
            System.out.println("mess = " + mess);
    }*/
  public void log(int level,FunctionInterface02_test test){
      if(level==1){
          System.out.println(test.concat());
      }
  }
}
