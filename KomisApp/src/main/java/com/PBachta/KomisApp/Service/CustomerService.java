package com.PBachta.KomisApp.Service;

import com.PBachta.KomisApp.Entity.Customer;
import com.PBachta.KomisApp.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
class CustomerService implements CustomerServiceInterface {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer : customerRepository.findAll()) {
            customerList.add(customer);
        }

        if (customerList.size() == 0) {
            throw new RuntimeException("There are no customers in database");
        }
        return customerList;
    }


    public Customer getById(Long id) {
        Customer customer = customerRepository.findOne(id);
        if (customer == null) {
            throw new RuntimeException("Customer with id " + id + " not found");
        }
        return customer;
    }


    public Customer post(String firstName, String lastName, String idCardNumber, String peselNumber) {
        Customer customer = new Customer(firstName, lastName, idCardNumber, peselNumber);
        customerRepository.save(customer);
        return customer;
    }


    public List<Customer> delete(Long id) {
        customerRepository.delete(id);
        return getAll();
    }


    public Customer put(Long id, String firstName, String lastName, String idCardNumber, String peselNumber) {
        Customer customer = customerRepository.findOne(id);
        if (customer == null) {
            throw new RuntimeException("Customer with id " + id + " not found");
        }

        if (firstName == null)
            firstName = customer.getFirstName();
        if (lastName == null)
            lastName = customer.getLastName();
        if (idCardNumber == null)
            idCardNumber = customer.getIdCardNumber();
        if (peselNumber == null)
            peselNumber = customer.getPeselNumber();

        Customer updatedCustomer = new Customer(id, firstName, lastName, idCardNumber, peselNumber);
        customerRepository.save(updatedCustomer);
        return customerRepository.findOne(id);
    }


//______________________________________________ additional functions___________________________________________________


    public List<Customer> getByFirstName(String firstName) {
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer : customerRepository.findByFirstName(firstName)) {
            customerList.add(customer);
        }

        if (customerList.size() == 0) {
            throw new RuntimeException("Customer with first name " + firstName + " not found");
        }
        return customerList;
    }


    public List<Customer> getByLastName(String lastName) {
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer : customerRepository.findByLastName(lastName)) {
            customerList.add(customer);
        }

        if (customerList.size() == 0) {
            throw new RuntimeException("Customer with last name " + lastName + " not found");
        }
        return customerList;
    }


    public Customer getByIdCardNumber(String idCardNumber) {
        Customer customer = customerRepository.findByIdCardNumber(idCardNumber);
        if (customer == null) {
            throw new RuntimeException("Customer with ID Card number " + idCardNumber + " not found");
        }
        return customer;
    }


    public Customer getByIdPeselNumber(String peselNumber) {
        Customer customer = customerRepository.findByPeselNumber(peselNumber);
        if (customer == null) {
            throw new RuntimeException("Customer with PESEL number " + peselNumber + " not found");
        }
        return customer;
    }
}