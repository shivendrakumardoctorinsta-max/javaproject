package solid;

import java.util.ArrayList;
import java.util.List;

public class SingleResposibilityPrinciple {
    public static void main(String[] args) {
        BookRepository repo = new BookRepository();
        BookPrinter printer = new BookPrinter();

        Book b1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        Book b2 = new Book("978-0201633610", "Design Patterns", "Erich Gamma et al.");

        repo.save(b1);
        repo.save(b2);

        System.out.println("Books saved to repository. Printing all books:\n");
        printer.printAll(repo.findAll());
    }

}

class Book {
    private final String isbn;
    private final String title;
    private final String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    @Override
    public String toString() {
        return String.format("%s — %s (by %s)", isbn, title, author);
    }
}

// Responsibility: persist books (simple in-memory example)
class BookRepository {
    private final List<Book> storage = new ArrayList<>();

    public void save(Book book) {
        storage.add(book);
    }

    public List<Book> findAll() {
        return new ArrayList<>(storage);
    }
}

// Responsibility: printing books (separate from persistence)
class BookPrinter {
    public void print(Book book) {
        System.out.println(book);
    }

    public void printAll(List<Book> books) {
        for (Book b : books) {
            print(b);
        }
    }
}
