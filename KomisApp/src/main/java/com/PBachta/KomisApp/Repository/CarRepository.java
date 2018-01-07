package com.PBachta.KomisApp.Repository;

import java.util.List;

import com.PBachta.KomisApp.DataTypes.Maker;
import com.PBachta.KomisApp.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "car", path = "car")
public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findByMaker(@Param("maker") Maker maker);

//    List<Car> findByEngineCapacity(@Param("model") String model);
//
//    Car findByRegistrationNumber(@Param("registrationNr") String registrationNr);
//
//    Car findByVinNumber(@Param("vin") String vin);

}
