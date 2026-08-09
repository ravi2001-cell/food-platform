package com.foodplatform.grocerre.controller;

import com.foodplatform.grocerre.entity.Grocery;
import com.foodplatform.grocerre.service.GroceryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groceries")
public class GroceryController {

    private final GroceryService groceryService;

    public GroceryController(GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @GetMapping
    public List<Grocery> getAllGroceries() {
        return groceryService.getAllGroceries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grocery> getGroceryById(@PathVariable Long id) {

        return groceryService.getGroceryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Grocery> createGrocery(
            @Valid @RequestBody Grocery grocery) {

        return ResponseEntity.ok(
                groceryService.createGrocery(grocery)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grocery> updateGrocery(
            @PathVariable Long id,
            @Valid @RequestBody Grocery grocery) {

        return groceryService.updateGrocery(id, grocery)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrocery(@PathVariable Long id) {

        if (!groceryService.deleteGrocery(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
