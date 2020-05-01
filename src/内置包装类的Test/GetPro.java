package 内置包装类的Test;

public class GetPro {
    public static void main(String[] args) {
        String jversion = System.getProperty("java.version");
        String oName = System.getProperty("os.name");
        String user = System.getProperty("user.name");
        String user_dir = System.getProperty("user.dir");
        System.out.println("Java 运行时环境版本：" + jversion);
        System.out.println("当前操作系统是：" + oName);
        System.out.println("当前用户是：" + user);
        System.out.println("当前用户的工作目录是：" + user_dir);
    }
}