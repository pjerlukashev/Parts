package net.proselyte.springmvc.dao;

import net.proselyte.springmvc.model.Book;

import java.util.List;

public interface DAO {

    Book fingBookById(int id);
    void createBook(Book book);

    void updateBook(Book book);

    void deleteBook(int  id);
    List<Book> getAllBooks();


}
