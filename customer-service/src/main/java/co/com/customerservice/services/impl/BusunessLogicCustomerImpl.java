package co.com.customerservice.services.impl;

import co.com.customerservice.datasource.CustomerService;
import co.com.customerservice.datasource.entities.Customer;
import co.com.customerservice.exceptions.DataNotFoundException;
import co.com.customerservice.services.BusunessLogicCustomer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusunessLogicCustomerImpl implements BusunessLogicCustomer {

    private final CustomerService customerService;

    public BusunessLogicCustomerImpl(CustomerService customerService){
        this.customerService=customerService;
    }

    @Override
    public void save(Customer customer){
        customerService.save(customer);
    }

    @Override
    public List<Customer> fincCustomerByName(String name){

        Optional<List<Customer>> customers = customerService.findCustomerByName(name);
        if(customers.isPresent() && !customers.get().isEmpty()){
            return customers.get();
        }else{
            throw new DataNotFoundException("00","Data no found");
        }
    }
}
