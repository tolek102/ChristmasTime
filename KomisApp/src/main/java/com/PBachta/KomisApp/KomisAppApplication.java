package com.PBachta.KomisApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KomisAppApplication {

  public static void main(String[] args) {

    SpringApplication.run(KomisAppApplication.class, args);

    final Logger log = LoggerFactory.getLogger(KomisAppApplication.class);
    log.info((char) 27 + "[46m To open Swagger documentation please go to:"+
             (char) 27 + "[0m" +" http://localhost:8080/swagger-ui.html" );
  }
}