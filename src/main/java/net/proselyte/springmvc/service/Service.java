package net.proselyte.springmvc.service;

import net.proselyte.springmvc.model.Book;

import java.util.List;

public interface Service {

  List<Book> getAllBooks();
    Book fingBookById(int id);

    void createBook(Book book);

    void updateBook(Book book);

    void deleteBook(int  id);


}
