package com.example.grocesry.Service;

import com.example.grocesry.Model.GroceryItem;
import com.example.grocesry.Repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {

    @Autowired
    private GroceryRepository groceryRepository;

    public List<GroceryItem> getAllItems() {
        return groceryRepository.findAll();
    }

    public GroceryItem addItem(GroceryItem item) {
        return groceryRepository.save(item);
    }

    public GroceryItem updateItem(Long id, GroceryItem itemDetails) {
        GroceryItem item = groceryRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        item.setName(itemDetails.getName());
        item.setCategory(itemDetails.getCategory());
        item.setPrice(itemDetails.getPrice());
        item.setStock(itemDetails.getStock());
        return groceryRepository.save(item);
    }

    public void deleteItem(Long id) {
        groceryRepository.deleteById(id);
    }
}