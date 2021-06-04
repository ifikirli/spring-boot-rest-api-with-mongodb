package tr.com.ifikirli.sbrestapi.interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import tr.com.ifikirli.sbrestapi.exception.TokenException;
import tr.com.ifikirli.sbrestapi.util.AuthUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private AuthUtil authUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String authHeader = request.getHeader("X-Authorization") != null ? request.getHeader("X-Authorization") : request.getHeader("Authorization") != null ? request.getHeader("Authorization") : null;

        if(authHeader == null)
            throw new TokenException("Token does not exist in header");

        else {

            DecodedJWT decodedJWT = authUtil.verifyToken(authHeader);
            request.setAttribute("username", decodedJWT.getSubject());
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
    }
}
