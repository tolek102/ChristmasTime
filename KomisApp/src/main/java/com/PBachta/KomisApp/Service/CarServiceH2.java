package com.PBachta.KomisApp.Service;

import com.PBachta.KomisApp.DataTypes.Maker;
import com.PBachta.KomisApp.Entity.Car;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;


@Repository
@Transactional
@ConditionalOnProperty(prefix = "", name = "H2_STORAGE_ENABLED", havingValue = "true")
class CarServiceH2 implements CarServiceInteface {

    @PersistenceContext
    private
    EntityManager entityManager;

    @Override
    public List<Car> getAll() {
        TypedQuery<Car> namedQuery = entityManager.createNamedQuery("find_all_cars", Car.class);
        return namedQuery.getResultList();
    }

    @Override
    public Car getById(Long id) {
        return entityManager.find(Car.class, id);
    }

    @Override
    public Car post(Maker maker, Integer engineCapacity, Integer numberOfSeats, Date firstRegistrationDate, Date registrationCardIssueDate, String registrationNumber) {
        Car car = new Car(maker, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber);
        return entityManager.merge(car);
    }

    @Override
    public List<Car> delete(Long id) {
        Car car = getById(id);
        entityManager.remove(car);
        return getAll();
    }

    @Override
    public Car put(Long id, Maker maker, Integer engineCapacity, Integer numberOfSeats, Date firstRegistrationDate, Date registrationCardIssueDate, String registrationNumber) {

        Car entryCar = getById(id);

        if (maker == null)
            maker = entryCar.getMaker();
        if (engineCapacity == null)
            engineCapacity = entryCar.getEngineCapacity();
        if (numberOfSeats == null)
            numberOfSeats = entryCar.getNumberOfSeats();
        if (firstRegistrationDate == null)
            firstRegistrationDate = entryCar.getFirstRegistrationDate();
        if (registrationCardIssueDate == null)
            registrationCardIssueDate = entryCar.getRegistrationCardIssueDate();
        if (registrationNumber == null)
            registrationNumber = entryCar.getRegistrationNumber();

        try {
            Car car = new Car(id, maker, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber);
            entityManager.merge(car);
        } catch (Exception e) {
            throw new IllegalArgumentException("Car data for upload are incorrect. Please correct the data and try again");
        }
        return entityManager.find(Car.class, id);
    }
}
