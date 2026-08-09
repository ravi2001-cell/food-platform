package com.foodplatform.grocerre.config;

import com.foodplatform.grocerre.entity.Grocery;
import com.foodplatform.grocerre.repository.GroceryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadData(GroceryRepository repository) {

        return args -> {

            repository.save(new Grocery(
                    "Rice",
                    "Staples",
                    new BigDecimal("65.00"),
                    true
            ));

            repository.save(new Grocery(
                    "Milk",
                    "Dairy",
                    new BigDecimal("60.00"),
                    true
            ));

            repository.save(new Grocery(
                    "Eggs",
                    "Dairy",
                    new BigDecimal("90.00"),
                    true
            ));

            repository.save(new Grocery(
                    "Tomatoes",
                    "Vegetables",
                    new BigDecimal("40.00"),
                    true
            ));
        };
    }
}
