package lf.com.secutityservice.resources.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Error {
    private String code;
    private String message;
}
