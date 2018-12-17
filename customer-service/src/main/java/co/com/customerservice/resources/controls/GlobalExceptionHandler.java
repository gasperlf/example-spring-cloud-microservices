package co.com.customerservice.resources.controls;

import co.com.customerservice.exceptions.DataNotFoundException;
import co.com.customerservice.exceptions.ValidationDataException;
import co.com.customerservice.resources.dtos.ErrorResponseMessage;
import co.com.customerservice.resources.dtos.ResponseController;
import co.com.customerservice.resources.dtos.TypeMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException ex) {

        return ResponseEntity.badRequest().body(ResponseController.builder().error(ErrorResponseMessage.builder()
                .message(ex.getMessage())
                .type(TypeMessage.DATA.getType())
                .code(ex.getCode())
                .build()).build());
    }

    @ExceptionHandler(ValidationDataException.class)
    public ResponseEntity<Object> handleValidationDataException(ValidationDataException ex) {

        return ResponseEntity.badRequest().body(ResponseController.builder().error(ErrorResponseMessage.builder()
                .message(ex.getMessage())
                .type(TypeMessage.DATA.getType())
                .code(ex.getCode())
                .build()).build());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        return ResponseEntity.status(status).body(ResponseController.builder().error(ErrorResponseMessage.builder()
                .message(ex.getMessage())
                .type(TypeMessage.SYSTEM.getType())
                .code("NAN")
                .build()));
    }
}
