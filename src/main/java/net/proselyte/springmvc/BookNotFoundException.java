package net.proselyte.springmvc;

public class BookNotFoundException extends Exception {

    public BookNotFoundException(String message) {
        super(message);
    }
}
