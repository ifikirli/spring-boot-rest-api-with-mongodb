package tr.com.ifikirli.sbrestapi.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
@Validated
public class BookController extends BaseController {
}
