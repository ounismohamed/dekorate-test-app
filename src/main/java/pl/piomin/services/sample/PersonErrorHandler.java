package pl.piomin.services.sample;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class PersonErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleSMPError(HttpServletRequest request, Exception ex) {
        ErrorResponse res = new ErrorResponse("1.0", ex.getMessage());
        return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
