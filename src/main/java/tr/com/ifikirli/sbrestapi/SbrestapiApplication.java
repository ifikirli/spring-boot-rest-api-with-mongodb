package tr.com.ifikirli.sbrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import tr.com.ifikirli.sbrestapi.config.JwtProperties;

@SpringBootApplication
public class SbrestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbrestapiApplication.class, args);
    }

}
