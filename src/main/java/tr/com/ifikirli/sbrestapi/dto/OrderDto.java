package tr.com.ifikirli.sbrestapi.dto;

import tr.com.ifikirli.sbrestapi.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDto extends BaseOrderDto {

    CustomerDto customer;

    public OrderDto(Order order) {

        super(order);
        this.customer = new CustomerDto(order.getCustomer());
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public static List<OrderDto> convertFromOrders(List<Order> orders) {

        List<OrderDto> result = new ArrayList<>();

        for (Order order : orders) {

            result.add(new OrderDto(order));
        }

        return result;
    }
}
