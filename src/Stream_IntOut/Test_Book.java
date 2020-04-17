package Stream_IntOut;

import java.util.ArrayList;
import java.util.List;

public class Test_Book {

        public static void main(String[] args) {
            Practice_Book book1 = new Practice_Book(1001, "C语言中文网Java教程", 159);
            Practice_Book book2 = new Practice_Book(1002, "C语言中文网C++教程", 259);
            List books = new ArrayList();
            books.add(book1);
            books.add(book2);
            Practice_Book.write(books);
            System.out.println("********************图书信息******************");
            Practice_Book.read();
        }
    }

