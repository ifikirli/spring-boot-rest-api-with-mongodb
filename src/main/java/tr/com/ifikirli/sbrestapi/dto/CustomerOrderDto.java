package tr.com.ifikirli.sbrestapi.dto;

import tr.com.ifikirli.sbrestapi.helper.CustomerOrderModel;

import java.util.List;

public class CustomerOrderDto {

    CustomerDto customer;
    List<BaseOrderDto> orders;
    int currentPage;
    long totalOrderItems;
    int totalPages;

    public CustomerOrderDto(CustomerOrderModel customerOrderModel) {

        this.customer = new CustomerDto(customerOrderModel.getCustomer());
        this.orders = BaseOrderDto._convertFromOrders(customerOrderModel.getPaginatedOrders().getContent());
        this.currentPage = customerOrderModel.getPaginatedOrders().getNumber();
        this.totalOrderItems = customerOrderModel.getPaginatedOrders().getTotalElements();
        this.totalPages = customerOrderModel.getPaginatedOrders().getTotalPages();
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public List<BaseOrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<BaseOrderDto> orders) {
        this.orders = orders;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalOrderItems() {
        return totalOrderItems;
    }

    public void setTotalOrderItems(long totalOrderItems) {
        this.totalOrderItems = totalOrderItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
