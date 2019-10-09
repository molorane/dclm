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
import java.util.Optional;

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
        Optional<Continent> list = continentService.findById(1);

        for (Country country:list.map(continent -> continent.getCountries()).get()) {
            logger.info("   "+country.getId()+" "+country.getName());
        }
    }
}
