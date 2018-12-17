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
    private ErrorResponseMessage error;

    public ResponseController(T data){
        this.data = data;
        this.error = null;
    }
}


