package Stream_IntOut;

import java.io.File;

/**
 * 进行文件的层级遍历。并显示。
 */

public class Practice9_File_DeepTraver {

    public static void main(String[] args) {
        File f = new File("E:\\迅雷下载\\");
        deepTraver(f, 0);
    }

    /**
     * 进行文件的层级遍历。并显示。_递归实现
     *
     * @param dir   需要遍历的文件夹
     * @param level 对应的层级
     */
    public static void deepTraver(File dir, int level) {
        System.out.println(getlevel(level)+ dir.getName());
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {//是目录
                    deepTraver(f, level+1);
                }
                else System.out.println(getlevel(level+1)+f.getName());

            }
        }
    }

    private static String getlevel(int level) {

        StringBuilder sb = new StringBuilder();
        sb.append("|");
        while (level > 0) {
            sb.insert(0, "--");
            level--;
        }
        return sb.toString();
    }

}
