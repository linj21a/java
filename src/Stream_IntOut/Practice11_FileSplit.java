package Stream_IntOut;

import java.io.*;
import java.util.Properties;


/**
 * 文件切割：
 * 将源文件切割成指定的份数。
 * 1、不能确定为纯文本，只能使用字节流。
 * 2、操作的源设备与目标设备都是硬盘。
 * 进而使用FileInputStream、FileOutputStream
 *
 * 如何指定份数——根据指定的文件大小分割的小文件大小进行计算。
 *
 * 定义一个缓冲区，其大小为分割文件的大小或者因数。每读取满几次该缓冲区，就写几次。
 * 进而实现了分割。
 */

public class Practice11_FileSplit {
    private static final int SIZE = 1024*1024;//设定为1M大小的缓冲区。
    private static final String PATH = "E:\\splitFiles\\";//分割的文件放在哪里应该右用户选择。

    public static void main(String[]args) throws IOException {
        splitFilesDemo();
    }

    public static void splitFilesDemo() throws IOException {
        File myfile = new File("E:\\DSC_0603.JPG");
        if(!myfile.exists()||myfile.isDirectory()){
            throw new RuntimeException("不是文件或者文件不存在！");
        }
        FileInputStream src_file = new FileInputStream(myfile);//对图片进行分割。
        byte []buff = new byte[SIZE];
        FileOutputStream dest_file = null;//读够指定的次数，才写一文件。
        File pathfile = new File(PATH);
        if(!pathfile.exists()){//目录不存在就创建。
            boolean res = pathfile.mkdirs();
            if(!res)
                throw new RuntimeException("创建目录失败！");
        }
        int count =1,time=0;
        int len;
        while((len=src_file.read(buff))!=-1){//因为这里的size是1M，所以读取一次就是1M
            time++;
            if(time==1){//读取第一次的时候就创建该文件。
                dest_file = new FileOutputStream(new File(pathfile,count+".part"));
            }

            assert dest_file != null;
            dest_file.write(buff,0,len);
            if(time==3){
                //说明已经读取够3M了。
                //开始分割下一个文件
                count++;
                time=0;
            }
        }
        System.out.println("文件分割完成！分割文件数量为"+count);
        /*
        应该有一个配置文件用于保存源文件的配置信息和源文件被分割的份数。
         */
        Properties config = new Properties();
        String s = myfile.getName();
        System.out.println(s);
        int index = s.indexOf(".");
        String format=s.substring(index);
        System.out.println(format);

        config.setProperty("FileName",s);
        config.setProperty("format",format);
        config.setProperty("partCount",count+"");
        config.store(new FileOutputStream(new File(PATH,"myfile.properties")),"source config info");
        if(dest_file!=null)
            dest_file.close();
        src_file.close();
    }
}
