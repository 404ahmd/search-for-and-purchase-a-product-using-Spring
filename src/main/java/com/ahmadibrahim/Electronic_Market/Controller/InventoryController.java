package com.ahmadibrahim.Electronic_Market.Controller;

import com.ahmadibrahim.Electronic_Market.DTO.BuyProductRequest;
import com.ahmadibrahim.Electronic_Market.Entity.Inventory;
import com.ahmadibrahim.Electronic_Market.Repository.InventoryRepository;
import com.ahmadibrahim.Electronic_Market.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.List;

@RestController
public class InventoryController {

    private static final DecimalFormat df = new DecimalFormat("#");
    @Autowired
    private InventoryRepository productRepository;
    @Autowired
    private InventoryService inventoryService;

    @GetMapping(
            path = "/test"
    )
    public String testPage(Model model){
        model.addAttribute("Test", inventoryService.getAllProducts());
        return "test";
    }
     @GetMapping("/get")
  public List<Inventory> getAllProducts(){
        return inventoryService.getAllProducts();
    }

   @PostMapping(
           path = "/buy"
   )
   public String buyProduct(@RequestParam String productName, @RequestParam int quantity){
        try{
            Inventory product = inventoryService.buyProduct(productName, quantity);
            double totalPrice = product.getPrice() * quantity;
            return "PURCHASE SUCCESFULL !! total price = Rp." + df.format(totalPrice);
        }catch (Exception e){
            return e.getMessage();
        }
   }

}
