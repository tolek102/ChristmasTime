package com.PBachta.KomisApp.Repository;

import java.util.List;
import com.PBachta.KomisApp.Entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(@Param("lastName") String lastName);

    List<Customer> findByFirstName(@Param("firstName") String firstName);

    Customer findByIdCardNumber(@Param("idCardNumber") String idCardNumber);

    Customer findByPeselNumber(@Param("peselNumber") String peselNumber);
}