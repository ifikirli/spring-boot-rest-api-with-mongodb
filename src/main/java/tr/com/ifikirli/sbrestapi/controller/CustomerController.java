package tr.com.ifikirli.sbrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tr.com.ifikirli.sbrestapi.dto.CustomerOrderDto;
import tr.com.ifikirli.sbrestapi.dto.DetailedCustomerDto;
import tr.com.ifikirli.sbrestapi.helper.CustomerOrderModel;
import tr.com.ifikirli.sbrestapi.model.Customer;
import tr.com.ifikirli.sbrestapi.request.CustomerRegisterRequest;
import tr.com.ifikirli.sbrestapi.response.CustomResponse;
import tr.com.ifikirli.sbrestapi.service.CustomerService;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("customer")
@Validated
public class CustomerController extends BaseController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/register")
    public ResponseEntity<CustomResponse<String>> register(@Valid @RequestBody CustomerRegisterRequest customerRegisterModel) {

        customerService.register(customerRegisterModel, false);
        return renderOk();
    }

    @GetMapping
    public ResponseEntity<CustomResponse<List<DetailedCustomerDto>>> findAll() {

        List<Customer> customers = customerService.findAll();
        return renderResponse(DetailedCustomerDto.convertFromCustomers(customers));
    }

    @GetMapping("/getAllCustomerOrders")
    public ResponseEntity<CustomResponse<CustomerOrderDto>> getAllCustomerOrders(@RequestAttribute("username") String username,
                                                                                 @Min(value = 0, message = "page param min value must be 0") @RequestParam(defaultValue = "0") int page,
                                                                                 @Max(value = 100, message = "page size max value must be 100") @RequestParam(defaultValue = "10") int size) {

        CustomerOrderModel customerOrderModel = customerService.getAllCustomerOrders(username, page, size);
        return renderResponse(new CustomerOrderDto(customerOrderModel));
    }
}
