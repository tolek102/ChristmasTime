package com.PBachta.KomisApp.controller;

import com.PBachta.KomisApp.entity.Customer;
import com.PBachta.KomisApp.service.CustomerServiceInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer", produces = {"application/json", "application/xml"})
@Api(description = "Rest API for customer operations", tags = "Customer API")
public class CustomerController {

  @Autowired
  private CustomerServiceInterface customerService;


  //Show all customers in database
  @GetMapping(value = "")
  @ApiOperation(value = "Display all customers in database", response = Customer.class)
  @ResponseBody
  public List<Customer> getAllCustomers() {

    return customerService.getAll();
  }


  //Search customer by id
  @GetMapping(value = "/{id}")
  @ApiOperation(value = "Display customer with specified id", response = Customer.class)
  @ResponseBody
  public Customer getCustomerById(@ApiParam(value = "ID of customer to display", required = true)
                                  @PathVariable("id") Long id) {

    return customerService.getById(id);
  }


  //Add new customer to database
  @PostMapping(value = "")
  @ApiOperation(value = "Add new customer to database", response = Customer.class)
  @ResponseBody
  public Customer postNewCustomer(@ApiParam(value = "First name of the customer being added", required = true)
                                    @RequestParam("firstName") String firstName,
                                  @ApiParam(value = "Last name of the customer being added", required = true)
                                    @RequestParam("lastName") String lastName,
                                  @ApiParam(value = "ID card number of the customer being added", required = true)
                                    @RequestParam("idCardNumber") String idCardNumber,
                                  @ApiParam(value = "PESEL of the customer being added", required = true)
                                    @RequestParam("peselNumber") String peselNumber) {

    return customerService.post(firstName, lastName, idCardNumber, peselNumber);
  }


  //Delete customer from database
  @DeleteMapping(value = "/{id}")
  @ApiOperation(value = "Delete customer with specified id from database", response = Customer.class)
  @ResponseBody
  public List<Customer> deleteCustomer(@ApiParam(value = "ID of the customer to delete", required = true)
                                       @PathVariable("id") Long id) {

    return customerService.delete(id);
  }


  //Update existing customer information
  @PutMapping(value = "/{id}")
  @ApiOperation(value = "Edit information of specified customer", response = Customer.class)
  @ResponseBody
  @Validated
  public Customer putNewCustomerData(@ApiParam(value = "ID of the customer to edit", required = true)
                                       @PathVariable("id") Long id,
                                     @ApiParam("First name for edited customer")
                                       @RequestParam(value = "firstName", required = false) String firstName,
                                     @ApiParam("Last name for edited customer")
                                       @RequestParam(value = "lastName", required = false) String lastName,
                                     @ApiParam("ID card number for edited customer")
                                       @RequestParam(value = "idCardNumber", required = false) String idCardNumber,
                                     @ApiParam("PESEL number for edited customer")
                                       @RequestParam(value = "peselNumber", required = false) String peselNumber) {

    return customerService.put(id, firstName, lastName, idCardNumber, peselNumber);
  }

  //____________ additional functions________

  //Search customer by first name
  @GetMapping(value = "/firstName={firstName}")
  @ApiOperation(value = "Search for all customers witch specified first name", response = Customer.class)
  @ResponseBody
  public List<Customer> getByFirstName(@ApiParam(value = "First name for searching in database", required = true)
                                       @PathVariable("firstName") String firstName) {

    return customerService.getByFirstName(firstName);
  }


  //Search customer by last name
  @GetMapping(value = "/lastName={lastName}")
  @ApiOperation(value = "Search for all customers witch specified last name", response = Customer.class)
  @ResponseBody
  public List<Customer> getCustomerByLastName(@ApiParam(value = "Last name for searching in database", required = true)
                                              @PathVariable("lastName") String lastName) {

    return customerService.getByLastName(lastName);
  }


  //Search customer by ID card number
  @GetMapping(value = "/idCardNumber={idCardNumber}")
  @ApiOperation(value = "Search for customer witch specified id card number", response = Customer.class)
  @ResponseBody
  public Customer getCustomerByIdCardNumber(@ApiParam(value = "ID card number for searching in database", required = true)
                                            @PathVariable("idCardNumber") String idCardNumber) {

    return customerService.getByIdCardNumber(idCardNumber);
  }


  //Search customer by PESEL number
  @GetMapping(value = "/peselNumber={peselNumber}")
  @ApiOperation(value = "Search for customer witch specified PESEL number", response = Customer.class)
  @ResponseBody
  public Customer getCustomerByIdPeselNumber(@ApiParam(value = "PESEL number for searching in database", required = true)
                                             @PathVariable("peselNumber") String peselNumber) {

    return customerService.getByIdPeselNumber(peselNumber);
  }
}
