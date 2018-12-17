package co.com.customerservice.datasource.entities;

import co.com.customerservice.resources.dtos.CustomerFollowCompanyDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customer_company")
public class CustomerCompany extends AuditableEntity<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "customer_id")
    private Integer customerId;

    @NotNull
    @Column(name = "company")
    private String company;

    @NotNull
    @Column(name = "start_date")
    private LocalDateTime startDate;

    @NotNull
    @Column(name = "state")
    private Boolean state;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    public CustomerCompany(CustomerFollowCompanyDto customerFollowCompanyDto){
        this.company = customerFollowCompanyDto.getCompany().toUpperCase();
        this.customerId = customerFollowCompanyDto.getCustomerId();
        this.startDate = LocalDateTime.now();
        this.state = true;
    }
}
