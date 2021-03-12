package Stream_IntOut;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Practice10_Properties_ListFile {
    static int i = 0;

    public static void main(String[] args) {
        File src = new File("E:\\算法书籍\\");
        FilenameFilter filter = (dir, name) -> name.endsWith(".pdf") || name.endsWith(".mp4") || name.endsWith(".wmv");
        List<File> list = new ArrayList<>();
        getFileName(src, filter, list);
        add(new File(src, "list.txt"), list);

    }

    /**
     * 根据指定的目录，以及给定过滤文件，进行过滤，生成文件清单，并保存到对应的目录下。
     * @param dir    指定的遍历目录
     * @param filter 对应的过滤器
     * @param list   中间存放文件清单的容器
     */
    public static void getFileName(File dir, FilenameFilter filter, List<File> list) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {//如果是文件
                    //过滤
                    if (filter.accept(f, f.getName())) {
                        list.add(f);
                    }
                } else
                    getFileName(f, filter, list);
            }
        }
    }

    /**
     * 将容器中的文件清单写入到硬盘中。
     * @param dest 目标地址
     * @param list 存放文件清单的临时容器
     */
    public static void add(File dest, List<File> list) {
        BufferedWriter bufw = null;
        try {
            bufw = new BufferedWriter(new FileWriter(dest));
            for (File f : list) {
                bufw.write(i + " " + f.getAbsolutePath());//这里可以使用getAbsolutionPath
                i++;
                bufw.newLine();
                bufw.flush();//注意要刷新，才能写入。因为这个是字符输入流。
            }
            System.out.println("写入成功！");

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("写入失败。");
        } finally {
            if (bufw != null)
                try {
                    bufw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }
}
