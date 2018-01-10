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
//import java.util.List;
//
////@Component
//@Repository
//@ConditionalOnProperty(prefix = "", name = "H2_STORAGE_ENABLED", havingValue="true")
//class CarServiceH2 implements CarServiceInteface {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public List<Car> getAll() {
//
//        return jdbcTemplate.query("select * from CarDatabase",
//                new BeanPropertyRowMapper<>(Car.class));
//}
//
//    @Override
//   public Car getById(Long id) {
//
//        return jdbcTemplate.queryForObject("select * from CarDatabase where id=?", new Object[]{id},
//                new BeanPropertyRowMapper<>(Car.class));
//    }
//
//    @Override
//    public Car post(Maker maker, Integer engineCapacity, Integer numberOfSeats, String firstRegistrationDate, String registrationCardIssueDate, String registrationNumber) {
//
//
////        String a = jdbcTemplate.queryForList("SELECT MAX(ID) FROM CARDATABASE").toString().replace("[{MAX(ID)=","").replace("}]","");
//        String makerS = maker.toString();
////        Long id =  getAll().size() + 1L;
//        //Long id = Long.valueOf(a);
////        System.out.println("cccccccccccccccccccccccccccccccccccccccccccccccccccccc "+ a);
////        System.out.println("cccccccccccccccccccccccccccccccccccccccccccccccccccccc "+ Long.valueOf(a));
//
//       jdbcTemplate.update("insert into CarDatabase (id, maker, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber)"
//                        +  "values(?, ?, ?, ?, ?, ?, ?)",
//               makerS, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber);
//        return getById(1L);
//    }
//
//    @Override
//    public List<Car> delete(Long id) {
//
//        jdbcTemplate.update("delete from CarDatabase where id = ?", id);
//        return getAll();
//    }
//
//    @Override
//    public Car put(Long id, Maker maker, Integer engineCapacity, Integer numberOfSeats, String firstRegistrationDate, String registrationCardIssueDate, String registrationNumber) {
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
