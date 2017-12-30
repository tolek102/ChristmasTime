package com.PBachta.KomisApp.Controller;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;
import com.PBachta.KomisApp.Entity.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Mock;
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
        mockMvc= MockMvcBuilders.standaloneSetup(carControllerMock).build();

        List<Car> carList = Arrays.asList(
                new Car(1, "Subaru", "Legacy", "ZS85H55", "4S3BP616556397994"),
                new Car(2,"Dodge","Caliber","ZGR02GU","1B3HB28B18D508661")
        );

        Mockito.when(carControllerMock.getAll()).thenReturn(carList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/car").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        String expected = "[{id: 1,maker: Subaru,model: Legacy,registrationNumber: ZS85H55,vinNumber: 4S3BP616556397994}," +
                           "{id: 2,maker: Dodge,model: Caliber,registrationNumber: ZGR02GU,vinNumber: 1B3HB28B18D508661}]";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
    }

    @Test
    public void getByIdTest() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(carControllerMock).build();

        Car car = (new Car(1, "Subaru", "Legacy", "ZS85H55", "4S3BP616556397994"));

        Mockito.when(carControllerMock.getById(1)).thenReturn(car);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/car/1").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        String expected = "{id: 1,maker: Subaru,model: Legacy,registrationNumber: ZS85H55,vinNumber: 4S3BP616556397994}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
    }

    @Test
    public void postNewCarTest() throws Exception{
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(carControllerMock).build();

        Car car = (new Car(1, "Subaru", "Legacy", "ZS85H55", "4S3BP616556397994"));

        Mockito.when(carControllerMock.postNewCar( "Subaru", "Legacy", "ZS85H55", "4S3BP616556397994")).thenReturn(car);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/car?maker=Subaru&model=Legacy&registrationNumber=ZS85H55&vinNumber=4S3BP616556397994").contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        String expected = "{id: 1,maker: Subaru,model: Legacy,registrationNumber: ZS85H55,vinNumber: 4S3BP616556397994}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
    }

    @Test
    public void deleteCarTest() throws Exception{
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(carControllerMock).build();

        List<Car> carList = Arrays.asList(
                new Car(1, "Subaru", "Legacy", "ZS85H55", "4S3BP616556397994")
        );

        Mockito.when(carControllerMock.deleteCar(2)).thenReturn(carList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/car/2").contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        String expected = "[{id: 1,maker: Subaru,model: Legacy,registrationNumber: ZS85H55,vinNumber: 4S3BP616556397994}]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
    }

    @Test
    public void putNewCarData() throws Exception{
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(carControllerMock).build();
        Car car = (new Car(1, "Ford", "Legacy", "ZGR02GU", "4S3BP616556397994"));

        Mockito.when(carControllerMock.putNewCarData(1, "Ford", null, "ZGR02GU", null)).thenReturn(car);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/car/1?maker=Ford&registrationNumber=ZGR02GU").contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        String expected = "{id: 1,maker: Ford,model: Legacy,registrationNumber: ZGR02GU,vinNumber: 4S3BP616556397994}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
    }
}


