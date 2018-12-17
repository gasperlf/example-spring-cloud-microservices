package co.com.customerservice.datasource;

import co.com.customerservice.datasource.entities.Customer;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public void save(Customer customer);

    public Flux<Customer> findCustomerByName(String name);

    public Customer findCustomerById(Integer customerId);
}
