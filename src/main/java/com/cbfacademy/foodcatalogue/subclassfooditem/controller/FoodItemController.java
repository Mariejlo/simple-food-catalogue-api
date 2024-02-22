package com.cbfacademy.foodcatalogue.subclassfooditem.controller; 
import com.cbfacademy.foodcatalogue.subclassfooditem.model.FoodItem;
import com.cbfacademy.foodcatalogue.subclassfooditem.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

//Class definition section
//Handles all customer interactions 
//Optional classes NutritionInfo.java and FoodCategory.java


@RestController //Controller class every method written HTTP response body
@RequestMapping("/api/v1/foodItems") //Set the base path for all methods
@Validated //FoodItem are automatically validated when they are received as input
public class FoodItemController {
    // Class body


    @Autowired  //Service injection 
    private FoodItemService foodItemService;

    @GetMapping("/")  //Fetches all the food items from the database (REVISION NEEDED)
         public List<FoodItem> getAllFoodItems() {
        return foodItemService.getAllFoodItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> getFoodItemById(@PathVariable("id") Long id) {
        FoodItem foodItem = foodItemService.getFoodItemById(id);
        return ResponseEntity.ok().body(foodItem);
    }

    @PostMapping("/")  ////@Valid if validation fails , Spring return 400 bad request response
    public ResponseEntity<FoodItem> createFoodItem(@Valid @RequestBody FoodItem foodItem) {
        FoodItem savedFoodItem = foodItemService.saveFoodItem(foodItem);
        return ResponseEntity.ok().body(savedFoodItem);
    }

    @PutMapping("/{id}")  //Fetches a specific food item/single responsibility by ID
    public ResponseEntity<FoodItem> updateFoodItem(@PathVariable("id") Long id, @RequestBody FoodItem foodItemDetails) {
        FoodItem updatedFoodItem = foodItemService.updateFoodItem(id, foodItemDetails);
        return ResponseEntity.ok().body(updatedFoodItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodItem(@PathVariable("id") Long id) {
        foodItemService.deleteFoodItem(id);
        return ResponseEntity.noContent().build();
    }
     //New endpoint for obtaining total calories and extras
     @PostMapping("/calculateCalories")
     public ResponseEntity<Double> calculateTotalCalories(@RequestBody List<FoodItem> foodItems) {
        double totalCalories = foodItemService.calculateTotalCalories(foodItems);
        return ResponseEntity.ok(totalCalories);
         
}
    // Additional methods for other operations can be added here
}

   