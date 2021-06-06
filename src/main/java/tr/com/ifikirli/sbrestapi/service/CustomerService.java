package tr.com.ifikirli.sbrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tr.com.ifikirli.sbrestapi.helper.CustomerOrderModel;
import tr.com.ifikirli.sbrestapi.model.Customer;
import tr.com.ifikirli.sbrestapi.exception.BusinessException;
import tr.com.ifikirli.sbrestapi.model.Order;
import tr.com.ifikirli.sbrestapi.repository.OrderRepository;
import tr.com.ifikirli.sbrestapi.request.CustomerRegisterRequest;
import tr.com.ifikirli.sbrestapi.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    public void register(CustomerRegisterRequest customerRegisterModel, boolean isAdministrator) {

        if (isEmailUsed(customerRegisterModel.getEmail()))
            throw new BusinessException("Email already is used by another");

        Customer customer = new Customer(customerRegisterModel.getEmail(), customerRegisterModel.getName(), customerRegisterModel.getSurname(), isAdministrator);
        customer.setBinaryFields(customerRegisterModel.getPassword());

        customerRepository.insert(customer);
    }

    private boolean isEmailUsed(String email) {

        Customer customer = findCustomerByEmail(email);
        return customer != null;
    }

    public Customer findCustomerByEmail(String email) {

        return customerRepository.findByEmail(email);
    }

    public boolean isAdministrator(String email) {

        Customer customer = findCustomerByEmail(email);
        return customer != null && customer.isAdministrator();
    }

    public List<Customer> findAll() {

        return customerRepository.findAll();
    }

    public CustomerOrderModel getAllCustomerOrders(String email, int page, int size) {

        Customer customer = findCustomerByEmail(email);

        if(customer == null)
            throw new BusinessException("Invalid customer");

        Page<Order> paginatedOrders = orderRepository.findAllByCustomerId(customer.getId(), PageRequest.of(page, size, Sort.by("createdDate").descending()));

        return new CustomerOrderModel(customer, paginatedOrders);
    }
}
