package com.PBachta.KomisApp.Controller;

import com.PBachta.KomisApp.Entity.Customer;
import com.PBachta.KomisApp.Service.CustomerServiceInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
@Api(description = "Rest API for customer operations", tags = "Customer API")
public class CustomerController {

    @Autowired
    private CustomerServiceInterface customerService;

    //Show all customers in database
    @GetMapping(value = "", produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Display all customers in database", response = Customer.class)
    @ResponseBody
    public List<Customer> getAllCustomers() {

        return customerService.getAll();
    }


    //Search customer by id
    @GetMapping(value = "/{ID number}", produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Display customer with specified id", response = Customer.class)
    @ResponseBody
    public Customer getCustomerById(@ApiParam(value = "ID of customer to display", required =true)@PathVariable("ID number") Long id) {

        return customerService.getById(id);
    }


    //Add new customer to database
    @PostMapping(value = "", produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Add new customer to database", response = Customer.class)
    @ResponseBody
    public Customer postNewCustomer(@ApiParam(value = "First name of the customer being added" ,required =true)@RequestParam("First Name") String firstName,
                                    @ApiParam(value = "Last name of the customer being added" ,required =true)@RequestParam("Last Name") String lastName,
                                    @ApiParam(value = "ID card number of the customer being added" ,required =true)@RequestParam("ID Card Number") String idCardNumber,
                                    @ApiParam(value = "PESEL of the customer being added" ,required =true)@RequestParam("PESEL") String peselNumber) {

        return customerService.post(firstName, lastName, idCardNumber, peselNumber);
    }


    //Delete customer from database
    @DeleteMapping(value = "/{ID number}", produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Delete customer with specified id from database", response = Customer.class)
    @ResponseBody
    public List<Customer> deleteCustomer(@ApiParam(value = "ID of the customer to delete" ,required =true)@PathVariable("ID number") Long id) {

        return customerService.delete(id);
    }


    //Update existing customer information
    @PutMapping(value = "/{ID number}", produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Edit information of specified customer", response = Customer.class)
    @ResponseBody
    public Customer putNewCustomerData(@ApiParam(value = "ID of the customer to edit" ,required =true)@PathVariable("ID number") Long id,
                                       @ApiParam("First name for edited customer")@RequestParam(value = "First Name", required =false) String firstName,
                                       @ApiParam("Last name for edited customer")@RequestParam(value = "Last Name", required =false) String lastName,
                                       @ApiParam("ID card number for edited customer")@RequestParam(value = "ID Card Number", required =false) String idCardNumber,
                                       @ApiParam("PESEL number for edited customer")@RequestParam(value = "PESEL", required =false) String peselNumber) {

        return customerService.put(id, firstName, lastName, idCardNumber, peselNumber);
    }

//______________________________________________ additional functions___________________________________________________

    //Search customer by first name
    @GetMapping(value = "/firstName={First Name}", produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Search for all customers witch specified first name", response = Customer.class)
    @ResponseBody
    public List<Customer> getByFirstName(@ApiParam(value = "First name for searching in database" ,required =true)@PathVariable("First Name") String firstName) {

        return customerService.getByFirstName(firstName);
    }


    //Search customer by last name
    @GetMapping(value = "/lastName={Last Name}", produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Search for all customers witch specified last name", response = Customer.class)
    @ResponseBody
    public List<Customer> getCustomerByLastName(@ApiParam(value = "Last name for searching in database" ,required =true)@PathVariable("Last Name") String lastName) {

        return customerService.getByLastName(lastName);
    }


    //Search customer by ID card number
    @GetMapping(value = "/idCardNumber={ID Card Number}", produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Search for customer witch specified id card number", response = Customer.class)
    @ResponseBody
    public Customer getCustomerByIdCardNumber(@ApiParam(value = "ID card number for searching in database" ,required =true)@PathVariable("ID Card Number") String idCardNumber) {

        return customerService.getByIdCardNumber(idCardNumber);
    }


    //Search customer by PESEL number
    @GetMapping(value = "/peselNumber={PESEL}", produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Search for customer witch specified PESEL number", response = Customer.class)
    @ResponseBody
    public Customer getCustomerByIdPeselNumber(@ApiParam(value = "PESEL number for searching in database" ,required =true)@PathVariable("PESEL") String peselNumber) {

        return customerService.getByIdPeselNumber(peselNumber);
    }
}
