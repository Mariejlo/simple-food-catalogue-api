package com.example.foodcatalogue.service;

import com.example.foodcatalogue.exception.ResourceNotFoundException;
import com.example.foodcatalogue.model.FoodItem;
import com.example.foodcatalogue.repository.FoodItemRepository;

import java.io.IOException;
import java.util.List;

public class FoodItemServiceImpl implements FoodItemService {

    private final FoodItemRepository foodItemRepository;

    public FoodItemServiceImpl(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    @Override
    public FoodItem saveFoodItem(FoodItem foodItem) throws IOException {
        // Validate foodItem before saving (optional)
        // Ensure this method is implemented
        return foodItemRepository.saveFoodItem(foodItem);
    }

    @Override
    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.getAllFoodItems();
    }

    @Override
    public FoodItem getFoodItemById(Long id) throws ResourceNotFoundException {
        return foodItemRepository.getFoodItemById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FoodItem", "id", id));
    }

    @Override
    public FoodItem updateFoodItem(Long id, FoodItem foodItemDetails) throws ResourceNotFoundException {
        FoodItem existingFoodItem = foodItemRepository.getFoodItemById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FoodItem", "id", id));

        // Logic to update a food item
        // Call the method to update properties
        existingFoodItem.setDescription(foodItemDetails.getDescription());
        existingFoodItem.setPrice(foodItemDetails.getPrice());
        return foodItemRepository.save(existingFoodItem); // Return the updated food item
    }

    @Override
    public void deleteFoodItem(Long id) throws ResourceNotFoundException {
        foodItemRepository.deleteFoodItem(id);
    }

    @Override
    public double calculateTotalCalories(List<FoodItem> foodItems) {
        return foodItems.stream()
                .mapToDouble(FoodItem::getCalories) //Use the method from the FoodItem class
                .sum();
    }

}
