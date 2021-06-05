package tr.com.ifikirli.sbrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.ifikirli.sbrestapi.exception.BusinessException;
import tr.com.ifikirli.sbrestapi.helper.JwtTokenModel;
import tr.com.ifikirli.sbrestapi.model.Customer;
import tr.com.ifikirli.sbrestapi.request.SignInRequest;
import tr.com.ifikirli.sbrestapi.util.AuthUtil;

import java.util.Arrays;

@Service
public class AuthService {

    @Autowired
    CustomerService customerService;

    @Autowired
    private AuthUtil authUtil;

    public JwtTokenModel signIn(SignInRequest signInRequest) {

        Customer customer = customerService.findCustomerByEmail(signInRequest.getEmail());

        if (customer != null && Arrays.equals(customer.getPassword().getData(), AuthUtil.generatePassword(signInRequest.getPassword(), customer.getSalt().getData())))
            return new JwtTokenModel(authUtil.createAccessToken(signInRequest.getEmail()), authUtil.createRefreshToken(signInRequest.getEmail()));

        throw new BusinessException("Email address or password is not correct.");
    }
}
