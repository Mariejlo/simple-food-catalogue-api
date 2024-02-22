package com.cbfacademy.foodcatalogue.subclassfooditem.service;

import java.io.IOException;
import java.util.List;

import com.cbfacademy.foodcatalogue.subclassfooditem.exception.ResourceNotFoundException;
import com.cbfacademy.foodcatalogue.subclassfooditem.model.FoodItem;
/**
 * Service interface for managing FoodItems.
 * This interface defines the contract for FoodItem-related operations.
 */
public interface FoodItemService {

    // Adds a new FoodItem to the database
    FoodItem saveFoodItem(FoodItem foodItem) throws IOException;

    // Retrieves all FoodItems from the database
    List<FoodItem> getAllFoodItems();

    // Retrieves a FoodItem by its ID
    FoodItem getFoodItemById(Long id) throws ResourceNotFoundException;

    // Updates a FoodItem in the database
    FoodItem updateFoodItem(Long id, FoodItem foodItemDetails) throws ResourceNotFoundException;

    // Deletes a FoodItem from the database by its ID
    void deleteFoodItem(Long id) throws ResourceNotFoundException;

    // Define the signature of the calculateTotalCalories method
    double calculateTotalCalories(List<FoodItem> foodItems);

}
