package co.com.customerservice.datasource;

import co.com.customerservice.datasource.entities.CustomerCompany;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerCompanyService {

    public Flux<CustomerCompany> findCustomerCompanyByCustomerIdAndCompanyAllActive(Integer customerId, String company);

    public Mono<CustomerCompany> save(Mono<CustomerCompany> customerCompany);

    public Flux<CustomerCompany> findCustomerCompanyByCustomerIdActives(Integer customerId);
}
