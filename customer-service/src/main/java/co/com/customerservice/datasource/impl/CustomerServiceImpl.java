package co.com.customerservice.datasource.impl;

import co.com.customerservice.datasource.CustomerService;
import co.com.customerservice.datasource.entities.Customer;
import co.com.customerservice.datasource.repositories.CustomerRepository;
import co.com.customerservice.exceptions.DataNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

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
