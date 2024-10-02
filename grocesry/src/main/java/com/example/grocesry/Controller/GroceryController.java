package com.example.grocesry.Controller;
import com.example.grocesry.Model.GroceryItem;
import com.example.grocesry.Service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groceries")
public class GroceryController {

    @Autowired
    private GroceryService groceryService;

    @GetMapping
    public List<GroceryItem> getAllItems() {
        return groceryService.getAllItems();
    }

    @PostMapping
    public GroceryItem createItem(@RequestBody GroceryItem item) {
        return groceryService.addItem(item);
    }

    @PutMapping("/{id}")
    public GroceryItem updateItem(@PathVariable Long id, @RequestBody GroceryItem itemDetails) {
        return groceryService.updateItem(id, itemDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        groceryService.deleteItem(id);
        return ResponseEntity.ok().build();
    }
}