package net.proselyte.springmvc.service;

import net.proselyte.springmvc.BookNotFoundException;
import net.proselyte.springmvc.dao.DAO;
import net.proselyte.springmvc.dao.bookDAOimpl;
import net.proselyte.springmvc.model.Book;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class bookServiceImpl implements Service {


private DAO bookDAOimpl;

    public void setBookDAOimpl(DAO bookDAOimpl) {
        this.bookDAOimpl = bookDAOimpl;
    }

    @Override

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public List<Book> getAllBooks() {
        return bookDAOimpl.getAllBooks();
    }

    @Override

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Book fingBookById(int id) {
        return bookDAOimpl.fingBookById(id);
    }

    @Override

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void createBook(Book book) {
       bookDAOimpl.createBook(book);
    }

    @Override

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateBook(Book book) {

        bookDAOimpl.updateBook(book);

    }

    @Override

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteBook(int id) {

        bookDAOimpl.deleteBook(id);

    }

    @Override
    public Book loadBookByTitle(String title) throws BookNotFoundException, DataAccessException {
      return   bookDAOimpl.findBookByTitle(title);
    }
}
