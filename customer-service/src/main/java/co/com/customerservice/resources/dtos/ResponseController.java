package co.com.customerservice.resources.dtos;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseController<T> {

    private T data;
    private List<ErrorResponseMessage> errors;

    public ResponseController(T data){
        this.data = data;
        this.errors = new ArrayList<>();
    }
}


