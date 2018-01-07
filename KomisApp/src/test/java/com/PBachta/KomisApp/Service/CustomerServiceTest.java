//package com.PBachta.KomisApp.Service;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class CustomerServiceTest {
//
//    @Autowired
//    private CustomerService customerService;
//
////         data initialization is taken from package com.PBachta.KomisApp DataInitializer.dataInit()
////         this is adding 4 elements to database on program startup (@PostConstruct)
////
////        [{"id":1,"firstName":"Jan","lastName":"Kowalski","idCardNumber":"NHW399139","peselNumber":"43062460106"},
////        {"id":2,"firstName":"Adam","lastName":"Nowak","idCardNumber":"KQL847332","peselNumber":"07240779183"},
////        {"id":3,"firstName":"Zygfryd","lastName":"Kopytko","idCardNumber":"EIS182302","peselNumber":"79121576859"},
////        {"id":4,"firstName":"Andrzej","lastName":"Zawada","idCardNumber":"EXY304697","peselNumber":"65020522882"}]
//
//    @Test
//    public void getAllTest(){
//        assertEquals("getAllTest function failure - expected size",4, customerService.getAll().size());
//    }
//
//    @Test
//    public void getByIdTest(){
//        assertEquals("getByIdTest function failure - expected id","2", customerService.getById(2L).getId().toString());
//    }
//
//    @Test
//    public void postNewCustometTest(){
//        int initSize = customerService.getAll().size();
//        customerService.post("First", "Last", "ID Number", "PESEL");
//        assertEquals("postNewCustometTest function failure - expected size",initSize + 1,customerService.getAll().size());
//    }
//
//    @Test
//    public void deleteCustomerTest(){
//        int initSize = customerService.getAll().size();
//        customerService.delete(4L);
//        assertEquals("deleteCustomerTest function failure - expected size",initSize-1, customerService.getAll().size());
//    }
//
//    @Test
//    public void putNewCustomerDataTest(){
//        int initSize = customerService.getAll().size();
//        customerService.put(1L, "Changed", null, null, null);
//        assertEquals("putNewCustomerDataTest function failure - expected id", "1",customerService.getById(1L).getId().toString() );
//        assertEquals("putNewCustomerDataTest function failure - expected First Name","Changed",customerService.getById(1L).getFirstName());
//        assertEquals("putNewCustomerDataTest function failure - expected Last Name","Kowalski", customerService.getById(1L).getLastName());
//        assertEquals("putNewCustomerDataTest function failure - expected ID card number","NHW399139", customerService.getById(1L).getIdCardNumber());
//        assertEquals("putNewCustomerDataTest function failure - expected PESEL number","43062460106", customerService.getById(1L).getPeselNumber());
//        assertEquals("putNewCustomerDataTest function failure - expected size",initSize, customerService.getAll().size());
//    }
//}