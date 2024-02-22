package com.cbfacademy.foodcatalogue.subclassfooditem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbfacademy.foodcatalogue.subclassfooditem.repository.FoodItemRepository;

@Service
public class FoodItemServiceImpl {
    @Autowired // Service injection
    private FoodItemRepository foodItemRepository;

    public void serviceMethod() {
        System.out.println("Inside service method");
        foodItemRepository.repositoryMethod();
    }

    /*
     * private final FoodItemRepository foodItemRepository;
     * 
     * public FoodItemServiceImpl(FoodItemRepository foodItemRepository) {
     * this.foodItemRepository = foodItemRepository;
     * }
     * 
     * @Override
     * public FoodItem saveFoodItem(FoodItem foodItem) throws IOException {
     * 
     * // Ensure this method is implemented
     * return foodItemRepository.saveFoodItem(foodItem);
     * }
     * 
     * @Override
     * public List<FoodItem> getAllFoodItems() {
     * return foodItemRepository.getAllFoodItems();
     * }
     * 
     * 
     * @Override
     * public FoodItem getFoodItemById(Long id) throws ResourceNotFoundException {
     * return foodItemRepository.getFoodItemById(id);
     * 
     * }
     * 
     * @Override
     * public FoodItem updateFoodItem(Long id, FoodItem foodItemDetails) throws
     * ResourceNotFoundException {
     * FoodItem existingFoodItem = foodItemRepository.getFoodItemById(id);
     * existingFoodItem.setName(foodItemDetails.getName());
     * existingFoodItem.setCalories(foodItemDetails.getCalories());
     * existingFoodItem.setServingSize(foodItemDetails.getServingSize());
     * // Assuming save() to update the food item
     * return foodItemRepository.save(existingFoodItem);
     * 
     * }
     * 
     * @Override
     * public void deleteFoodItem(Long id) throws ResourceNotFoundException {
     * foodItemRepository.deleteFoodItem(id);
     * }
     * 
     * @Override
     * public double calculateTotalCalories(List<FoodItem> foodItems) {
     * return foodItems.stream()
     * .mapToDouble(FoodItem::getCalories) // Use the method from the FoodItem class
     * .sum();
     * }
     */
}
