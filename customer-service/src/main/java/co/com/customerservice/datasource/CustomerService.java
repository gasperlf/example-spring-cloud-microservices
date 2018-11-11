package co.com.customerservice.datasource;

import co.com.customerservice.datasource.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public void save(Customer customer);
    public Optional<List<Customer>> findCustomerByName(String name);
}
