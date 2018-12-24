package lf.com.secutityservice.resources.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class ResponseController<T> {

    private T data;
    List<Error> errors;

    public ResponseController(T data){
        this.data = data;
        this.errors = new ArrayList<>();
    }

    public ResponseController(List<Error> errors){
        this.errors = errors;
    }
}
