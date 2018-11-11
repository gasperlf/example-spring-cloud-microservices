package co.com.customerservice.services;

import co.com.customerservice.datasource.entities.Customer;

import java.util.List;

public interface BusunessLogicCustomer {
    public void save(Customer customer);

    public List<Customer> fincCustomerByName(String name);
}
