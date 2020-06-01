package Stream_IntOut;

import java.io.File;

/**
 * 删除一个带有内容的目录——
 * 实际上需要从里往外删除。

 */

public class Practice9_RemoveFileDemo {
    public static void main(String[]args){
        readDemo();
    }

    public static void readDemo() {
        File f = new File("E:\\remove");//里面是有内容的
//        此时调用delete是删除不了的
        System.out.println("删除"+f.delete()+"里边有内容");

        //
        System.out.println("必须进行递归删除，从里往外删除。");
        removeDemo(f);
    }

    private static void removeDemo(File f) {
        File []files = f.listFiles();
        for(File i:files){
            if(!i.isDirectory()){//不是目录
                System.out.println(i.getAbsolutePath()+"删除"+i.delete());
            }
            else
                removeDemo(i);
        }
        System.out.println(f.getAbsolutePath()+"删除目录"+f.delete());
    }
}
