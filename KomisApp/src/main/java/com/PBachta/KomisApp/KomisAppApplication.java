package com.PBachta.KomisApp;

import com.PBachta.KomisApp.Entity.Car;
import com.PBachta.KomisApp.Entity.Customer;
import com.PBachta.KomisApp.Repository.CarRepository;
import com.PBachta.KomisApp.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class KomisAppApplication{

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private CustomerRepository customersRepository;

	public static void main(String[] args) {

		SpringApplication.run(KomisAppApplication.class, args);
	}


    //Adding example inputs to database
	@Component
	public class DataInitializer {
		@PostConstruct
		public void initDat() {
			carRepository.save(new Car("Subaru", "Legacy", "ZS85H55", "4S3BP616556397994"));
            carRepository.save(new Car("Dodge","Caliber","ZGR02GU","1B3HB28B18D508661"));
            carRepository.save(new Car("Jeep","Patriot","ZSW1523","1J4FT28A99D140347"));
            carRepository.save(new Car("Ford","Expedition","ZPL18KL","1FMRU15W61LA66899"));

            customersRepository.save(new Customer("Jan", "Kowalski", "NHW399139", "43062460106"));
            customersRepository.save(new Customer("Adam", "Nowak", "KQL847332", "07240779183"));
            customersRepository.save(new Customer("Zygfryd", "Kopytko", "EIS182302", "79121576859"));
            customersRepository.save(new Customer("Andrzej", "Zawada", "EXY304697", "65020522882"));
		}
	}
}
