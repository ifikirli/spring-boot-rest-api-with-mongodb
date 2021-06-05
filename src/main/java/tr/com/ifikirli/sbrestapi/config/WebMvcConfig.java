package tr.com.ifikirli.sbrestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tr.com.ifikirli.sbrestapi.interceptor.AuthenticationInterceptor;
import tr.com.ifikirli.sbrestapi.interceptor.AuthorizationInterceptor;
import tr.com.ifikirli.sbrestapi.interceptor.LoggingInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public AuthenticationInterceptor getAuthInterceptor() {
        return new AuthenticationInterceptor();
    }

    @Bean
    public LoggingInterceptor getLoggingInterceptor() {
        return new LoggingInterceptor();
    }

    @Bean
    public AuthorizationInterceptor getAuthorizationInterceptor() {
        return new AuthorizationInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(getLoggingInterceptor()).excludePathPatterns("/error/**");
        registry.addInterceptor(getAuthInterceptor()).excludePathPatterns("/customer/register", "/administrator/register", "/auth/signIn");
        registry.addInterceptor(getAuthorizationInterceptor()).addPathPatterns("/book/**", "/statistics/**");
    }
}