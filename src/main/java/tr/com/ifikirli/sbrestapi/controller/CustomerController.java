package tr.com.ifikirli.sbrestapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.ifikirli.sbrestapi.model.CustomerRegisterModel;
import tr.com.ifikirli.sbrestapi.response.CustomResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("customer")
@Validated
public class CustomerController extends BaseController {

    @PostMapping(path = "/register")
    public ResponseEntity<CustomResponse<String>> register(@Valid @RequestBody CustomerRegisterModel customerRegisterModel) {

        return renderOk();
    }
}
