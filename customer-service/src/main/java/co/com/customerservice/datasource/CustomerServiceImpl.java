package co.com.customerservice.datasource;

import co.com.customerservice.datasource.entities.Customer;
import co.com.customerservice.datasource.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    public void save(Customer customer){
        customer=customerRepository.save(customer);
    }

    public Optional<List<Customer>> findCustomerByName(String name){
        return customerRepository.findByNameStartingWith(name);
    }
}
