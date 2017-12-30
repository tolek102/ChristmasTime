package com.PBachta.KomisApp.Controller;

import com.PBachta.KomisApp.Entity.Customer;
import com.PBachta.KomisApp.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    //Show all customers in database
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        for(Customer customer : customerRepository.findAll()){
            customerList.add(customer);
        }

        if (customerList.size() == 0) {
            throw new RuntimeException("There are no customers in database");
        }
        return customerList;
    }


    //Search customer by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Customer getById(@PathVariable("id") long id) {
        Customer customer = customerRepository.findOne(id);
        if (customer == null) {
            throw new RuntimeException("Customer with id "+id+" not found");
        }
        return customer;
    }


    //Add new customer to database
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Customer postNewCustomer(@RequestParam("firstName") String firstName,
                                          @RequestParam("lastName") String lastName,
                                          @RequestParam("idCardNumber") String idCardNumber,
                                          @RequestParam("peselNumber") String peselNumber) {
        Customer customer = new Customer(firstName, lastName, idCardNumber, peselNumber);
        customerRepository.save(customer);
        return customer;
    }


    //Delete customer from database
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public List<Customer> deleteCustomer(@PathVariable("id") long id) {
        customerRepository.delete(id);
        return getAll();
    }


    //Update existing customer information
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Customer putNewCustomerData(@PathVariable("id") long id,
                                        @RequestParam(value = "firstName", required = false) String firstName,
                                        @RequestParam(value = "lastName", required = false) String lastName,
                                        @RequestParam(value = "idCardNumber", required = false) String idCardNumber,
                                        @RequestParam(value = "peselNumber", required = false) String peselNumber) {
        Customer customer = customerRepository.findOne(id);
        if (customer == null) {
            throw new RuntimeException("Customer with id "+id+" not found");
        }

        if(firstName == null)
            firstName = customer.getFirstName();
        if(lastName == null)
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

    //Search customer by first name
    @RequestMapping(value = "/firstName={firstName}", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getByFirstName(@PathVariable("firstName") String firstName) {
        List<Customer> customerList = new ArrayList<>();
        for(Customer customer : customerRepository.findByFirstName(firstName)){
            customerList.add(customer);
        }

        if (customerList.size() == 0) {
            throw new RuntimeException("Customer with first name "+firstName+" not found");
        }
        return customerList;
    }


    //Search customer by last name
    @RequestMapping(value = "/lastName={lastName}", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getByLastName(@PathVariable("lastName") String lastName) {
        List<Customer> customerList = new ArrayList<>();
        for(Customer customer : customerRepository.findByLastName(lastName)){
            customerList.add(customer);
        }

        if (customerList.size() == 0) {
            throw new RuntimeException("Customer with last name "+lastName+" not found");
        }
        return customerList;
    }


    //Search customer by ID card number
    @RequestMapping(value = "/idCardNumber={idCardNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Customer getByIdCardNumber(@PathVariable("idCardNumber") String idCardNumber) {
        Customer customer = customerRepository.findByIdCardNumber(idCardNumber);
        if (customer == null) {
            throw new RuntimeException("Customer with ID Card number "+idCardNumber+" not found");
        }
        return customer;
    }


    //Search customer by PESEL number
    @RequestMapping(value = "/peselNumber={peselNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Customer getByIdPeselNumber(@PathVariable("peselNumber") String peselNumber) {
        Customer customer = customerRepository.findByPeselNumber(peselNumber);
        if (customer == null) {
            throw new RuntimeException("Customer with PESEL number "+peselNumber+" not found");
        }
        return customer;
    }
}
