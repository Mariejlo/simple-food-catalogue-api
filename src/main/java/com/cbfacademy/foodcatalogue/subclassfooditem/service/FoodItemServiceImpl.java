package com.cbfacademy.foodcatalogue.subclassfooditem.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cbfacademy.foodcatalogue.subclassfooditem.exception.ResourceNotFoundException;
import com.cbfacademy.foodcatalogue.subclassfooditem.model.FoodItem;
import com.cbfacademy.foodcatalogue.subclassfooditem.repository.FoodItemRepository;

@Service
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
        return foodItemRepository.getFoodItemById(id);

    }

    @Override
    public FoodItem updateFoodItem(Long id, FoodItem foodItemDetails) throws ResourceNotFoundException {
        FoodItem existingFoodItem = foodItemRepository.getFoodItemById(id);
        existingFoodItem.setName(foodItemDetails.getName());
        existingFoodItem.setCalories(foodItemDetails.getCalories());
        existingFoodItem.setServingSize(foodItemDetails.getServingSize());
        // Assuming save() to update the food item
        return foodItemRepository.save(existingFoodItem);

    }

    @Override
    public void deleteFoodItem(Long id) throws ResourceNotFoundException {
        foodItemRepository.deleteFoodItem(id);
    }

    @Override
    public double calculateTotalCalories(List<FoodItem> foodItems) {
        return foodItems.stream()
                .mapToDouble(FoodItem::getCalories) // Use the method from the FoodItem class
                .sum();
    }

}
