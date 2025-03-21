package com.ba6tati;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Main {

    private static DatabaseBookRepository bookRepository = new DatabaseBookRepository();
    private static DefaultListModel<String> bookListModel = new DefaultListModel<>();
    private static JList<String> bookList = new JList<>(bookListModel);

    public static void main(String[] args) {
        // Създаване и показване на графичния интерфейс в Event Dispatch Thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        // Създаване на главния прозорец
        JFrame frame = new JFrame("Графичен интерфейс за библиотека с книги");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Създаване на панел за бутоните в менюто
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(7, 1, 10, 10)); // Увеличени редове до 7 за новия бутон
        menuPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Добавяне на марж около панела

        // Създаване на бутони за всяка опция в менюто
        JButton addBookButton = new JButton("Добави книга");
        JButton removeBookButton = new JButton("Премахни книга по ISBN");
        JButton findBookByTitleButton = new JButton("Търси книги по заглавие");
        JButton findBookByAuthorButton = new JButton("Търси книги по автор");
        JButton findBookByIsbnButton = new JButton("Търси книга по ISBN");
        JButton showAllBooksButton = new JButton("Покажи всички книги"); // Нов бутон
        JButton exitButton = new JButton("Изход");

        // Добавяне на бутоните към панела
        menuPanel.add(addBookButton);
        menuPanel.add(removeBookButton);
        menuPanel.add(findBookByTitleButton);
        menuPanel.add(findBookByAuthorButton);
        menuPanel.add(findBookByIsbnButton);
        menuPanel.add(showAllBooksButton); // Добавяне на новия бутон
        menuPanel.add(exitButton);

        // Създаване на панел с плъзгач за списъка с книги
        JScrollPane listScrollPane = new JScrollPane(bookList);
        listScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Добавяне на марж около панела

        // Добавяне на компонентите към прозореца
        frame.add(menuPanel, BorderLayout.WEST);
        frame.add(listScrollPane, BorderLayout.CENTER);

        // Зареждане на всички книги по подразбиране при стартиране
        showAllBooks();

        // Добавяне на слушатели за действия към бутоните
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

        removeBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeBook();
            }
        });

        findBookByTitleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findBookByTitle();
            }
        });

        findBookByAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findBookByAuthor();
            }
        });

        findBookByIsbnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findBookByIsbn();
            }
        });

        showAllBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllBooks(); // Извикване на новия метод
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Показване на прозореца
        frame.setVisible(true);
    }

    private static void addBook() {
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField isbnField = new JTextField();
        JTextField yearField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Добавяне на марж към диалоговия панел
        panel.add(new JLabel("Заглавие:"));
        panel.add(titleField);
        panel.add(new JLabel("Автор:"));
        panel.add(authorField);
        panel.add(new JLabel("ISBN:"));
        panel.add(isbnField);
        panel.add(new JLabel("Година на публикуване:"));
        panel.add(yearField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Добави книга", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String title = titleField.getText();
            String author = authorField.getText();
            String isbn = isbnField.getText();
            int yearPublished = Integer.parseInt(yearField.getText());

            Book book = new Book(title, author, isbn, yearPublished);
            bookRepository.addBook(book);
            bookListModel.addElement(book.toString()); // Добавяне на новата книга към списъка
        }
    }

    private static void removeBook() {
        String isbn = JOptionPane.showInputDialog("Въведете ISBN на книгата за премахване:");
        if (isbn != null && !isbn.isEmpty()) {
            boolean isRemoved = bookRepository.removeBook(isbn);
            if (isRemoved) {
                for (int i = 0; i < bookListModel.size(); i++) {
                    if (bookListModel.get(i).contains("ISBN: " + isbn)) {
                        bookListModel.remove(i);
                        break;
                    }
                }
            }
        }
    }

    private static void findBookByTitle() {
        String title = JOptionPane.showInputDialog("Въведете заглавие за търсене:");
        if (title != null && !title.isEmpty()) {
            List<Book> books = bookRepository.findBookByTitle(title);
            bookListModel.clear();
            if (books.isEmpty()) {
                bookListModel.addElement("Няма намерени книги със заглавие: " + title);
            } else {
                for (Book book : books) {
                    bookListModel.addElement(book.toString());
                }
            }
        }
    }

    private static void findBookByAuthor() {
        String author = JOptionPane.showInputDialog("Въведете автор за търсене:");
        if (author != null && !author.isEmpty()) {
            List<Book> books = bookRepository.findBookByAuthor(author);
            bookListModel.clear();
            if (books.isEmpty()) {
                bookListModel.addElement("Няма намерени книги от автор: " + author);
            } else {
                for (Book book : books) {
                    bookListModel.addElement(book.toString());
                }
            }
        }
    }

    private static void findBookByIsbn() {
        String isbn = JOptionPane.showInputDialog("Въведете ISBN за търсене:");
        if (isbn != null && !isbn.isEmpty()) {
            List<Book> books = bookRepository.findBookByIsbn(isbn);
            bookListModel.clear();
            if (books.isEmpty()) {
                bookListModel.addElement("Няма намерени книги с ISBN: " + isbn);
            } else {
                for (Book book : books) {
                    bookListModel.addElement(book.toString());
                }
            }
        }
    }

    // Метод за показване на всички книги
    private static void showAllBooks() {
        List<Book> books = bookRepository.getAllBooks(); // Извличане на всички книги
        bookListModel.clear(); // Изчистване на текущия списък
        if (books.isEmpty()) {
            bookListModel.addElement("Няма книги в библиотеката.");
        } else {
            for (Book book : books) {
                bookListModel.addElement(book.toString()); // Добавяне на всяка книга към списъка
            }
        }
    }
}