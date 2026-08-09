package com.foodplatform.dineout.service;

import com.foodplatform.dineout.entity.Dineout;
import com.foodplatform.dineout.repository.DineoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DineoutService {

    private final DineoutRepository dineoutRepository;

    public DineoutService(DineoutRepository dineoutRepository) {
        this.dineoutRepository = dineoutRepository;
    }

    public List<Dineout> getAllRestaurants() {
        return dineoutRepository.findAll();
    }

    public Optional<Dineout> getRestaurantById(Long id) {
        return dineoutRepository.findById(id);
    }

    public Dineout createRestaurant(Dineout dineout) {
        return dineoutRepository.save(dineout);
    }

    public Optional<Dineout> updateRestaurant(Long id, Dineout updatedDineout) {
        return dineoutRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedDineout.getName());
                    existing.setCuisine(updatedDineout.getCuisine());
                    existing.setLocation(updatedDineout.getLocation());
                    existing.setAveragePrice(updatedDineout.getAveragePrice());
                    existing.setAvailable(updatedDineout.isAvailable());
                    return dineoutRepository.save(existing);
                });
    }

    public boolean deleteRestaurant(Long id) {
        if (!dineoutRepository.existsById(id)) {
            return false;
        }

        dineoutRepository.deleteById(id);
        return true;
    }
}
