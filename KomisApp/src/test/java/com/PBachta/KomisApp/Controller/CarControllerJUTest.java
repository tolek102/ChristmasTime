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
public class CarControllerJUTest{

    @Autowired
    private CarController carController;

 /*        data initialization is taken from package com.PBachta.KomisApp DataInitializer.dataInit()
         this is adding 4 elements to database on program startup (@PostConstruct)

        [{"id":1,"maker":"Subaru","model":"Legacy","registrationNumber":"ZS85H55","vinNumber":"4S3BP616556397994"},
        {"id":2,"maker":"Dodge","model":"Caliber","registrationNumber":"ZGR02GU","vinNumber":"1B3HB28B18D508661"},
        {"id":3,"maker":"Jeep","model":"Patriot","registrationNumber":"ZSW1523","vinNumber":"1J4FT28A99D140347"},
        {"id":4,"maker":"Ford","model":"Expedition","registrationNumber":"ZPL18KL","vinNumber":"1FMRU15W61LA66899"}]
*/

    @Test
    public void getAllTest(){
        Assert.assertEquals("getAllTest function failure - expected size",4, carController.getAll().size());
    }

    @Test
    public void getByIdTest(){
        Assert.assertEquals("getByIdTest function failure - expected id",2L, carController.getById(2).getId().longValue());
    }

    @Test
    public void postNewCarTest(){
        int initSize = carController.getAll().size();
        carController.postNewCar("Marker", "Model", "RegistrationNr", "VinNr");
        Assert.assertEquals("postNewCarTest function failure - expected size",initSize + 1,carController.getAll().size());
    }

    @Test
    public void deleteCarTest(){
        int initSize = carController.getAll().size();
        carController.deleteCar(4);
        Assert.assertEquals("deleteCarTest function failure - expected size",initSize-1, carController.getAll().size());
    }

    @Test
    public void putNewCarDataTest(){
        int initSize = carController.getAll().size();
        carController.putNewCarData(1, "Maker", null, null, null);
        Assert.assertEquals("putNewCarDataTest function failure - expected id",1L,carController.getById(1).getId().longValue() );
        Assert.assertEquals("putNewCarDataTest function failure - expected maker","Maker",carController.getById(1).getMaker());
        Assert.assertEquals("putNewCarDataTest function failure - expected model","Legacy", carController.getById(1).getModel());
        Assert.assertEquals("putNewCarDataTest function failure - expected registration number","ZS85H55", carController.getById(1).getRegistrationNumber());
        Assert.assertEquals("putNewCarDataTest function failure - expected VIN number","4S3BP616556397994", carController.getById(1).getVinNumber());
        Assert.assertEquals("putNewCarDataTest function failure - expected size", initSize, carController.getAll().size());
    }
}
