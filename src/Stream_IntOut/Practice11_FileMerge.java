package Stream_IntOut;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 既然有文件分割进行上传，就有文件碎片的下载之后进行合并。
 */

public class Practice11_FileMerge {
    public static void main(String[]args) throws IOException {
        String path = "E:\\splitFiles";//分割文件的目录在哪里。
        fileMerge2(path);
    }

    private static void fileMerge2(String path) throws IOException {
        /*
        既然是合并文件 ，那必须得知道合并的文件的数量和分割前的文件格式。我们才能正确合并
        所以我们需要读取配置文件。
         */
        //第一步，你需要多个流。所以你需要遍历文件目录看有多少个文件创建多少个流对象。
        File myfile = new File(path);
        if(!myfile.exists()||myfile.isFile()){//空目录或者本就是文件
            throw new RuntimeException("所选目录不存在或者不是目录！！！");
        }
        //第二步，用序列流统一操作这些流
        File[]files = myfile.listFiles(new SuffixFilter(".properties"));//使用自定义过滤器，选出配置文件。
        if(files==null||files.length!=1){
            throw new RuntimeException("文件目录为空或者配置文件不存在或者不唯一！程序退出");
        }
        //遍历文件，找到配置信息，进行格式提取和名字提取、分割的文件数量提取。
        Properties config = new Properties();
        config.load(new FileInputStream(files[0]));//加载配置文件
        int count = Integer.parseInt(config.getProperty("partCount"));//String不能强转为int
        //String format = config.getProperty("format");
        String filename = config.getProperty("FileName");
        ArrayList<FileInputStream> dest = new ArrayList<>();

        File[]partFiles = myfile.listFiles(new SuffixFilter(".part"));
        if(partFiles==null||partFiles.length!=count){
            throw new RuntimeException("文件碎片不存在或者数量不足！");
        }
        for(File f:partFiles){
            dest.add(new FileInputStream(f));
        }//这样就不用排序了

        Enumeration<FileInputStream> splitfile = Collections.enumeration(dest);
        SequenceInputStream sequenceStream = new SequenceInputStream(splitfile);
        //第三步，建立一个输出流，进行写操作。应该有个配置文件写明其原来的格式。
        FileOutputStream destFile = new FileOutputStream(new File(myfile,filename));
        byte []buff = new byte[1024];//100k缓冲区
        int len;
        while((len=sequenceStream.read(buff))!=-1){
            destFile.write(buff,0,len);
            destFile.flush();
        }
        //第四步，健壮性判断。
        System.out.print("合并完成！");
        destFile.close();
        sequenceStream.close();


    }

    public static void fileMerge(String path) throws IOException {
        long t1 = System.currentTimeMillis();
        //第一步，你需要多个流。所以你需要遍历文件目录看有多少个文件创建多少个流对象。
        File myfile = new File(path);
        if(!myfile.exists()||myfile.isFile()){//空目录或者本就是文件
            throw new RuntimeException("所选目录不存在或者不是目录！！！");
        }
        //第二步，用序列流统一操作这些流
        File[]files = myfile.listFiles();
        if(files==null){
            throw new RuntimeException("文件目录为空！程序退出");
        }
        ArrayList<File> dest = new ArrayList<>();
        for(File f:files){
            if(f.isFile()&&f.getName().endsWith(".part")){//是文件还要符合过滤器。以什么结尾。。。
                dest.add(f);
            }
        }
        //注意这里需要对文件进行字典排序,防止文件错乱顺序合并，得到的文件与目标文件不一致。
      Collections.sort(dest);//因为file实现了comparable接口。
        ArrayList<FileInputStream> dest_sort = new ArrayList<>();
        for(File f:dest){
            dest_sort.add(new FileInputStream(f));
        }
        Enumeration<FileInputStream> enumeration = Collections.enumeration(dest_sort);
        SequenceInputStream sequenceStream = new SequenceInputStream(enumeration);
        //第三步，建立一个输出流，进行写操作。应该有个配置文件写明其原来的格式。
        FileOutputStream destFile = new FileOutputStream(new File(myfile,"mergeFile.jpg"));
        byte []buff = new byte[102400];//100k缓冲区
        int len;
        while((len=sequenceStream.read(buff))!=-1){
            destFile.write(buff,0,len);
            destFile.flush();
        }
        //第四步，健壮性判断。
        System.out.print("合并完成！用时"+(System.currentTimeMillis()-t1)/1000/60/60+"秒");
        destFile.close();
        sequenceStream.close();
    }
}
