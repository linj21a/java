package exception_use;

import java.util.Scanner;

public class Test5 {
        public boolean validateUserName(String username) {
            boolean con = false;
            if (username.length() > 8) {
                // 判断用户名长度是否大于8位
                for (int i = 0; i < username.length(); i++) {
                    char ch = username.charAt(i); // 获取每一位字符
                    if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                        con = true;
                    } else {
                        con = false;
                        throw new IllegalArgumentException("用户名只能由字母和数字组成！");
                    }
                }
            } else {
                throw new IllegalArgumentException("用户名长度必须大于 8 位！");
            }
            return con;
        }

        public static void main(String[] args) {
            Test5 te = new Test5();
            Scanner input = new Scanner(System.in);
            System.out.println("请输入用户名：");
            String username = input.next();
            try {
                boolean con = te.validateUserName(username);
                if (con) {
                    System.out.println("用户名输入正确！");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
}
