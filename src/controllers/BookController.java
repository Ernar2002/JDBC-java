package controllers;

import exceptions.AlreadyExistsException;
import models.Book;
import models.Student;
import service.interfaces.IBookService;

import java.util.List;

public class BookController {
    private final IBookService bookService;

    public BookController(IBookService bookService){
        this.bookService = bookService;
    }

    public void saveBook(Book book) throws AlreadyExistsException {
        Book bookFromDb = bookService.getByISBN(book.getIsbn());

        if(bookFromDb != null){
            throw new AlreadyExistsException("Book already exists");
        }

        bookService.save(book);
    }

    public Book getBookById(int id){
        return bookService.getById(id);
    }

    public Book getByISBN(String isbn){
        return bookService.getByISBN(isbn);
    }

    public List<Book> getAllBooks(){
        return bookService.getAll();
    }
}
