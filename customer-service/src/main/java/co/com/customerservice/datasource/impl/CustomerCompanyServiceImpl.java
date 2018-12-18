package co.com.customerservice.datasource.impl;

import co.com.customerservice.datasource.CustomerCompanyService;
import co.com.customerservice.datasource.entities.CustomerCompany;
import co.com.customerservice.datasource.repositories.CustomerCompanyRepository;
import co.com.customerservice.exceptions.DataNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerCompanyServiceImpl implements CustomerCompanyService {

    private final CustomerCompanyRepository customerCompanyRepository;

    public CustomerCompanyServiceImpl(CustomerCompanyRepository customerCompanyRepository){
        this.customerCompanyRepository = customerCompanyRepository;
    }

    @Override
    public Flux<CustomerCompany> findCustomerCompanyByCustomerIdAndCompanyAllActive(Integer customerId, String company){
        return Flux.fromIterable(this.customerCompanyRepository.findByCustomerIdAndCompanyAndState(customerId,company.toUpperCase(), true).orElse(new ArrayList<>()));
    }

    @Override
    public Mono<CustomerCompany> save(Mono<CustomerCompany> customerCompany){
       return customerCompany
                .flatMap(this::save);
    }

    private Mono<CustomerCompany> save(CustomerCompany customerCompany){
        return Mono.just(this.customerCompanyRepository.save(customerCompany));
    }

    @Override
    public Flux<CustomerCompany> findCustomerCompanyByCustomerIdActives(Integer customerId){
        Optional<List<CustomerCompany>> customerCompanyList = this.customerCompanyRepository.findByCustomerIdAndState(customerId,true);
        if(customerCompanyList.get().isEmpty()){
            throw new DataNotFoundException("001", "Data not found");
        }
        return  Flux.fromIterable(customerCompanyList.get());
    }
}
