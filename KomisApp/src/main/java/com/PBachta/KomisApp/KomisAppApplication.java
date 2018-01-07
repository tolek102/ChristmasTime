package com.PBachta.KomisApp;

import com.PBachta.KomisApp.DataTypes.Maker;
import com.PBachta.KomisApp.Entity.Car;
import com.PBachta.KomisApp.Entity.Customer;
import com.PBachta.KomisApp.Repository.CarRepository;
import com.PBachta.KomisApp.Repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoField.YEAR;

@SpringBootApplication
public class KomisAppApplication{

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private CustomerRepository customersRepository;

	public static void main(String[] args) {

		SpringApplication.run(KomisAppApplication.class, args);

		final Logger log = LoggerFactory.getLogger(KomisAppApplication.class);
		log.info((char)27 +"[42mTo open Swagger documentation please go to: http://localhost:8080/swagger-ui.html"+(char)27+"[0m");

		log.info(String.valueOf(LocalDate.now()));

        Integer year=1998;
        Integer month=2;
        Integer dayOfMonth=20;

        log.info(String.valueOf(LocalDate.of(year,month,dayOfMonth)));
        log.info(String.valueOf(LocalDate.of(year,month,dayOfMonth).isAfter(LocalDate.now())));

	}


	//Adding example inputs to database
	@Component
	public class DataInitializer {
		@PostConstruct
		public void initDat() {
			carRepository.save(new Car(Maker.HONDA,1,1, "1998-01-05", "1998-02-05", "AB1"));
			carRepository.save(new Car(Maker.FIAT,2,2,"1999-01-05","2000-03-08","CD2"));
			carRepository.save(new Car(Maker.SKODA,3,3,"1993-10-20","1994-01-05","EF3"));
			carRepository.save(new Car(Maker.HONDA,4,4,"1998-11-05","1998-12-01","GH4"));

			customersRepository.save(new Customer("Jan", "Kowalski", "NHW399139", "43062460106"));
			customersRepository.save(new Customer("Adam", "Nowak", "KQL847332", "07240779183"));
			customersRepository.save(new Customer("Zygfryd", "Kopytko", "EIS182302", "79121576859"));
			customersRepository.save(new Customer("Andrzej", "Zawada", "EXY304697", "65020522882"));
		}
	}
}