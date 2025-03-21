package com.ba6tati;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository implements BookRepository {
    public List<Book> books = new ArrayList(); // списъкът съдържа всички книги

    @Override
    public void addBook(Book book) {
        books.add(book); // добавя книгата към списъка книги
    }

    @Override
    public boolean removeBook(String isbn) {
        for (Book book : books) { // итерира през всички книги и маха книгите, които отговарят на isbn
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                return true; // връща true, ако е премахнало поне една книга.
            }
        }

        return false;
    }

    public void printInfo() {
        for (Book book: books) {
            // принтира информация за всички книги
            System.out.println(book);
        }
    }

    @Override
    public List<Book> findBookByTitle(String title) {
        List<Book> result = new ArrayList(); // създавам нов списък за резултата

        for (Book book : books) { // итерира през всички книги и намира книгите, които отговарят на заглавието.
            if (book.getTitle().equals(title)) {
                result.add(book);
            }
        }

        return result; // връща всички книги, които са намерени (може да е празен списък)
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        List<Book> result = new ArrayList(); // създавам нов списък за резултата

        for (Book book : books) { // итерира през всички книги и намира книгите, които отговарят на автора.
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }

        return result; // връща всички книги, които са намерени (може да е празен списък)
    }
}