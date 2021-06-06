package tr.com.ifikirli.sbrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tr.com.ifikirli.sbrestapi.model.Customer;
import tr.com.ifikirli.sbrestapi.response.CustomResponse;
import tr.com.ifikirli.sbrestapi.service.CustomerService;

abstract public class BaseController {

    @Autowired
    private CustomerService customerService;

    public <T>ResponseEntity<CustomResponse<T>> renderOk() {

        return new ResponseEntity<>(new CustomResponse<>("OK"), HttpStatus.OK);
    }

    public <T>ResponseEntity<CustomResponse<T>> renderResponse(T data) {

        return new ResponseEntity<>(new CustomResponse<>(data), HttpStatus.OK);
    }

    public Customer getCustomer(String email){

        return customerService.findCustomerByEmail(email);
    }
}
