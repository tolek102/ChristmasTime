package com.PBachta.KomisApp.repository;

import com.PBachta.KomisApp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  List<Customer> findByLastName(@Param("lastName") String lastName);

  List<Customer> findByFirstName(@Param("firstName") String firstName);

  Customer findByIdCardNumber(@Param("idCardNumber") String idCardNumber);

  Customer findByPeselNumber(@Param("peselNumber") String peselNumber);
}
