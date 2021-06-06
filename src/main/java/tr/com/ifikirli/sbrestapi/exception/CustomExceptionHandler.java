package tr.com.ifikirli.sbrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tr.com.ifikirli.sbrestapi.response.CustomResponse;

import javax.validation.ConstraintViolationException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<CustomResponse<String>> handleBadRequest(MethodArgumentNotValidException methodArgumentNotValidException) {

        List<ValidationError> validationErrors = new ArrayList<>();

        for(FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {

            validationErrors.add(new ValidationError(fieldError.getField(), fieldError.getDefaultMessage()));
        }

        return new ResponseEntity<>(new CustomResponse<>("Bad Request", validationErrors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<CustomResponse<String>> handleConstraintViolationException(ConstraintViolationException constraintViolationException) {

        return new ResponseEntity<>(new CustomResponse<>(constraintViolationException.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({TokenException.class})
    public ResponseEntity<CustomResponse<String>> handleTokenException(TokenException tokenException) {

        return new ResponseEntity<>(new CustomResponse<>(tokenException.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<CustomResponse<String>> handleBusinessException(BusinessException businessException) {

        return new ResponseEntity<>(new CustomResponse<>(businessException.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({AuthorizationException.class})
    public ResponseEntity<CustomResponse<String>> handleAuthorizationException(AuthorizationException authorizationException) {

        return new ResponseEntity<>(new CustomResponse<>(authorizationException.getMessage()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({ParseException.class})
    public ResponseEntity<CustomResponse<String>> handleParseException(ParseException parseException) {

        return new ResponseEntity<>(new CustomResponse<>(parseException.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}