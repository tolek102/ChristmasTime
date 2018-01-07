//package com.PBachta.KomisApp.Controller;
//
//import static org.junit.Assert.assertEquals;
//import java.util.Arrays;
//import java.util.List;
//
//import com.PBachta.KomisApp.DataTypes.Maker;
//import com.PBachta.KomisApp.Entity.Car;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.mockito.Mock;
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
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class CarControllerTest {
//    private MockMvc mockMvc;
//
//    @Mock
//    private CarController carControllerMock;
//
//    @Test
//    public void getAllTest() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc= MockMvcBuilders.standaloneSetup(carControllerMock).build();
//
//        List<Car> carList = Arrays.asList(
//                new Car(1L, Maker.HONDA,1,1, "Legacy", "ZS85H55", "4S3BP616556397994"),
//                new Car(2L, Maker.FIAT,2,2,"Caliber","ZGR02GU","1B3HB28B18D508661")
//        );
//
//        Mockito.when(carControllerMock.getAllCars()).thenReturn(carList);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/car").accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        MockHttpServletResponse response = result.getResponse();
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//
//        String expected = "[{id: 1,maker: HONDA,engineCapacity: 1, numberOfSeats: 1, firstRegistrationDate: Legacy,registrationCardIssueDate: ZS85H55,registrationNumber: 4S3BP616556397994}," +
//                "{id: 2,maker: FIAT,engineCapacity: 2, numberOfSeats: 2,firstRegistrationDate: Caliber,registrationCardIssueDate: ZGR02GU,registrationNumber: 1B3HB28B18D508661}]";
//
//        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
//    }
//
//    @Test
//    public void getByIdTest() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc= MockMvcBuilders.standaloneSetup(carControllerMock).build();
//
//        Car car = (new Car(1L, Maker.HONDA,1,1, "Legacy", "ZS85H55", "4S3BP616556397994"));
//
//        Mockito.when(carControllerMock.getCarById(1L)).thenReturn(car);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/car/1").accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        MockHttpServletResponse response = result.getResponse();
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//
//        String expected = "{id: 1,maker: HONDA,engineCapacity: 1, numberOfSeats: 1,firstRegistrationDate: Legacy,registrationCardIssueDate: ZS85H55,registrationNumber: 4S3BP616556397994}";
//        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
//    }
//
//    @Test
//    public void postNewCarTest() throws Exception{
//        MockitoAnnotations.initMocks(this);
//        mockMvc= MockMvcBuilders.standaloneSetup(carControllerMock).build();
//
//        Car car = (new Car(1L, Maker.HONDA,1,1, "Legacy", "ZS85H55", "4S3BP616556397994"));
//
//        Mockito.when(carControllerMock.postNewCar( Maker.HONDA,1,1, "Legacy", "ZS85H55", "4S3BP616556397994")).thenReturn(car);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/car?maker=HONDA&engineCapacity=1&numberOfSeats=1&firstRegistrationDate=Legacy&registrationCardIssueDate=ZS85H55&registrationNumber=4S3BP616556397994").contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        MockHttpServletResponse response = result.getResponse();
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//
//        String expected = "{id: 1,maker: HONDA,engineCapacity: 1, numberOfSeats: 1,firstRegistrationDate: Legacy,registrationCardIssueDate: ZS85H55,registrationNumber: 4S3BP616556397994}";
//        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
//    }
//
//    @Test
//    public void deleteCarTest() throws Exception{
//        MockitoAnnotations.initMocks(this);
//        mockMvc= MockMvcBuilders.standaloneSetup(carControllerMock).build();
//
//        List<Car> carList = Arrays.asList(
//                new Car(1L, Maker.HONDA, 1,1,"Legacy", "ZS85H55", "4S3BP616556397994")
//        );
//
//        Mockito.when(carControllerMock.deleteCar(2L)).thenReturn(carList);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/car/2").contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        MockHttpServletResponse response = result.getResponse();
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//
//        String expected = "[{id: 1,maker: HONDA,engineCapacity: 1, numberOfSeats: 1,firstRegistrationDate: Legacy,registrationCardIssueDate: ZS85H55,registrationNumber: 4S3BP616556397994}]";
//        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
//    }
//
//    @Test
//    public void putNewCarData() throws Exception{
//        MockitoAnnotations.initMocks(this);
//        mockMvc= MockMvcBuilders.standaloneSetup(carControllerMock).build();
//        Car car = (new Car(1L, Maker.FIAT,1,1, "Legacy", "ZGR02GU", "4S3BP616556397994"));
//
//        Mockito.when(carControllerMock.putNewCarData(1L, Maker.FIAT, null,null,null, "ZGR02GU", null)).thenReturn(car);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/car/1?maker=FIAT&registrationCardIssueDate=ZGR02GU").contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        MockHttpServletResponse response = result.getResponse();
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//
//        String expected = "{id: 1,maker: FIAT,engineCapacity: 1, numberOfSeats: 1,firstRegistrationDate: Legacy,registrationCardIssueDate: ZGR02GU,registrationNumber: 4S3BP616556397994}";
//        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
//    }
//}
//
//
