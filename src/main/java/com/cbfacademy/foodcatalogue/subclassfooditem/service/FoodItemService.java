package com.example.foodcatalogue.service;

import com.example.foodcatalogue.exception.ResourceNotFoundException;
import com.example.foodcatalogue.model.FoodItem;
import com.example.foodcatalogue.repository.FoodItemRepository;

import java.util.List;
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
