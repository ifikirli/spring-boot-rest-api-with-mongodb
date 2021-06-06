package tr.com.ifikirli.sbrestapi.model;

import java.math.BigDecimal;

public class OrderProduct {

    BigDecimal unitPrice;
    String bookId;
    int count;
    BigDecimal totalPrice;
    String bookName;

    public OrderProduct(BigDecimal unitPrice, String bookId, int count) {

        this.unitPrice = unitPrice;
        this.bookId = bookId;
        this.count = count;
        this.totalPrice = unitPrice.multiply(new BigDecimal(count));
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
