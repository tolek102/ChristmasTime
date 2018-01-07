package com.PBachta.KomisApp.Service;

import com.PBachta.KomisApp.DataTypes.Maker;
import com.PBachta.KomisApp.Entity.Car;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConditionalOnProperty(prefix = "", name = "H2_STORAGE_ENABLED", havingValue="true")
class CarServiceH2 implements CarServiceInteface {

    @Override
    public List<Car> getAll() {
        return null;
    }

    @Override
   public Car getById(Long id) {
        return null;
    }

    @Override
    public Car post(Maker maker, Integer engineCapacity, Integer numberOfSeats, String firstRegistrationDate, String registrationCardIssueDate, String registrationNumber) {
        return null;
    }

    @Override
    public List<Car> delete(Long id) {
        return null;
    }

    @Override
    public Car put(Long id, Maker maker, Integer engineCapacity, Integer numberOfSeats, String firstRegistrationDate, String registrationCardIssueDate, String registrationNumber) {
        return null;
    }
}
