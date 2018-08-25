package net.proselyte.springmvc.dao;

import net.proselyte.springmvc.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import java.util.List;




public class bookDAOimpl implements DAO {


    private static SessionFactory sessionFactory;

/*
    static {
        try {
            StandardServiceRegistry standardRegistry =
                    new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metaData =
                    new MetadataSources(standardRegistry).getMetadataBuilder().build();
            sessionFactory = metaData.getSessionFactoryBuilder().build();
        } catch (Throwable th) {
            System.err.println("Enitial SessionFactory creation failed" + th);
            throw new ExceptionInInitializerError(th);
        }
    }
*/

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Book fingBookById(int id) {

        Session session = this.sessionFactory.getCurrentSession();

        Book book = (Book) session.load(Book.class, new Integer(id));

        return book;
    }

    @Override
    public void createBook(Book book) {

        Session session = this.sessionFactory.getCurrentSession();

        session.persist(book);

    }

    @Override
    public void updateBook(Book book) {

        Session session = this.sessionFactory.getCurrentSession();

        session.update(book);

    }

    @Override
    public void deleteBook(int id) {

        Session session = this.sessionFactory.getCurrentSession();

   Book book = (Book) session.load(Book.class, new Integer(id));

   if (book!=null){

       session.delete(book);
   }
    }

    @Override
    public List<Book> getAllBooks() {

        Session session = this.sessionFactory.getCurrentSession();

        List<Book> books = session.createQuery("from Book").list();



        return books;
    }
}
