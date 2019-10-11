package com.blessy.application;

import com.blessy.application.model.Continent;
import com.blessy.application.model.Country;
import com.blessy.application.service.ContinentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private ContinentService continentService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("qwertyuiop"+continentService);
        for (Continent continent:continentService.findAll()
             ) {
            logger.info(continent.getName());
            for (Country country:continent.getCountries()
                 ) {
                logger.info("  "+country.getName());
            }

        }
    }
}
