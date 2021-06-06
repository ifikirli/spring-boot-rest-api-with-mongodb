package tr.com.ifikirli.sbrestapi.request;

import javax.validation.constraints.*;

public class OrderProductRequest {

    @NotNull(message = "BookId must not be empty")
    private String bookId;

    @NotNull(message = "Book count must not be empty.")
    @Min(value = 1 , message = "Book count min value must be 1 to be ordered.")
    @Max(value = 10 , message = "Book count max value must be 10 to be ordered.")
    private int count;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
