//package com.PBachta.KomisApp.Service;
//
//import com.PBachta.KomisApp.DataTypes.Maker;
//import com.PBachta.KomisApp.Entity.Car;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.sql.Date;
//import java.util.List;
//
////@Component
//@Repository
//@ConditionalOnProperty(prefix = "", name = "H2_STORAGE_ENABLED", havingValue="true")
//class CarServiceH2_1{
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//
//    public List<Car> getAll() {
//        return jdbcTemplate.query("select * from CarDatabase",
//                new BeanPropertyRowMapper<>(Car.class));
//    }
//
//
//    public Car getById(Long id) {
//        return jdbcTemplate.queryForObject("select * from CarDatabase where id=?", new Object[]{id},
//                new BeanPropertyRowMapper<>(Car.class));
//    }
//
//
//    public Car post(Maker maker, Integer engineCapacity, Integer numberOfSeats, String firstRegistrationDate, String registrationCardIssueDate, String registrationNumber) {
//        String makerS = maker.toString();
//
//       jdbcTemplate.update("insert into CarDatabase (id, maker, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber)"
//               +  "values(?, ?, ?, ?, ?, ?, ?)",
//               makerS, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber);
//        return getById(1L);
//    }
//
//
//    public List<Car> delete(Long id) {
//        jdbcTemplate.update("delete from CarDatabase where id = ?", id);
//        return getAll();
//    }
//
//
//    public Car put(Long id, Maker maker, Integer engineCapacity, Integer numberOfSeats, Date firstRegistrationDate, Date registrationCardIssueDate, String registrationNumber) {
//
//        Car car = getById(id);
//
//        if(maker == null)
//            maker = car.getMaker();
//        if(engineCapacity == null)
//            engineCapacity = car.getEngineCapacity();
//        if(numberOfSeats == null)
//            numberOfSeats = car.getNumberOfSeats();
//        if (firstRegistrationDate == null)
//            firstRegistrationDate = car.getFirstRegistrationDate();
//        if (registrationCardIssueDate == null)
//            registrationCardIssueDate = car.getRegistrationCardIssueDate();
//        if (registrationNumber == null)
//            registrationNumber = car.getRegistrationNumber();
//
//        String makerS = maker.toString();
//
//        jdbcTemplate.update("update CarDatabase" +" set maker = ?, engineCapacity = ?, numberOfSeats = ?, firstRegistrationDate = ?, registrationCardIssueDate = ?, registrationNumber = ?"
//                        +  " where id = ?",
//                makerS, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber, id);
//
//        return getById(id);
//    }
//}
