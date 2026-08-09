package com.foodplatform.grocerre.service;

import com.foodplatform.grocerre.entity.Grocery;
import com.foodplatform.grocerre.repository.GroceryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryService {

    private final GroceryRepository groceryRepository;

    public GroceryService(GroceryRepository groceryRepository) {
        this.groceryRepository = groceryRepository;
    }

    public List<Grocery> getAllGroceries() {
        return groceryRepository.findAll();
    }

    public Optional<Grocery> getGroceryById(Long id) {
        return groceryRepository.findById(id);
    }

    public Grocery createGrocery(Grocery grocery) {
        return groceryRepository.save(grocery);
    }

    public Optional<Grocery> updateGrocery(Long id, Grocery updatedGrocery) {

        return groceryRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedGrocery.getName());
                    existing.setCategory(updatedGrocery.getCategory());
                    existing.setPrice(updatedGrocery.getPrice());
                    existing.setAvailable(updatedGrocery.isAvailable());

                    return groceryRepository.save(existing);
                });
    }

    public boolean deleteGrocery(Long id) {

        if (!groceryRepository.existsById(id)) {
            return false;
        }

        groceryRepository.deleteById(id);
        return true;
    }
}
