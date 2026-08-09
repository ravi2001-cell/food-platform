package com.foodplatform.grocerre.repository;

import com.foodplatform.grocerre.entity.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryRepository extends JpaRepository<Grocery, Long> {
}
