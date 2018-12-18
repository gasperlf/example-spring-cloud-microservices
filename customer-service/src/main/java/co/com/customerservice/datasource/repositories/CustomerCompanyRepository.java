package co.com.customerservice.datasource.repositories;

import co.com.customerservice.datasource.entities.CustomerCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerCompanyRepository extends JpaRepository<CustomerCompany,Integer> {

    Optional<List<CustomerCompany>> findByCustomerIdAndCompanyAndState(Integer customerId,String company, Boolean state);

    Optional<List<CustomerCompany>> findByCustomerIdAndState(Integer integer, Boolean state);
}
