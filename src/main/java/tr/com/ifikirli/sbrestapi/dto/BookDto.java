package tr.com.ifikirli.sbrestapi.dto;

import tr.com.ifikirli.sbrestapi.model.Book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookDto extends BaseDto{

    String name;
    BigDecimal price;
    int stock;

    public BookDto(Book book) {

        super(book.getId());
        this.name = book.getName();
        this.price = book.getPrice();
        this.stock = book.getStock();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static List<BookDto> convertFromBooks(List<Book> books) {

        List<BookDto> result = new ArrayList<>();

        for(Book book : books){

            result.add(new BookDto(book));
        }

        return result;
    }
}
