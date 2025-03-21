package com.ba6tati;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static DatabaseBookRepository bookRepository = new DatabaseBookRepository();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    findBookByTitle();
                    break;
                case 4:
                    findBookByAuthor();
                    break;
                case 5:
                    findBookByIsbn();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Book Repository CLI ---");
        System.out.println("1. Add a Book");
        System.out.println("2. Remove a Book by ISBN");
        System.out.println("3. Find Books by Title");
        System.out.println("4. Find Books by Author");
        System.out.println("5. Find Book by ISBN");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Enter year published: ");
        int yearPublished = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Book book = new Book(title, author, isbn, yearPublished);
        bookRepository.addBook(book);
    }

    private static void removeBook() {
        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = scanner.nextLine();

        boolean isRemoved = bookRepository.removeBook(isbn);
        if (isRemoved) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void findBookByTitle() {
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();

        List<Book> books = bookRepository.findBookByTitle(title);
        if (books.isEmpty()) {
            System.out.println("No books found with the title: " + title);
        }
    }

    private static void findBookByAuthor() {
        System.out.print("Enter author to search: ");
        String author = scanner.nextLine();

        List<Book> books = bookRepository.findBookByAuthor(author);
        if (books.isEmpty()) {
            System.out.println("No books found by the author: " + author);
        }
    }

    private static void findBookByIsbn() {
        System.out.print("Enter ISBN to search: ");
        String isbn = scanner.nextLine();

        List<Book> books = bookRepository.findBookByIsbn(isbn);
        if (books.isEmpty()) {
            System.out.println("No books found with the ISBN: " + isbn);
        }
    }
}