package com.PBachta.KomisApp.Service;

import com.PBachta.KomisApp.DataTypes.Maker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Date;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CarServiceTest {

    @Autowired
    private CarServiceInteface carService;

/*        data initialization is taken from package com.PBachta.KomisApp DataInitializer.dataInit()
         this is adding 4 elements to database on program startup (@PostConstruct)

        [{"id":1,"maker":"Subaru","model":"Legacy","registrationNumber":"ZS85H55","vinNumber":"4S3BP616556397994"},
        {"id":2,"maker":"Dodge","model":"Caliber","registrationNumber":"ZGR02GU","vinNumber":"1B3HB28B18D508661"},
        {"id":3,"maker":"Jeep","model":"Patriot","registrationNumber":"ZSW1523","vinNumber":"1J4FT28A99D140347"},
        {"id":4,"maker":"Ford","model":"Expedition","registrationNumber":"ZPL18KL","vinNumber":"1FMRU15W61LA66899"}]
*/

    @Test
    public void getAllTest() {
        assertEquals("getAllTest function failure - expected size", 4, carService.getAll().size());
    }

    @Test
    public void getByIdTest() {
        assertEquals("getByIdTest function failure - expected id", "2", carService.getById(2L).getId().toString());
    }

    @Test
    public void postNewCarTest() {
        int initSize = carService.getAll().size();
        carService.post(Maker.HONDA, 1590, 1, new Date(98, 01, 05), new Date(98, 01, 05), "AB123");
        assertEquals("postNewCarTest function failure - expected size", initSize + 1, carService.getAll().size());
    }

    @Test
    public void deleteCarTest() {
        int initSize = carService.getAll().size();
        carService.delete(4L);
        assertEquals("deleteCarTest function failure - expected size", initSize - 1, carService.getAll().size());
    }

    @Test
    public void putNewCarDataTest() {
        int initSize = carService.getAll().size();
        carService.put(1L, Maker.FIAT, 1100, 4, null, null, null);
        assertEquals("putNewCarDataTest function failure - expected id", "1", carService.getById(1L).getId().toString());
        assertEquals("putNewCarDataTest function failure - expected maker", "FIAT", carService.getById(1L).getMaker().toString());
        assertEquals("putNewCarDataTest function failure - expected engine capacity", "1100", carService.getById(1L).getEngineCapacity().toString());
        assertEquals("putNewCarDataTest function failure - expected number of seats", "4", carService.getById(1L).getNumberOfSeats().toString());
        assertEquals("putNewCarDataTest function failure - expected first registration date", "1998-02-05", carService.getById(1L).getFirstRegistrationDate().toString());
        assertEquals("putNewCarDataTest function failure - expected registration card issue date", "1998-03-05", carService.getById(1L).getRegistrationCardIssueDate().toString());
        assertEquals("putNewCarDataTest function failure - expected registration number", "AB1111", carService.getById(1L).getRegistrationNumber());
    }
}