package tr.com.ifikirli.sbrestapi.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.setAttribute("requestStartTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {

        long requestStartTime = Long.parseLong(request.getAttribute("requestStartTime").toString());
        long elapsedTime = System.currentTimeMillis() - requestStartTime;
        String username = request.getAttribute("username") != null ? request.getAttribute("username").toString() : null;

        logger.info("User : {}, Request : {}, Status : {}, Elapsed Time : {} ms", username != null ? username : "anonim", request.getRequestURI(), response.getStatus(), elapsedTime);
    }
}
