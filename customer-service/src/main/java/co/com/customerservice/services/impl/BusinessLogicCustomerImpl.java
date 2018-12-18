package co.com.customerservice.services.impl;

import co.com.customerservice.datasource.CustomerCompanyService;
import co.com.customerservice.datasource.CustomerService;
import co.com.customerservice.datasource.entities.Customer;
import co.com.customerservice.datasource.entities.CustomerCompany;
import co.com.customerservice.exceptions.ValidationDataException;
import co.com.customerservice.services.BusinessLogicCustomer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Service
public class BusinessLogicCustomerImpl implements BusinessLogicCustomer {

    private final CustomerService customerService;
    private final CustomerCompanyService customerCompanyService;

    public BusinessLogicCustomerImpl(CustomerService customerService, CustomerCompanyService customerCompanyService) {
        this.customerService = customerService;
        this.customerCompanyService = customerCompanyService;
    }

    @Override
    public void save(Customer customer) {
        customerService.save(customer);
    }

    @Override
    public Flux<Customer> findCustomerByName(String name) {
        return customerService.findCustomerByName(name);
    }

    @Override
    public Mono<CustomerCompany> save(Mono<CustomerCompany> customerCompanyMono) {

        Mono<Customer> customer = customerCompanyMono
                .map(customerCompany -> this.customerService.findCustomerById(customerCompany.getCustomerId()))
                .subscribeOn(Schedulers.elastic());

        customer.subscribe();

        Mono<CustomerCompany> customerCompanyMono1 = customerCompanyMono.flatMap(customerCompany -> {
            Mono<Boolean> validationListMono = this.customerCompanyService.findCustomerCompanyByCustomerIdAndCompanyAllActive(customerCompany.getCustomerId(), customerCompany.getCompany())
                    .collectList()
                    .map(customerCompanies -> customerCompanies.isEmpty());
            validationListMono.subscribe();

            return validationListMono.flatMap(aBoolean -> {
                if(!aBoolean){
                    throw new ValidationDataException("001", "Company already was registered");
                }
                return this.customerCompanyService.save(customerCompanyMono);
            });
        });
        customerCompanyMono1.subscribe();
        return customerCompanyMono1;
    }

    @Override
    public Flux<CustomerCompany> findCustomerCompanyByCustomerId(Integer customerId){
        return this.customerCompanyService.findCustomerCompanyByCustomerIdActives(customerId);
    }

}
