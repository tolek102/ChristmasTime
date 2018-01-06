package com.PBachta.KomisApp.Service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CarServiceTest{

    @Autowired
    private CarService carService;

 /*        data initialization is taken from package com.PBachta.KomisApp DataInitializer.dataInit()
         this is adding 4 elements to database on program startup (@PostConstruct)

        [{"id":1,"maker":"Subaru","model":"Legacy","registrationNumber":"ZS85H55","vinNumber":"4S3BP616556397994"},
        {"id":2,"maker":"Dodge","model":"Caliber","registrationNumber":"ZGR02GU","vinNumber":"1B3HB28B18D508661"},
        {"id":3,"maker":"Jeep","model":"Patriot","registrationNumber":"ZSW1523","vinNumber":"1J4FT28A99D140347"},
        {"id":4,"maker":"Ford","model":"Expedition","registrationNumber":"ZPL18KL","vinNumber":"1FMRU15W61LA66899"}]
*/

    @Test
    public void getAllTest(){
        assertEquals("getAllTest function failure - expected size",4, carService.getAll().size());
    }

    @Test
    public void getByIdTest(){
        assertEquals("getByIdTest function failure - expected id",2L, carService.getById(2).getId().longValue());
    }

    @Test
    public void postNewCarTest(){
        int initSize = carService.getAll().size();
        carService.post("Marker", "Model", "RegistrationNr", "VinNr");
        assertEquals("postNewCarTest function failure - expected size",initSize + 1,carService.getAll().size());
    }

    @Test
    public void deleteCarTest(){
        int initSize = carService.getAll().size();
        carService.delete(4);
        assertEquals("deleteCarTest function failure - expected size",initSize-1, carService.getAll().size());
    }

    @Test
    public void putNewCarDataTest(){
        int initSize = carService.getAll().size();
        carService.put(1, "Maker", null, null, null);
        assertEquals("putNewCarDataTest function failure - expected id",1L,carService.getById(1).getId().longValue() );
        assertEquals("putNewCarDataTest function failure - expected maker","Maker",carService.getById(1).getMaker());
        assertEquals("putNewCarDataTest function failure - expected model","Legacy", carService.getById(1).getModel());
        assertEquals("putNewCarDataTest function failure - expected registration number","ZS85H55", carService.getById(1).getRegistrationNumber());
        assertEquals("putNewCarDataTest function failure - expected VIN number","4S3BP616556397994", carService.getById(1).getVinNumber());
        assertEquals("putNewCarDataTest function failure - expected size", initSize, carService.getAll().size());

    }
}
