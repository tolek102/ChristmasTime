package com.PBachta.KomisApp.DataInitialization;

import com.PBachta.KomisApp.DataTypes.Maker;
import com.PBachta.KomisApp.Entity.Car;
import com.PBachta.KomisApp.Entity.Customer;
import com.PBachta.KomisApp.Repository.CarRepository;
import com.PBachta.KomisApp.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PostConstruct;
import java.sql.Date;

@Component
public class DataInitializer {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerRepository customersRepository;

    @PostConstruct
    @Validated
    public void initDat() {
        carRepository.save(new Car(Maker.HONDA, 1589, 5, new Date(98, 1, 5), new Date(98, 2, 5), "AB1111"));
        carRepository.save(new Car(Maker.FIAT, 900, 4, new Date(99, 2, 5), new Date(100, 3, 11), "CD2222"));
        carRepository.save(new Car(Maker.SKODA, 2000, 6, new Date(93, 10, 20), new Date(94, 1, 5), "EF3333"));
        carRepository.save(new Car(Maker.HONDA, 2500, 2, new Date(98, 10, 5), new Date(98, 11, 1), "GH4444"));

        customersRepository.save(new Customer("Jan", "Kowalski", "NHW399139", "43062460106"));
        customersRepository.save(new Customer("Adam", "Nowak", "KQL847332", "07240779183"));
        customersRepository.save(new Customer("Zygfryd", "Kopytko", "EIS182302", "79121576859"));
        customersRepository.save(new Customer("Andrzej", "Zawada", "EXY304697", "65020522882"));
    }
}
