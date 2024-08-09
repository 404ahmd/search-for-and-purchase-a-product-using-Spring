package com.ahmadibrahim.Electronic_Market.Repository;

import com.ahmadibrahim.Electronic_Market.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

   List<Inventory> findAll();
   Optional<Inventory> findByName(String name);

}
