package lf.com.customerservice.services;

import lf.com.customerservice.datasource.entities.Customer;
import lf.com.customerservice.datasource.entities.CustomerCompany;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BusinessLogicCustomer {

    public void save(Customer customer);

    public Flux<Customer> findCustomerByName(String name);

    public Mono<CustomerCompany> save(Mono<CustomerCompany> customerCompany);

    public Flux<CustomerCompany> findCustomerCompanyByCustomerId(Integer customerId);

}
