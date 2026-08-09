package com.foodplatform.dineout.repository;

import com.foodplatform.dineout.entity.Dineout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DineoutRepository extends JpaRepository<Dineout, Long> {
}
