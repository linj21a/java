package java基础;

import java.util.Scanner;

/**
 * 需求：使用StringBuffer实现对学生提交作业的格式判断，并实现纠正“。”及全角状态下替换为英文
 * @author Lh
 * @version 1.0.0
 */
public class StringBuffer_Test {
   public static void main(String[]args){
       System.out.println("请输入你要提交的java文件：");
       Scanner input = new Scanner(System.in);
       String filename = input.next();

       //定义一个可以修改的字符串
       StringBuffer file = new StringBuffer(filename);

       //判断是否存在'.'
       int index = file.lastIndexOf(".");
       //判断中文状态是否存在”。“
       int errindex1 = file.lastIndexOf("。");
       System.out.println(errindex1);

       //开始检查
       if(index!=-1&& file.substring(index+1).equals("java")){
           System.out.println("作业提交成功！");
       }
       //缺少'.'存在"。”
       else if(errindex1!=-1&&file.substring(errindex1+1).equals("java")){
           file.setCharAt(errindex1,'.');
           System.out.println("输入的格式有误，已经为你更正为："+file+"\r\n提交成功！");
       }
       else
           System.out.println("输入的格式有误，请核实！");

   }
}
