package lf.com.customerservice.datasource.repositories;

import lf.com.customerservice.datasource.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Optional<List<Customer>> findByNameStartingWith(String name);
}
