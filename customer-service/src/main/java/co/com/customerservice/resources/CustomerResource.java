package co.com.customerservice.resources;

import co.com.customerservice.datasource.entities.Customer;
import co.com.customerservice.datasource.entities.CustomerCompany;
import co.com.customerservice.resources.dtos.CustomerFollowCompanyDto;
import co.com.customerservice.resources.dtos.CustomerDto;
import co.com.customerservice.services.BusinessLogicCustomer;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Api(tags = "customers")
@RestController
@RequestMapping(path = "/v1/customers")
public class CustomerResource {

    private final BusinessLogicCustomer businessLogicCustomer;

    public CustomerResource(BusinessLogicCustomer businessLogicCustomer){
        this.businessLogicCustomer = businessLogicCustomer;
    }

    @PostMapping(path = "/new",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Mono<?>> registerCustomer(@Valid @RequestBody CustomerDto customer){
        businessLogicCustomer.save(new Customer(customer));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Flux<Customer>> findCustomerByName(@RequestParam (name = "name") String parameterValue){
        return ResponseEntity.ok(businessLogicCustomer.findCustomerByName(parameterValue));
    }

    @PostMapping(path = "/registerCustomerCompany", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Mono<?>> registerCustomerFollowCompany(@Valid @RequestBody CustomerFollowCompanyDto companyCustumerDto){
        Mono<CustomerCompany> customerCompany = Mono.justOrEmpty(new CustomerCompany(companyCustumerDto));
        businessLogicCustomer.save(customerCompany);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(path = "/search/customerCompany",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Flux<CustomerCompany>> findCustomerCompanyByCustomerId(@RequestParam (name = "customerId") Integer parameterValue){
        return ResponseEntity.ok(businessLogicCustomer.findCustomerCompanyByCustomerId(parameterValue));
    }
}
