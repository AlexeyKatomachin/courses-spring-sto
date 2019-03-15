package by.katomakhin.app.book.controller;

import by.katomakhin.app.book.model.Book;
import by.katomakhin.app.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@Component
@WebService(serviceName = "BookWebService")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @WebMethod
    public Long createBook(Book book){
        return bookService.addBook(book);
    }

    @WebMethod
    public Book updateBook(Book book){
        return bookService.updateBook(book);
    }

    @WebMethod
    public void deleteBook(Long id){
        bookService.deleteBook(id);
    }

    @WebMethod
    public List<Book> books(){
        return bookService.books();
    }
}
