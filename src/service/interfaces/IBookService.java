package service.interfaces;

import models.Book;

public interface IBookService extends IBaseService<Book> {
    Book getByISBN(String isbn);
}
