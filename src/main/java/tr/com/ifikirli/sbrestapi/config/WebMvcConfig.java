package tr.com.ifikirli.sbrestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tr.com.ifikirli.sbrestapi.interceptor.AuthInterceptor;
import tr.com.ifikirli.sbrestapi.interceptor.LoggingInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public AuthInterceptor getAUthInterceptor() {
        return new AuthInterceptor();
    }

    @Bean
    public LoggingInterceptor getLoggingInterceptor() {
        return new LoggingInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(getLoggingInterceptor()).excludePathPatterns("/error/**");
        registry.addInterceptor(getAUthInterceptor()).excludePathPatterns("/customer/register", "/auth/signIn");
    }
}