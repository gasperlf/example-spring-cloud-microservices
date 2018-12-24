package lf.com.customerservice.datasource.entities;

import lf.com.customerservice.resources.dtos.CustomerDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "cellphone_number")
    private String cellphoneNumber;

    public Customer(CustomerDto customerDto){
        this.name = customerDto.getName();
        this.lastName = customerDto.getLastName();
        this.email = customerDto.getEmail();
        this.cellphoneNumber = customerDto.getCellphoneNumber();
    }

}
