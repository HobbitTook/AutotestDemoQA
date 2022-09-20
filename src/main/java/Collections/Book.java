package Collections;

import java.util.ArrayList;
import java.util.List;

public class Book {
    List<String> storedBook = new ArrayList<>();

    public void addNewBook(String book) {
        storedBook.add(book);
    }

    public void removeBook(String book) {
        storedBook.remove(book);
    }

    public void searchBook(String Book) {
        for (String storedBook : storedBook) {
            if (storedBook.contains(Book)) {
                System.out.println("Книга есть в наличии");
            } else System.out.println("Книга закончилась");
        }
    }
}
