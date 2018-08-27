package net.proselyte.springmvc.service;

import net.proselyte.springmvc.BookNotFoundException;
import net.proselyte.springmvc.model.Book;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface Service {

  List<Book> getAllBooks();
    Book fingBookById(int id);

    void createBook(Book book);

    void updateBook(Book book);

    void deleteBook(int  id);

  Book loadBookByTitle(String title)throws BookNotFoundException, DataAccessException;


}
