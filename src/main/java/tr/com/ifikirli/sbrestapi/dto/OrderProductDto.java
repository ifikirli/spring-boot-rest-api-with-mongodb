package tr.com.ifikirli.sbrestapi.dto;

import tr.com.ifikirli.sbrestapi.model.OrderProduct;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderProductDto {

    BigDecimal unitPrice;
    int count;
    BigDecimal totalPrice;
    String bookName;

    public OrderProductDto(OrderProduct orderProduct) {

        this.unitPrice = orderProduct.getUnitPrice();
        this.count = orderProduct.getCount();
        this.totalPrice = orderProduct.getTotalPrice();
        this.bookName = orderProduct.getBookName();
    }

    public static List<OrderProductDto> convertFromOrderProducts(List<OrderProduct> orderProducts) {

        List<OrderProductDto> result = new ArrayList<>();

        for(OrderProduct orderProduct : orderProducts) {

            result.add(new OrderProductDto(orderProduct));
        }

        return result;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
