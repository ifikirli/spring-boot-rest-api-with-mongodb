package tr.com.ifikirli.sbrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.ifikirli.sbrestapi.request.CustomerRegisterRequest;
import tr.com.ifikirli.sbrestapi.response.CustomResponse;
import tr.com.ifikirli.sbrestapi.service.CustomerService;

import javax.validation.Valid;

@RestController
@RequestMapping("administrator")
@Validated
public class AdministratorController extends BaseController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/register")
    public ResponseEntity<CustomResponse<String>> register(@Valid @RequestBody CustomerRegisterRequest customerRegisterModel) {

        customerService.register(customerRegisterModel, true);
        return renderOk();
    }
}
