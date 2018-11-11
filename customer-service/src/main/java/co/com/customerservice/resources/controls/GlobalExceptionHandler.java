package co.com.customerservice.resources.controls;

import co.com.customerservice.exceptions.DataNotFoundException;
import co.com.customerservice.resources.dtos.ErrorResponseMessage;
import co.com.customerservice.resources.dtos.ResponseController;
import co.com.customerservice.resources.dtos.TypeMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Mono<ResponseEntity<ResponseController>> handledHttpMessageNotReadableException(HttpMessageNotReadableException e) {

        ErrorResponseMessage error = new ErrorResponseMessage();
        error.setMessage(e.getMessage());
        error.setType(TypeMessage.SYSTEM.getType());
        List<ErrorResponseMessage> errors = new ArrayList<>();
        errors.add(error);
        return Mono.just(ResponseEntity.badRequest().body(ResponseController.builder().errors(errors).build()));
    }

    @ExceptionHandler(DataNotFoundException.class)
    public Mono<ResponseEntity<ResponseController>> handleDataNotFoundException(DataNotFoundException e){

        ErrorResponseMessage error = new ErrorResponseMessage();
        error.setCode(e.getCode());
        error.setMessage(e.getMessage());
        error.setType(TypeMessage.DATA.getType());
        List<ErrorResponseMessage> errors = new ArrayList<>();
        errors.add(error);
        return Mono.just(ResponseEntity.badRequest().body(ResponseController.builder().errors(errors).build()));
    }
}
