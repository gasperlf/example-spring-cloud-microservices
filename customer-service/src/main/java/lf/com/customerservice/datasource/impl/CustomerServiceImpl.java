package lf.com.customerservice.datasource.impl;

import lf.com.customerservice.datasource.CustomerService;
import lf.com.customerservice.datasource.entities.Customer;
import lf.com.customerservice.datasource.repositories.CustomerRepository;
import lf.com.customerservice.exceptions.DataNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    public void save(Customer customer){
        customer=customerRepository.save(customer);
    }

    public Flux<Customer> findCustomerByName(String name){
        return Flux.fromIterable(customerRepository.findByNameStartingWith(name).get());
    }

    public Customer findCustomerById(Integer customerId){
        return this.customerRepository.findById(customerId).orElseThrow(()->new DataNotFoundException("000","Customer not exist"));
    }
}
