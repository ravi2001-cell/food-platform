package com.foodplatform.dineout.controller;

import com.foodplatform.dineout.entity.Dineout;
import com.foodplatform.dineout.service.DineoutService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dineouts")
public class DineoutController {

    private final DineoutService dineoutService;

    public DineoutController(DineoutService dineoutService) {
        this.dineoutService = dineoutService;
    }

    @GetMapping
    public List<Dineout> getAllRestaurants() {
        return dineoutService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dineout> getRestaurantById(@PathVariable Long id) {
        return dineoutService.getRestaurantById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Dineout> createRestaurant(
            @Valid @RequestBody Dineout dineout) {
        return ResponseEntity.ok(dineoutService.createRestaurant(dineout));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dineout> updateRestaurant(
            @PathVariable Long id,
            @Valid @RequestBody Dineout dineout) {
        return dineoutService.updateRestaurant(id, dineout)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        if (!dineoutService.deleteRestaurant(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
