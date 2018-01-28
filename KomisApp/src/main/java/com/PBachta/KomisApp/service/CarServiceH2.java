package com.PBachta.KomisApp.service;

import com.PBachta.KomisApp.data.Maker;
import com.PBachta.KomisApp.entity.Car;
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
  private EntityManager entityManager;


  @Override
  public List<Car> getAll() {
    TypedQuery<Car> namedQuery = entityManager.createNamedQuery("find_all_cars", Car.class);

    if (namedQuery.getResultList().size() == 0) {
      throw new IllegalArgumentException("There are no cars in database");
    }

    return namedQuery.getResultList();
  }


  @Override
  public Car getById(Long id) {
    if (entityManager.find(Car.class, id) == null) {
      throw new IllegalArgumentException("Car with id " + id + " not found");
    }
    return entityManager.find(Car.class, id);
  }


  @Override
  public Car post(Maker maker, Integer engineCapacity, Integer numberOfSeats,
                  Date firstRegistrationDate, Date registrationCardIssueDate,
                  String registrationNumber) {

    Car car = new Car(maker, engineCapacity, numberOfSeats, firstRegistrationDate,
        registrationCardIssueDate, registrationNumber);
    return entityManager.merge(car);
  }


  @Override
  public List<Car> delete(Long id) {
    Car car = getById(id);
    try {
      entityManager.remove(car);
    } catch (Exception e) {
      throw new IllegalArgumentException("Car with id " + id + " not found");
    }
    return getAll();
  }


  @Override
  public Car put(Long id, Maker maker, Integer engineCapacity, Integer numberOfSeats,
                 Date firstRegistrationDate, Date registrationCardIssueDate,
                 String registrationNumber) {

    Car entryCar = getById(id);
    if (entryCar == null) {
      throw new IllegalArgumentException("Car with id " + id + " not found");
    }

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

    Car car = new Car(id, maker, engineCapacity, numberOfSeats, firstRegistrationDate,
        registrationCardIssueDate, registrationNumber);

    entityManager.merge(car);
    entityManager.flush();

    return entityManager.find(Car.class, id);
  }
}
