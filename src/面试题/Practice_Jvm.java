package 面试题;

public class Practice_Jvm {
    public static void main(String []args){
        int i = 2;
        int b = i++;//2
        b = b++;//根本不改变b的值。
        int c = ++i;//4

        System.out.println(i+" "+b+" "+c);
        for(int k=0;k<10;k++){
            b = b++;//b = 2->先将2入栈，然后槽2里的b加1，此时槽里的b=3，然后将栈顶元素值2弹出到槽2，即b被重赋值为2；
        }
        System.out.println(b);//b则等于2
    }
}
/*
D:\编程\java>java Practice_Jvm
4 2 4

D:\编程\java>javap -c Practice_Jvm.class
Compiled from "Practice_Jvm.java"
public class Practice_Jvm {//一个方法一个栈帧
  public Practice_Jvm();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: iconst_2      //常量2入栈
       1: istore_1      //将栈顶元素（值为2）弹出到本地变量表中的下标为1的Slot（槽）,完成i的赋值 i = 2
       2: iload_1       //将1槽的数压入栈（值为2）
       3: iinc          1, 1        //将1槽里的i值加1；此时i=3；
       6: istore_2                  //将栈顶的元素值（值为2）弹出到2槽，即让b = 2；
       7: iinc          1, 1        /将1槽的值加1，此时i=4
      10: iload_1                   //1槽的值入栈，
      11: istore_3                  //将栈顶元素值（i=3）弹出到3槽，即c=3
      12: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      15: iload_1
      16: iload_2
      17: iload_3
      18: invokedynamic #3,  0              // InvokeDynamic #0:makeConcatWithConstants:(III)Ljava/lang/String;
      23: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      26: return
}
 */
