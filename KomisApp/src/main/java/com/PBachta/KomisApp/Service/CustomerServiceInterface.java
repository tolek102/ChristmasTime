package com.PBachta.KomisApp.Service;

import com.PBachta.KomisApp.Entity.Customer;

import java.util.List;

public interface CustomerServiceInterface {

    List<Customer> getAll();

    Customer getById(Long id);

    Customer post(String firstName, String lastName, String idCardNumber, String peselNumber);

    List<Customer> delete(Long id);

    Customer put(Long id, String firstName, String lastName, String idCardNumber, String peselNumber);

    List<Customer> getByFirstName(String firstName);

    List<Customer> getByLastName(String lastName);

    Customer getByIdCardNumber(String idCardNumber);

    Customer getByIdPeselNumber(String peselNumber);
}
