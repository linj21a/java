package Stream_IntOut;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 学习如何处理文件写入时可能发生的异常
 */

public class Practice1_FileWriter_IOException {
    public static void main(String[]args){
        FileWriter fw = null;//第一步，必须声明的文件对象的范围
        try{
            fw = new FileWriter("E:\\file.txt",true);//当目标文件目录不存在就无法创建。
            fw.write("异常处理");

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fw!=null)//第二步：要判断文件对象到底有没有打开
                try{
                    fw.close();//第三步，判断该流是否已经关闭
                }catch (IOException e){
                    throw new RuntimeException("底层资源无法关闭，异常我们无法处理只能抛出");
                }

        }
    }
}
