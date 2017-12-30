package com.PBachta.KomisApp.Controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CustomerControllerJUTest {

    @Autowired
    private CustomerController customerController;

//         data initialization is taken from package com.PBachta.KomisApp DataInitializer.dataInit()
//         this is adding 4 elements to database on program startup (@PostConstruct)
//
//        [{"id":1,"firstName":"Jan","lastName":"Kowalski","idCardNumber":"NHW399139","peselNumber":"43062460106"},
//        {"id":2,"firstName":"Adam","lastName":"Nowak","idCardNumber":"KQL847332","peselNumber":"07240779183"},
//        {"id":3,"firstName":"Zygfryd","lastName":"Kopytko","idCardNumber":"EIS182302","peselNumber":"79121576859"},
//        {"id":4,"firstName":"Andrzej","lastName":"Zawada","idCardNumber":"EXY304697","peselNumber":"65020522882"}]

    @Test
    public void getAllTest(){
        Assert.assertEquals("getAllTest function failure - expected size",4, customerController.getAll().size());
    }

    @Test
    public void getByIdTest(){
        Assert.assertEquals("getByIdTest function failure - expected id",2L, customerController.getById(2).getId().longValue());
    }

    @Test
    public void postNewCustometTest(){
        int initSize = customerController.getAll().size();
        customerController.postNewCustomer("First", "Last", "ID Number", "PESEL");
        Assert.assertEquals("postNewCustometTest function failure - expected size",initSize + 1,customerController.getAll().size());
    }

    @Test
    public void deleteCustomerTest(){
        int initSize = customerController.getAll().size();
        customerController.deleteCustomer(4);
        Assert.assertEquals("deleteCustomerTest function failure - expected size",initSize-1, customerController.getAll().size());
    }

    @Test
    public void putNewCustomerDataTest(){
        int initSize = customerController.getAll().size();
        customerController.putNewCustomerData(1, "Changed", null, null, null);
        Assert.assertEquals("putNewCustomerDataTest function failure - expected id", 1L,customerController.getById(1).getId().longValue() );
        Assert.assertEquals("putNewCustomerDataTest function failure - expected First Name","Changed",customerController.getById(1).getFirstName());
        Assert.assertEquals("putNewCustomerDataTest function failure - expected Last Name","Kowalski", customerController.getById(1).getLastName());
        Assert.assertEquals("putNewCustomerDataTest function failure - expected ID card number","NHW399139", customerController.getById(1).getIdCardNumber());
        Assert.assertEquals("putNewCustomerDataTest function failure - expected PESEL number","43062460106", customerController.getById(1).getPeselNumber());
        Assert.assertEquals("putNewCustomerDataTest function failure - expected size",initSize, customerController.getAll().size());
    }
}
