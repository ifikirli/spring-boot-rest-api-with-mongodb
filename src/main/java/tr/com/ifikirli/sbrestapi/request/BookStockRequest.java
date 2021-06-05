package tr.com.ifikirli.sbrestapi.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BookStockRequest {

    @NotNull(message = "Stock must not be empty.")
    @Min(value = 0 , message = "Stock min value must be 0.")
    @Max(value = 1000 , message = "Stock max value must be 1000.")
    private int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
