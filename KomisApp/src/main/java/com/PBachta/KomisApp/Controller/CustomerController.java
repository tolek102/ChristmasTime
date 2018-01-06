package com.PBachta.KomisApp.Controller;

import com.PBachta.KomisApp.Entity.Customer;
import com.PBachta.KomisApp.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //Show all customers in database
    @GetMapping(value = "")
    @ResponseBody
    public List<Customer> getAllCustomers() {

        return customerService.getAll();
    }


    //Search customer by id
    @GetMapping(value = "/{id}")
    @ResponseBody
    public Customer getCustomerById(@PathVariable("id") long id) {

        return customerService.getById(id);
    }


    //Add new customer to database
    @PostMapping(value = "")
    @ResponseBody
    public Customer postNewCustomer(@RequestParam("firstName") String firstName,
                                    @RequestParam("lastName") String lastName,
                                    @RequestParam("idCardNumber") String idCardNumber,
                                    @RequestParam("peselNumber") String peselNumber) {

        return customerService.post(firstName, lastName, idCardNumber, peselNumber);
    }


    //Delete customer from database
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public List<Customer> deleteCustomer(@PathVariable("id") long id) {

        return customerService.delete(id);
    }


    //Update existing customer information
    @PutMapping(value = "/{id}")
    @ResponseBody
    public Customer putNewCustomerData(@PathVariable("id") long id,
                                       @RequestParam(value = "firstName", required = false) String firstName,
                                       @RequestParam(value = "lastName", required = false) String lastName,
                                       @RequestParam(value = "idCardNumber", required = false) String idCardNumber,
                                       @RequestParam(value = "peselNumber", required = false) String peselNumber) {

        return customerService.put(id, firstName, lastName, idCardNumber, peselNumber);
    }

//______________________________________________ additional functions___________________________________________________

    //Search customer by first name
    @GetMapping(value = "/firstName={firstName}")
    @ResponseBody
    public List<Customer> getByFirstName(@PathVariable("firstName") String firstName) {

        return customerService.getByFirstName(firstName);
    }


    //Search customer by last name
    @GetMapping(value = "/lastName={lastName}")
    @ResponseBody
    public List<Customer> getCustomerByLastName(@PathVariable("lastName") String lastName) {

        return customerService.getByLastName(lastName);
    }


    //Search customer by ID card number
    @GetMapping(value = "/idCardNumber={idCardNumber}")
    @ResponseBody
    public Customer getCustomerByIdCardNumber(@PathVariable("idCardNumber") String idCardNumber) {

        return customerService.getByIdCardNumber(idCardNumber);
    }


    //Search customer by PESEL number
    @GetMapping(value = "/peselNumber={peselNumber}")
    @ResponseBody
    public Customer getCustomerByIdPeselNumber(@PathVariable("peselNumber") String peselNumber) {

        return customerService.getByIdPeselNumber(peselNumber);
    }
}
