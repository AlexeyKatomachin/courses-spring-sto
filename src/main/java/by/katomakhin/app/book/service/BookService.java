package by.katomakhin.app.book.service;


import by.katomakhin.app.book.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Override
    public Long addBook(Book book) {
        return null;
    }

    @Override
    public Book updateBook(Book book) {
        return null;
    }

    @Override
    public void deleteBook(Long id) {

    }

    @Override
    public List<Book> books() {
        return null;
    }
}
