package tr.com.ifikirli.sbrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tr.com.ifikirli.sbrestapi.dto.BaseDto;
import tr.com.ifikirli.sbrestapi.dto.OrderDto;
import tr.com.ifikirli.sbrestapi.model.Order;
import tr.com.ifikirli.sbrestapi.request.OrderProductRequest;
import tr.com.ifikirli.sbrestapi.response.CustomResponse;
import tr.com.ifikirli.sbrestapi.service.OrderService;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("order")
@Validated
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<CustomResponse<BaseDto>> makeOrder(@Valid @RequestBody List<OrderProductRequest> orderProducts, @RequestAttribute("username") String username) {

        String orderId = orderService.makeOrder(orderProducts, getCustomer(username));
        return renderResponse(new BaseDto(orderId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<OrderDto>> getOrderDetail(@PathVariable(value = "id") String orderId){

        Order order = orderService.getOrderDetail(orderId);
        return renderResponse(new OrderDto(order));
    }

    @PutMapping("/cancelOrder/{id}")
    public ResponseEntity<CustomResponse<String>> cancelOrder(@PathVariable(value = "id") String orderId){

        orderService.cancelOrder(orderId);
        return renderOk();
    }

    @GetMapping
    public ResponseEntity<CustomResponse<List<OrderDto>>> listOrderByDateInterval(@RequestParam String startDate,
                                                                                  @RequestParam String endDate) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        List<Order> orders = orderService.listOrderByDateInterval(simpleDateFormat.parse(startDate), simpleDateFormat.parse(endDate));
        return renderResponse(OrderDto.convertFromOrders(orders));
    }
}
