package tr.com.ifikirli.sbrestapi.dto;

import tr.com.ifikirli.sbrestapi.model.Order;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BaseOrderDto extends BaseDto{

    String orderDate;
    String status;
    BigDecimal totalPrice;
    List<OrderProductDto> orderProducts;

    public BaseOrderDto(Order order) {

        super(order.getId());
        this.orderDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(order.getCreatedDate());
        this.status = order.getStatus();
        this.totalPrice = order.getTotalPrice();
        this.orderProducts = OrderProductDto.convertFromOrderProducts(order.getOrderProducts());
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
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

    public List<OrderProductDto> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProductDto> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public static List<BaseOrderDto> _convertFromOrders(List<Order> orders) {

        List<BaseOrderDto> result = new ArrayList<>();

        for (Order order : orders) {

            result.add(new BaseOrderDto(order));
        }

        return result;
    }
}
