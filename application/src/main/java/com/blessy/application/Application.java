package com.blessy.application;

import com.blessy.application.model.Continent;
import com.blessy.application.model.Country;
import com.blessy.application.service.IContinentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private IContinentService continentService;

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Continent> list = continentService.findAll();

        for (Continent continent:
             list) {
            logger.info(continent.getId()+" "+continent.getName());
            for (Country country:
                 continent.getCountries()) {
                logger.info(country.getId()+" "+country.getName());
            }
        }
    }
}
