package tr.com.ifikirli.sbrestapi.dto;

public class BaseDto {

    String id;

    public BaseDto(String id) {

        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
