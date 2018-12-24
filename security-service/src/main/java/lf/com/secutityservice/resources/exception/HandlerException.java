/*
package lf.com.secutityservice.resources.exception;

import lf.com.secutityservice.resources.dto.Error;
import lf.com.secutityservice.resources.dto.ResponseController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public Mono<ResponseEntity<ResponseController<?>>> exceptionHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException e){
        List<Error> errors = new ArrayList<>();
        Error error = new Error("",e.getMessage());
        errors.add(error);
        return  Mono.just(ResponseEntity.badRequest().body(new ResponseController(errors)));
    }
}
*/
