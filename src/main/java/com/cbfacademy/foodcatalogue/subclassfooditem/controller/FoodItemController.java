package com.cbfacademy.foodcatalogue.subclassfooditem.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//Class definition section
//Handles all customer interactions 
//Optional classes NutritionInfo.java and FoodCategory.java

@RestController // Controller class every method written HTTP response body
@RequestMapping("/") // Set the base path for all methods
@Validated // FoodItem are automatically validated when they are received as input
@CrossOrigin // This enables CORS for all endpoints in this controller
public class FoodItemController {
    // Class body

    @GetMapping("/fooditems") // Fetches all the food items from the database (REVISION NEEDED)
    public String getAllFoodItems() {
        System.out.println(" inside controller");
        return "preparing to exit controller";

    }
    /*
     * @GetMapping("/{id}")
     * public ResponseEntity<FoodItem> getFoodItemById(@PathVariable("id") Long id)
     * {
     * FoodItem foodItem = foodItemService.getFoodItemById(id);
     * return ResponseEntity.ok().body(foodItem);
     * }
     * 
     * @PostMapping("/") //// @Valid if validation fails , Spring return 400 bad
     * request response
     * public ResponseEntity<FoodItem> createFoodItem(@Valid @RequestBody FoodItem
     * foodItem) throws IOException {
     * FoodItem savedFoodItem = foodItemService.saveFoodItem(foodItem);
     * return ResponseEntity.ok().body(savedFoodItem);
     * }
     * 
     * @PutMapping("/{id}") // Fetches a specific food item/single responsibility by
     * ID
     * public ResponseEntity<FoodItem> updateFoodItem(@PathVariable("id") Long
     * id, @RequestBody FoodItem foodItemDetails) {
     * FoodItem updatedFoodItem = foodItemService.updateFoodItem(id,
     * foodItemDetails);
     * return ResponseEntity.ok().body(updatedFoodItem);
     * }
     * 
     * @DeleteMapping("/{id}")
     * public ResponseEntity<Void> deleteFoodItem(@PathVariable("id") Long id) {
     * foodItemService.deleteFoodItem(id);
     * return ResponseEntity.noContent().build();
     * }
     * 
     * // New endpoint for obtaining total calories and extras
     * 
     * @PostMapping("/calculateCalories")
     * public ResponseEntity<Double> calculateTotalCalories(@RequestBody
     * List<FoodItem> foodItems) {
     * double totalCalories = foodItemService.calculateTotalCalories(foodItems);
     * return ResponseEntity.ok(totalCalories);
     * 
     * }
     */

}
