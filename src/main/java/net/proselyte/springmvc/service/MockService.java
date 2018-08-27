package net.proselyte.springmvc.service;

import net.proselyte.springmvc.BookNotFoundException;
import net.proselyte.springmvc.dao.DAO;
import net.proselyte.springmvc.dao.MockDAO;
import net.proselyte.springmvc.model.Book;
import org.springframework.dao.DataAccessException;

import java.util.List;


@org.springframework.stereotype.Service
public class MockService implements Service {

      private DAO dao;

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }

    @Override
    public Book fingBookById(int id) {
       return dao.fingBookById(id);
    }

    @Override
    public void createBook(Book book) {

        dao.createBook(book);

    }

    @Override
    public void updateBook(Book book) {

        dao.updateBook(book);

    }

    @Override
    public void deleteBook(int id) {

        dao.deleteBook(id);

    }

    @Override
    public Book loadBookByTitle(String title) throws BookNotFoundException, DataAccessException {
        return null;
    }
}
