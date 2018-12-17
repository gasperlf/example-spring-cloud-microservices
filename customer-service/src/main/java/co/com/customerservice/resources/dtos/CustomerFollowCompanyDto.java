package co.com.customerservice.resources.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CustomerFollowCompanyDto {

    @NotNull
    private Integer customerId;

    @NotNull
    private String company;

}
