package tr.com.ifikirli.sbrestapi.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidUtil {

    public static String generateUuid() {

        return UUID.randomUUID().toString();
    }
}
