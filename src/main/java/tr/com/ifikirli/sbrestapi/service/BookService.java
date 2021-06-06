package tr.com.ifikirli.sbrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.ifikirli.sbrestapi.exception.BusinessException;
import tr.com.ifikirli.sbrestapi.model.Book;
import tr.com.ifikirli.sbrestapi.repository.BookRepository;
import tr.com.ifikirli.sbrestapi.request.BookRequest;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public String create(BookRequest bookRequest) {

        if(isNameUsed(bookRequest.getName()))
            throw new BusinessException("Name is already used by another book.");

        Book book = new Book(bookRequest.getName(), bookRequest.getPrice(), bookRequest.getStock());
        bookRepository.insert(book);
        return book.getId();
    }

    private boolean isNameUsed(String name) {

        Book book = bookRepository.findByName(name);
        return book != null;
    }

    public void updateStock(String bookId, int stock) {

        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BusinessException("Invalid book id : " + bookId));
        book.setStock(stock);
        bookRepository.save(book);
    }

    public List<Book> getBooksByIds(List<String> bookIds) {

        return (List<Book>) bookRepository.findAllById(bookIds);
    }

    public void incrementStock(String bookId, int increment) {

        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BusinessException("Invalid book id : " + bookId));
        book.setStock(book.getStock() + increment);
        bookRepository.save(book);
    }

    public List<Book> findAll() {

        return bookRepository.findAll();
    }
}
