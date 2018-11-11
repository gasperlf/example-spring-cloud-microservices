package co.com.customerservice.resources.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.Convert;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDto {

    private String name;
    private String lastName;
    @Email
    private String email;
    private String cellphoneNumber;

    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
}
