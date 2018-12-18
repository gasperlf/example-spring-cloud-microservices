package co.com.financialservice.resources.controls;

import co.com.financialservice.resources.dtos.ErrorResponseMessage;
import co.com.financialservice.resources.dtos.ResponseController;
import co.com.financialservice.resources.dtos.TypeMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.status(status).body(ResponseController.builder().error(ErrorResponseMessage.builder()
                .message(ex.getMessage())
                .type(TypeMessage.SYSTEM.getType())
                .code("NAN")
                .build()));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.status(status).body(ResponseController.builder().error(ErrorResponseMessage.builder()
                .message(ex.getMessage())
                .type(TypeMessage.SYSTEM.getType())
                .code("NAN")
                .build()));
    }
}
