package com.cbfacademy.apiassessment.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cbfacademy.apiassessment.model.FoodItem;
import com.cbfacademy.apiassessment.repository.FoodItemRepository;
import com.cbfacademy.foodcatalogue.subclassfooditem.service.FoodItemService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class) // Mock creation of the service talks to JUnit 
public class FoodItemServiceTest {
    
    //Test for the service
    @Mock //Mock instance implementation of the FoodItemRepository
    private FoodItemRepository foodItemRepository;

    @InjectMocks  //Creates an instance of the service
    private FoodItemService foodItemService;

    private FoodItem testFoodItem;

    @BeforeEach
    void setUp() {
         // Initialize your FoodItem object here with the required parameters
        testFoodItem = new FoodItem(); // Initialize your FoodItem object here
        testFoodItem.setId(1L);
        testFoodItem.setName("Test Food");
        testFoodItem.setCalories(100);
        testFoodItem.setFats(5);
        testFoodItem.setProteins(10);
        testFoodItem.setCarbohydrates(20);
    }

    // Test for saving a food item successfully
    @Test //Single functionality test
    void whenSaveFoodItem_thenReturnFoodItem() {
        // Arrange
        when(foodItemRepository.save(any(FoodItem.class))).thenReturn(savedFoodItem);

        // Act: call the method you are testing
        FoodItem result = foodItemService.saveFoodItem(testFoodItem);

        // Assert: checks that the results are as expected
        assertNotNull(result, "The saved food item should not be null");
        assertEquals(testFoodItem.getName(), result.getName(), "The name of the result should match the input");
        // Verify interactions with the mock
        verify(foodItemRepository).save(testFoodItem);
    } 
       
       
    @Test // calculates the total calories helps to ensure that the method works correctly
    void whenCalculateTotalCalories_thenReturnCorrectValue() {
        List<FoodItem> foodItemList = List.of(testFoodItem);  // Create a list containing the test food item
        
        
        // Act: Calculate the total calories
        double totalCalories = foodItemService.calculateTotalCalorie(foodItems); 
        // Assert: checks that the calories results are as expected
        double expectedCalories = 100; // Update this with the correct calculation based on your logic
        assertEquals(expectedCalories, totalCalories, "The calculated total calories should match the expected value");
    

        assertNotNull(totalCalories), "The result should not be null";
        assertEquals(100 * 4 + 20 * 9 + 30 * 4 + 50 * 4, totalCalories), "The result should be the same as the input";

        
        
    // Test for fetching all food items successfully
    @Test
    void whenGetAllFoodItems_thenReturnFoodItemList() {
        // Arrange: Create a list of FoodItems and set the repository to return this list when findAll is called
        List<FoodItem> expectedList = new ArrayList<>();
        expectedList.add(testFoodItem);
        when(foodItemRepository.findAll()).thenReturn(expectedList);

        // Act: Call the method under test
        List<FoodItem> result = foodItemService.getAllFoodItems();

        // Assert: Check that the returned list matches the mock list
        assertNotNull(result, "The food item list should not be null");
        assertFalse(result.isEmpty(), "The food item list should not be empty");
        assertEquals(expectedList.size(), result.size(), "The size of the result list should match the expected list");
        
        // Verify interactions with the mock
        verify(foodItemRepository).findAll();
    }
            
        
}
        

