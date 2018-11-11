package co.com.customerservice.resources.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponseMessage {
    private String code;
    private String message;
    private String type;
}