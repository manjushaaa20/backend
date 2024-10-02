package com.example.grocesry.Repository;

import com.example.grocesry.Model.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryRepository extends JpaRepository<GroceryItem , Long> {
}