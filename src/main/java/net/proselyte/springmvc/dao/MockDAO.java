package net.proselyte.springmvc.dao;

import net.proselyte.springmvc.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockDAO implements DAO {

    Map<Integer, Book> mockDataBase = new HashMap<Integer, Book>();

    @Override
    public Book fingBookById(int id) {
        return mockDataBase.get(id);
    }

    @Override
    public void createBook(Book book) {

        if(!mockDataBase.containsKey(book.getId())) {
            mockDataBase.put(book.getId(), book);
        }

    }

    @Override
    public void updateBook(Book book) {

        if(mockDataBase.containsKey(book.getId())) {
            mockDataBase.put(book.getId(), book);
        }

    }

    @Override
    public void deleteBook(int id) {

        mockDataBase.remove(id);
    }

    @Override
    public List<Book> getAllBooks() {

        List<Book> books = new ArrayList<Book>();

        for(Map.Entry<Integer, Book> entry: mockDataBase.entrySet()){

            books.add(entry.getValue());
        }

        return books;
    }

    @Override
    public Book findBookByTitle(String name) {
        return null;
    }


}
