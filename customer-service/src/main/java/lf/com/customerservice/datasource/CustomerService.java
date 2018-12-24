package lf.com.customerservice.datasource;

import lf.com.customerservice.datasource.entities.Customer;
import reactor.core.publisher.Flux;

public interface CustomerService {

    public void save(Customer customer);

    public Flux<Customer> findCustomerByName(String name);

    public Customer findCustomerById(Integer customerId);
}
