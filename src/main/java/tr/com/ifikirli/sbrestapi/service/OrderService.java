package tr.com.ifikirli.sbrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.ifikirli.sbrestapi.enumaration.OrderStatus;
import tr.com.ifikirli.sbrestapi.exception.BusinessException;
import tr.com.ifikirli.sbrestapi.model.Book;
import tr.com.ifikirli.sbrestapi.model.Customer;
import tr.com.ifikirli.sbrestapi.model.Order;
import tr.com.ifikirli.sbrestapi.model.OrderProduct;
import tr.com.ifikirli.sbrestapi.repository.OrderRepository;
import tr.com.ifikirli.sbrestapi.request.OrderProductRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookService bookService;

    public String makeOrder(List<OrderProductRequest> orderProductRequests, Customer customer) {

        List<Book> books = bookService.getBooksByIds(orderProductRequests.stream().map(OrderProductRequest::getBookId).collect(Collectors.toList()));

        if(books.size() < orderProductRequests.size())
            throw new BusinessException("There may be invalid books in basket.");

        List<OrderProduct> orderProducts = new ArrayList<>();

        for(Book book : books){

            if(book.getStock() == 0)
                throw new BusinessException("Book stock is 0. Id is : "+ book.getId());

            OrderProductRequest orderProductRequest = orderProductRequests.stream().filter(_orderProductRequest-> _orderProductRequest.getBookId().equals(_orderProductRequest.getBookId())).findFirst().orElse(null);

            if(orderProductRequest == null)
                throw new BusinessException("There may be invalid books in basket.");

            if(orderProductRequest.getCount() > book.getStock())
                throw new BusinessException("Book stock is insufficient. Id is : "+ book.getId());

            bookService.updateStock(book.getId(), book.getStock() - orderProductRequest.getCount());
            orderProducts.add(new OrderProduct(book.getPrice(), book.getId(), orderProductRequest.getCount()));
        }

        Order order = new Order(OrderStatus.WAITING.name(), orderProducts, customer);
        orderRepository.insert(order);
        return order.getId();
    }

    public Order getOrderDetail(String orderId) {

        Order order = orderRepository.findById(orderId).orElseThrow(() -> new BusinessException("Invalid order id : " + orderId));
        List<Book> books = bookService.getBooksByIds(order.getOrderProducts().stream().map(OrderProduct::getBookId).collect(Collectors.toList()));

        for(OrderProduct orderProduct : order.getOrderProducts()) {

            orderProduct.setBookName(Objects.requireNonNull(books.stream().filter(it -> it.getId().equals(orderProduct.getBookId())).findFirst().orElse(null)).getName());
        }

        return order;
    }

    public void cancelOrder(String orderId) {

        Order order = orderRepository.findById(orderId).orElseThrow(() -> new BusinessException("Invalid order id : " + orderId));

        if(order.getStatus().equals(OrderStatus.CANCELLED.name()))
            throw new BusinessException("Order was already cancelled.");

        order.setStatus(OrderStatus.CANCELLED.name());
        orderRepository.save(order);

        for(OrderProduct orderProduct : order.getOrderProducts()) {

            bookService.incrementStock(orderProduct.getBookId(), orderProduct.getCount());
        }
    }

    public List<Order> listOrderByDateInterval(Date startDate, Date endDate) {

        return orderRepository.findAllByCreatedDateBetweenAndStatusIsNot(startDate, endDate, OrderStatus.CANCELLED.name());
    }
}
