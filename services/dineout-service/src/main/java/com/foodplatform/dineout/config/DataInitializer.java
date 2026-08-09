package com.foodplatform.dineout.config;

import com.foodplatform.dineout.entity.Dineout;
import com.foodplatform.dineout.repository.DineoutRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadData(DineoutRepository repository) {
        return args -> {
            repository.save(new Dineout(
                    "Spice Garden",
                    "Indian",
                    "Hyderabad",
                    new BigDecimal("500.00"),
                    true
            ));

            repository.save(new Dineout(
                    "Tandoori House",
                    "North Indian",
                    "Hyderabad",
                    new BigDecimal("700.00"),
                    true
            ));

            repository.save(new Dineout(
                    "Dragon Palace",
                    "Chinese",
                    "Hyderabad",
                    new BigDecimal("600.00"),
                    true
            ));

            repository.save(new Dineout(
                    "Pizza Corner",
                    "Italian",
                    "Hyderabad",
                    new BigDecimal("450.00"),
                    true
            ));
        };
    }
}
