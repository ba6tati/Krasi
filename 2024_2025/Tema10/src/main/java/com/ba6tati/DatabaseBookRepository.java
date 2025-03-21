package com.ba6tati;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

public class DatabaseBookRepository implements BookRepository {

    private MongoDatabase database = MongoDBUtils.getDatabase(); // създава нова връзка към базата

    private MongoCollection<Document> collection = database.getCollection("books"); // избира колекцията (таблица) книги

    @Override
    public void addBook(Book book) {
        try {
            if (findBookByIsbn(book.getIsbn()).size() > 0) { // ако има съществуваща книга с този isbn, хвърля изключение
                throw new Exception("Book with this isbn already exists");
            }
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            return;
        }

        Document bookDocument = new Document() // създава нов документ (обект в таблицата) в колекцията
            .append("title", book.getTitle())
            .append("author", book.getAuthor())
            .append("isbn", book.getIsbn())
            .append("yearPublished", book.getYearPublished());

        collection.insertOne(bookDocument); // добавя книгата към базата

        System.out.println("INFO: Book created successfully: " + book);
    }

    @Override
    public boolean removeBook(String isbn) {
        Document query = new Document("isbn", isbn); // намира всички книги по даден isbn

        DeleteResult result = collection.deleteOne(query); // изтрива намерените книги

        try {
            if (result.getDeletedCount() == 0) { // ако няма изтрити книги, няма намерени книги, затова се хвърля изключение
                throw new Exception("EXCEPTION: Book with isbn " + isbn + " was not found.");
            } else {
                System.out.println("INFO: Book with ISBN " + isbn + " removed successfully");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Book> findBookByTitle(String title) {
        List<Book> foundBooks = new ArrayList<Book>();

        Document query = new Document("title", title); // намира всички книги по загалвие
        FindIterable<Document> result = collection.find(query); // запазва резултата

        for (Document doc : result) { // итерира резултата и запазва книгите във foundBooks
            Book book = documentToBook(doc); // конвертира документа (таблицата) в обект от тип Book
            System.out.println("INFO: Book found by title (" + title + "): " + book);
            foundBooks.add(book);
        }

        return foundBooks;
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<Book>();

        Document query = new Document("author", author); // намира всички книги по автор
        FindIterable<Document> result = collection.find(query); // запазва резултата

        for (Document doc : result) { // итерира резултата и запазва книгите във foundBooks
            Book book = documentToBook(doc); // конвертира документа (таблицата) в обект от тип Book
            System.out.println("INFO: Book found by author (" + author + "): " + book);
            foundBooks.add(book);
        }
        
        return foundBooks;
    }

    public List<Book> findBookByIsbn(String isbn) {
        List<Book> foundBooks = new ArrayList<Book>();

        Document query = new Document("isbn", isbn); // намира всички книги по автор
        FindIterable<Document> result = collection.find(query); // запазва резултата

        for (Document doc : result) { // итерира резултата и запазва книгите във foundBooks
            Book book = documentToBook(doc); // конвертира документа (таблицата) в обект от тип Book
            System.out.println("INFO: Book found by isbn (" + isbn + "): " + book);
            foundBooks.add(book);
        }
        
        return foundBooks;
    }
    
    private Book documentToBook(Document doc) { // метод, който създава обект от документ (таблица)
        Book book = new Book(doc.getString("title"), doc.getString("author"), doc.getString("isbn"), doc.getInteger("yearPublished"));
        return book;
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();

        List<Document> documents = collection.find().into(new ArrayList<>());

        for (Document doc : documents) {
            Book book = new Book(
                doc.getString("title"), 
                doc.getString("author"),
                doc.getString("isbn"),
                doc.getInteger("yearPublished")
            );

            books.add(book);
        }

        return books;
    }
}
