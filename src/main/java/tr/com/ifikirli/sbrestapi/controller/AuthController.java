package tr.com.ifikirli.sbrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.ifikirli.sbrestapi.dto.JwtTokenDto;
import tr.com.ifikirli.sbrestapi.helper.JwtTokenModel;
import tr.com.ifikirli.sbrestapi.request.SignInRequest;
import tr.com.ifikirli.sbrestapi.response.CustomResponse;
import tr.com.ifikirli.sbrestapi.service.AuthService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "auth")
@Validated
public class AuthController extends BaseController {

    @Autowired
    private AuthService authService;

    @PostMapping(path = "/signIn")
    public ResponseEntity<CustomResponse<JwtTokenDto>> signIn(@Valid @RequestBody SignInRequest signInRequest) {

        JwtTokenModel jwtTokenModel = authService.signIn(signInRequest);
        return renderResponse(new JwtTokenDto(jwtTokenModel));
    }
}
