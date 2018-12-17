package co.com.customerservice.services;

import co.com.customerservice.datasource.entities.Customer;
import co.com.customerservice.datasource.entities.CustomerCompany;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BusinessLogicCustomer {

    public void save(Customer customer);

    public Flux<Customer> findCustomerByName(String name);

    public Mono<CustomerCompany> save(Mono<CustomerCompany> customerCompany);


}