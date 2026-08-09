package com.foodplatform.food.config;

import com.foodplatform.food.entity.Food;
import com.foodplatform.food.repository.FoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadData(FoodRepository foodRepository) {

        return args -> {

            foodRepository.save(
                    new Food(
                            "Chicken Biryani",
                            "Biryani",
                            new BigDecimal("220.00"),
                            true
                    )
            );

            foodRepository.save(
                    new Food(
                            "Paneer Biryani",
                            "Biryani",
                            new BigDecimal("180.00"),
                            true
                    )
            );

            foodRepository.save(
                    new Food(
                            "Chicken Fried Rice",
                            "Rice",
                            new BigDecimal("160.00"),
                            true
                    )
            );

            foodRepository.save(
                    new Food(
                            "Veg Noodles",
                            "Noodles",
                            new BigDecimal("130.00"),
                            true
                    )
            );
        };
    }
}
