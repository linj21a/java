package Stream_IntOut;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 需求：使用FileInputStream来读取以及存在的文件word.txt
 *
 */
public class FileInputStream_Test {
    public static void main(String[]args)  {
        File f = new File("E:/words.txt");
        FileInputStream fi = null;
        try{
            if(f.exists()){
                System.out.println("读取文件完成！");
            //创建文件输入流
            fi = new FileInputStream(f);
            //开始读文件
            byte []buff = new byte[1024];
            int len;
            System.out.println("文件的内容为");
            while((len=fi.read(buff,0,buff.length))!=-1){
                System.out.print(new String(buff,0,len));
            }
            }
            else{
                System.out.println("读取文件失败，请检查路径！");
            }



        }catch(Exception e){
            e.printStackTrace();

        }finally{
            try {
                assert fi != null;
                fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
