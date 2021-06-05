package tr.com.ifikirli.sbrestapi.helper;

import org.springframework.data.domain.Page;
import tr.com.ifikirli.sbrestapi.model.Customer;
import tr.com.ifikirli.sbrestapi.model.Order;

public class CustomerOrderModel {

    Customer customer;
    Page<Order> paginatedOrders;

    public CustomerOrderModel(Customer customer, Page<Order> paginatedOrders) {
        this.customer = customer;
        this.paginatedOrders = paginatedOrders;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Page<Order> getPaginatedOrders() {
        return paginatedOrders;
    }

    public void setPaginatedOrders(Page<Order> paginatedOrders) {
        this.paginatedOrders = paginatedOrders;
    }
}
