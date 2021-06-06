package tr.com.ifikirli.sbrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tr.com.ifikirli.sbrestapi.dto.BaseDto;
import tr.com.ifikirli.sbrestapi.dto.BookDto;
import tr.com.ifikirli.sbrestapi.model.Book;
import tr.com.ifikirli.sbrestapi.request.BookRequest;
import tr.com.ifikirli.sbrestapi.request.BookStockRequest;
import tr.com.ifikirli.sbrestapi.response.CustomResponse;
import tr.com.ifikirli.sbrestapi.service.BookService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("book")
@Validated
public class BookController extends BaseController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<CustomResponse<BaseDto>> create(@Valid @RequestBody BookRequest bookRequest) {

        String bookId = bookService.create(bookRequest);
        return renderResponse(new BaseDto(bookId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse<String>> updateStock(@PathVariable(value = "id") String bookId,
                                                              @Valid @RequestBody BookStockRequest bookStockRequest) {

        bookService.updateStock(bookId, bookStockRequest.getStock());
        return renderOk();
    }

    @GetMapping
    public ResponseEntity<CustomResponse<List<BookDto>>> findAll() {

        List<Book> books = bookService.findAll();
        return renderResponse(BookDto.convertFromBooks(books));
    }
}
