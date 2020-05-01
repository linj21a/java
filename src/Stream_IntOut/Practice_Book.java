package Stream_IntOut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Practice_Book {
    private int no; // 编号
    private String name; // 名称
    private double price; // 单价

    public Practice_Book(int no, String name, double price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "图书编号：" + this.no + "，图书名称：" + this.name + "，图书单价：" + this.price + "\n";
    }

    public static void write(List books) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("E:\\words.txt"); // 创建FileWriter对象
            for (int i = 0; i < books.size(); i++) {
                fw.write(books.get(i).toString()); // 循环写入
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void read() {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("E:\\words.txt");
            br = new BufferedReader(fr); // 创建BufferedReader对象
            String str = "";
            while ((str = br.readLine()) != null) { // 循环读取每行数据
                System.out.println(str); // 输出读取的内容
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

