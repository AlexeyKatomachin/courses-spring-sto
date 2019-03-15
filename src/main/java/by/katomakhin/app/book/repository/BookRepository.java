package by.katomakhin.app.book.repository;

import by.katomakhin.app.book.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {
    private static final Map<Long, Book> storage = new HashMap<>();
    private static Long id = 0L;

    static  {
        storage.put(id, new Book(id, "Book 1", "About book 1"));
        id ++;
        storage.put(id, new Book(id, "Book 2", "About book 2"));
        id ++;
    }

    public Book save(Book book) {
        Book value = new Book(id, book.getName() + "_Stored", book.getDescription());
        storage.put(id, value);
        book.setId(id);
        id++;
        return book;
    }

    public Book update(Book book) {
        return save(book);
    }

    public boolean existsById(Long id) {
        return storage.containsKey(id);
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }

    public void deleteByIdWithoutEvict(Long id) {
        storage.remove(id);
    }

    public Book findById(Long id) {
        return storage.get(id);
    }

    public Book findByIdWithout(Long id) {
        return storage.get(id);
    }

    public List<Book> books() {
        return new ArrayList<>(storage.values());
    }
}
