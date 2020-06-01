package Stream_IntOut;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class SuffixFilter implements FileFilter {
    private String suffix;

    public SuffixFilter(String suffix) {
        this.suffix = suffix;
    }
    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(suffix)&&pathname.isFile();//文件的过滤我这里要求它是文件。
    }
}
