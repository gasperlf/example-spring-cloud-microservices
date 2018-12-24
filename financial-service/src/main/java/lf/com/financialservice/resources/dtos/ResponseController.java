package lf.com.financialservice.resources.dtos;

import lombok.*;

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


