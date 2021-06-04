package tr.com.ifikirli.sbrestapi.response;

import tr.com.ifikirli.sbrestapi.exception.ValidationError;

import java.util.List;

public class CustomResponse<T> {

    private T data;
    private String message;
    private List<ValidationError> validationError;

    public CustomResponse(T data, String message, List<ValidationError> validationError) {

        this.data = data;
        this.message = message;
        this.validationError = validationError;
    }

    public CustomResponse(String message, List<ValidationError> validationError) {

        this.message = message;
        this.validationError = validationError;
    }

    public CustomResponse(T data) {

        this.data = data;
    }

    public CustomResponse(String message) {

        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ValidationError> getValidationError() {
        return validationError;
    }

    public void setValidationError(List<ValidationError> validationError) {
        this.validationError = validationError;
    }
}
