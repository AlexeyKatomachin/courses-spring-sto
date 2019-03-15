package by.katomakhin.app.book.service;

import by.katomakhin.app.book.model.Book;

import java.util.List;

public interface IBookService {
    Long addBook(Book book);

    Book updateBook(Book book);

    void deleteBook(Long id);

    List<Book> books();
}
