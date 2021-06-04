package tr.com.ifikirli.sbrestapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tr.com.ifikirli.sbrestapi.response.CustomResponse;

abstract public class BaseController {

    public ResponseEntity<CustomResponse<String>> renderOk() {

        return new ResponseEntity<>(new CustomResponse<>("OK"), HttpStatus.OK);
    }
}
