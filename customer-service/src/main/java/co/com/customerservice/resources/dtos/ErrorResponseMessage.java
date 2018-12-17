package co.com.customerservice.resources.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ErrorResponseMessage {
    private String code;
    private String message;
    private String type;
}