package 面试题;

/**
 * 将一个整数数组转化为字符串
 * 方式1：使用+号表达式
 * 方式2：使用StringBuffer（线程安全）我们应该使用StringBuilder
 */
public class StringTest1 {
    public static void main(String[] args) {
        int[] i = {1, 5, 6, 7, 8, 9, 4, 3, 5, 22, 33, 44, 55, 66, 77, 88, 99, 19, 22, 999, 456, 342, 11, 222, 3321};
        //使用方式1,发现方式1比方式2慢
        long t1 = System.currentTimeMillis();
        StringBuilder s1 = intToString1(i);
        System.out.println((System.currentTimeMillis() - t1) + "ms");
        System.out.println(s1);

        //使用方式2
        long t2 = System.currentTimeMillis();
        String s2 = intToString2(i);
        System.out.println((System.currentTimeMillis() - t2) + "ms");
        System.out.println(s2);
    }

    /**
     * 方法1：不用产生中间字符串存储到字符串常量池中，节省空间，加快效率。
     * 定义一个函数用来将整型数组转化为字符串。
     *
     * @param i 整型数组
     * @return 返回转化后的字符串
     */
    private static StringBuilder intToString1(int[] i) {
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < i.length; j++) {
            s.append(i[j] + "");
        }
        return s;
    }

    /**
     * 方式2：每次执行字符串相加，因为使用到了+号表达式，就会每次都创建字符串存储到字符串常量池里边
     * 进而导致效率低下
     *
     * @param i
     * @return
     */
    private static String intToString2(int[] i) {
        String s = "";
        for (int j = 0; j < i.length; j++) {
            s += (i[j] + "");
        }
        return s;
    }
}
