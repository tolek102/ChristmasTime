//package com.PBachta.KomisApp.Controller;
//
//import com.PBachta.KomisApp.Entity.Customer;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.skyscreamer.jsonassert.JSONAssert;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.transaction.annotation.Transactional;
//import java.util.Arrays;
//import java.util.List;
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class CustomerControllerTest {
//
//    private MockMvc mockMvc;
//
//    @Mock
//    private CustomerController customerControllerMock;
//
//    @Test
//    public void getAllTest() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc= MockMvcBuilders.standaloneSetup(customerControllerMock).build();
//
//        List<Customer> customerList = Arrays.asList(
//                new Customer(1L, "Jan", "Kowalski", "NHW399139", "43062460106"),
//                new Customer(2L,"Adam","Nowak","KQL847332","07240779183")
//        );
//
//        Mockito.when(customerControllerMock.getAllCustomers()).thenReturn(customerList);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer").accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        MockHttpServletResponse response = result.getResponse();
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//
//        String expected = "[{id: 1,firstName: Jan,lastName: Kowalski,idCardNumber: NHW399139,peselNumber: '43062460106'}," +
//                "{id: 2,firstName: Adam,lastName: Nowak,idCardNumber: KQL847332,peselNumber: '07240779183'}]";
//        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
//    }
//
//    @Test
//    public void getByIdTest() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc= MockMvcBuilders.standaloneSetup(customerControllerMock).build();
//
//        Customer customer = (new Customer(1L, "Jan", "Kowalski", "NHW399139", "43062460106"));
//
//        Mockito.when(customerControllerMock.getCustomerById(1L)).thenReturn(customer);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer/1").accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        MockHttpServletResponse response = result.getResponse();
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//
//        String expected = "{id: 1,firstName: Jan,lastName: Kowalski, idCardNumber: NHW399139,peselNumber: '43062460106'}";
//        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
//    }
//
//    @Test
//    public void postNewCustomerTest() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc= MockMvcBuilders.standaloneSetup(customerControllerMock).build();
//
//        Customer customer = (new Customer(1L, "Jan", "Kowalski", "NHW399139", "43062460106"));
//
//        Mockito.when(customerControllerMock.postNewCustomer("Jan","Kowalski", "NHW399139", "43062460106" )).thenReturn(customer);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/customer?firstName=Jan&lastName=Kowalski&idCardNumber=NHW399139&peselNumber=43062460106").accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        MockHttpServletResponse response = result.getResponse();
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//
//        String expected = "{id: 1,firstName: Jan,lastName: Kowalski, idCardNumber: NHW399139,peselNumber: '43062460106'}";
//        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
//    }
//
//    @Test
//    public void deleteCustomerTest() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc= MockMvcBuilders.standaloneSetup(customerControllerMock).build();
//
//        List<Customer> customerList = Arrays.asList(
//                new Customer(1L, "Jan", "Kowalski", "NHW399139", "43062460106")
//        );
//
//        Mockito.when(customerControllerMock.deleteCustomer(2L)).thenReturn(customerList);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/customer/2").accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        MockHttpServletResponse response = result.getResponse();
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//
//        String expected = "[{id: 1,firstName: Jan,lastName: Kowalski, idCardNumber: NHW399139,peselNumber: '43062460106'}]";
//        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
//    }
//
//    @Test
//    public void putNewCustomerDataTest() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc= MockMvcBuilders.standaloneSetup(customerControllerMock).build();
//
//        Customer customer = (new Customer(1L, "Jan", "Kowalski", "KQL847332", "07240779183"));
//
//        Mockito.when(customerControllerMock.putNewCustomerData(1L,null, null, "KQL847332","07240779183" )).thenReturn(customer);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/customer/1?idCardNumber=KQL847332&peselNumber=07240779183").accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        MockHttpServletResponse response = result.getResponse();
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//
//        String expected = "{id: 1,firstName: Jan,lastName: Kowalski, idCardNumber: KQL847332,peselNumber: '07240779183'}";
//        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
//    }
//}