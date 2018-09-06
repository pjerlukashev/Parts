package net.proselyte.springmvc.model;


import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.*;

@Entity
@Proxy(lazy=false)
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   @Length(min=2,max = 40)
    private  String title;

    private String description;

    private  String author;

    private  String isbn;

    private int printYear;

    private int readAlready;

    public void setId(int id) {
        this.id = id;
    }

    public Book(int id, String title, String description, String author, String isbn, int printYear, int readAlready) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.isbn = isbn;
        this.printYear = printYear;
        this.readAlready = readAlready;
    }

    public Book(){}

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrintYear() {
        return printYear;
    }

    public void setPrintYear(int printYear) {
        this.printYear = printYear;
    }

    public int getReadAlready() {
        return readAlready;
    }

    public void setReadAlready(int readAlready) {
        this.readAlready = readAlready;
    }
}
