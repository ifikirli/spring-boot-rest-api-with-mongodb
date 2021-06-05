package tr.com.ifikirli.sbrestapi.request;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class BookRequest {

    @NotNull(message = "Name must not be empty")
    @Size(max = 255, min = 1, message = "Name length must be between 1 and 255.")
    private String name;

    @NotNull(message = "Stock must not be empty.")
    @Min(value = 0 , message = "Stock min value must be 0.")
    @Max(value = 1000 , message = "Stock max value must be 1000.")
    private int stock;

    @NotNull(message = "Price must not be empty")
    @DecimalMin(value = "5.00", inclusive = false, message = "Price min value must be 5.00")
    @DecimalMax(value = "1000.00", inclusive = false, message = "Price max value must be 1000.00")
    @Digits(integer=4, fraction=2)
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
