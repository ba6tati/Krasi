package com.ba6tati;

import java.util.List;public interface BookRepository { void addBook(Book book);boolean removeBook(String isbn);List<Book> findBookByTitle(String title);List<Book> findBookByAuthor(String author);}