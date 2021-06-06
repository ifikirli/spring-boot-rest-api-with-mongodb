package tr.com.ifikirli.sbrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class SbrestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbrestapiApplication.class, args);
    }

}
