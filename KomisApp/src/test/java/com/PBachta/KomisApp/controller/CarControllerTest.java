package com.PBachta.KomisApp.controller;

import com.PBachta.KomisApp.data.Maker;
import com.PBachta.KomisApp.entity.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CarControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CarController carControllerMock;


    @Test
    public void getAllTest() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(carControllerMock).build();

        List<Car> carList = Arrays.asList(
                new Car(1L, Maker.HONDA, 1589, 5,
                        new Date(98, 1, 5),
                        new Date(98, 2, 5),
                        "AB1111"),
                new Car(2L, Maker.FIAT, 900, 4,
                        new Date(99, 2, 5),
                        new Date(100, 3, 11),
                        "CD2222")
        );

        Mockito.when(carControllerMock.getAllCars()).thenReturn(carList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                                            .get("/car")
                                            .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        String expected = "[{id:1,maker:HONDA,engineCapacity:1589,numberOfSeats:5," +
                            "firstRegistrationDate:1998-02-05," +
                            "registrationCardIssueDate:1998-03-05," +
                            "registrationNumber:AB1111}," +
                            "{id:2,maker:FIAT,engineCapacity:900,numberOfSeats:4," +
                            "firstRegistrationDate:1999-03-05," +
                            "registrationCardIssueDate:2000-04-11," +
                            "registrationNumber:CD2222}]";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
    }

    @Test
    public void getByIdTest() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(carControllerMock).build();

        Car car = (new Car(1L, Maker.HONDA, 1589, 5,
                            new Date(98, 1, 5),
                            new Date(98, 2, 5),
                            "AB1111"));

        Mockito.when(carControllerMock.getCarById(1L)).thenReturn(car);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                                            .get("/car/1")
                                            .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        String expected = "{id: 1,maker: HONDA,engineCapacity: 1589,numberOfSeats: 5," +
                            "firstRegistrationDate: 1998-02-05," +
                            "registrationCardIssueDate: 1998-03-05," +
                            "registrationNumber: AB1111}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
    }

    @Test
    public void postNewCarTest() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(carControllerMock).build();

        Car car = (new Car(1L, Maker.HONDA, 1589, 5,
                            new Date(98, 1, 5),
                            new Date(98, 2, 5),
                            "AB1111"));


        Mockito.when(carControllerMock
                        .postNewCar(Maker.HONDA, 1589, 5,
                                    new Date(98, 1, 5),
                                    new Date(98, 2, 5),
                                    "AB1111"))
                        .thenReturn(car);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                                            .post("/car?maker=HONDA&engineCapacity=1589" +
                                                             "&numberOfSeats=5" +
                                                             "&firstRegistrationDate=1988-01-05" +
                                                             "&registrationCardIssueDate=1988-02-05" +
                                                             "&registrationNumber=AB1111")
                                            .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void deleteCarTest() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(carControllerMock).build();

        List<Car> carList = Arrays.asList(
                new Car(1L, Maker.HONDA, 1589, 5,
                        new Date(98, 1, 5),
                        new Date(98, 2, 5),
                        "AB1111")
        );

        Mockito.when(carControllerMock.deleteCar(2L)).thenReturn(carList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                                            .delete("/car/2")
                                            .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        String expected = "[{id:1,maker:HONDA,engineCapacity:1589,numberOfSeats:5," +
                            "firstRegistrationDate:1998-02-05," +
                            "registrationCardIssueDate:1998-03-05," +
                            "registrationNumber:AB1111}]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
    }

    @Test
    public void putNewCarData() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(carControllerMock).build();
        Car car = (new Car(1L, Maker.FIAT, 1200, 5,
                            new Date(98, 1, 5),
                            new Date(98, 2, 5),
                            "AB1111"));

        Mockito.when(carControllerMock
                        .putNewCarData(1L, Maker.FIAT, 1200, null,
                                        null, null,
                                        null))
                        .thenReturn(car);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                                            .put("/car/1?maker=FIAT&engineCapacity=1200")
                                            .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        String expected = "{id:1,maker:FIAT,engineCapacity:1200,numberOfSeats:5," +
                            "firstRegistrationDate:1998-02-05," +
                            "registrationCardIssueDate:1998-03-05," +
                            "registrationNumber:AB1111}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
    }

}


