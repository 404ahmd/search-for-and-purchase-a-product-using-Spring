package com.ahmadibrahim.Electronic_Market.Service;

import com.ahmadibrahim.Electronic_Market.DTO.BuyProductRequest;
import com.ahmadibrahim.Electronic_Market.Entity.Inventory;
import com.ahmadibrahim.Electronic_Market.Repository.InventoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class InventoryService {

    private static final Logger logger = Logger.getLogger(InventoryService.class.getName());
    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getAllProducts(){
        List<Inventory> products = inventoryRepository.findAll();
        logger.info("Fetched products : " + products.size());
        return products;
    }

    @Transactional
    public Inventory buyProduct(String productName, int quantity)throws Exception {

        Optional<Inventory> optionalProduct = inventoryRepository.findByName(productName.toLowerCase());

        if (optionalProduct.isPresent()) {

            Inventory product = optionalProduct.get();

            if (product.getAmount() >= quantity) {
                product.setAmount(product.getAmount() - quantity);
                inventoryRepository.save(product);
                return product;
            } else {
                throw new Exception("INSUFFICIENT QUANTITY");
            }

        } else {
            throw new Exception("PRODUCT NOT FOUND");
        }

    }
}
