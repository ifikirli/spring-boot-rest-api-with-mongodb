package tr.com.ifikirli.sbrestapi.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document("orders")
public class Order extends BaseModel {

    Customer customer;
    String status;
    BigDecimal totalPrice;
    List<OrderProduct> orderProducts;

    public Order(String status, List<OrderProduct> orderProducts, Customer customer) {

        super();
        this.status = status;
        this.orderProducts = orderProducts;
        this.customer = customer;
        calculateTotalPrice(orderProducts);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private void calculateTotalPrice(List<OrderProduct> orderProducts) {

        BigDecimal _totalPrice = BigDecimal.ZERO;

        for(OrderProduct orderProduct : orderProducts) {

            _totalPrice = orderProduct.totalPrice.add(_totalPrice);
        }

        this.totalPrice = _totalPrice;
    }
}
