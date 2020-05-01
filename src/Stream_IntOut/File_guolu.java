package Stream_IntOut;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * 假设希望只列出目录下的某些文件，这就需要调用带过滤器参数的 list() 方法。首先需要创建文件过滤器，
 * 该过滤器必须实现 java.io.FilenameFilter 接口，并在 accept() 方法中指定允许的文件类型。
 * <p>
 * 如下所示为允许 SYS、TXT 和 BAK 格式文件的过滤器实现代码：
 * 纯文本复制
 * public class ImageFilter implements FilenameFilter {
 * // 实现 FilenameFilter 接口
 *
 * @Override public boolean accept(File dir, String name) {
 * // 指定允许的文件类型
 * return name.endsWith(".sys") || name.endsWith(".txt") || name.endsWith(".bak");
 * }
 * }
 */

public class File_guolu implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".txt") || name.endsWith(".sys");
    }

}
