package co.com.customerservice.resources;

import co.com.customerservice.datasource.entities.Customer;
import co.com.customerservice.resources.dtos.CustomerDto;
import co.com.customerservice.resources.dtos.ResponseController;
import co.com.customerservice.services.BusunessLogicCustomer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "/v1/customers")
public class CustomerResource {

    private final BusunessLogicCustomer busunessLogicCustomer;

    public CustomerResource(BusunessLogicCustomer busunessLogicCustomer){
        this.busunessLogicCustomer = busunessLogicCustomer;
    }

    @PostMapping(path = "/new",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void registerCustomer(@Valid @RequestBody CustomerDto customer){
        busunessLogicCustomer.save(new Customer(customer));
    }

    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<ResponseController<List<Customer>>> findCustomerByName(@RequestParam (name = "name") String parameterName){
        List<Customer> customers = busunessLogicCustomer.fincCustomerByName(parameterName);
        return Mono.just(new ResponseController<>(customers));
    }
}
