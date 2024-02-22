package com.cbfacademy.apiassessment.service;

import org.junit.jupiter.api.Test;
import com.cbfacademy.foodcatalogue.subclassfooditem.model.FoodItem;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
		 * This class tests the functionalities of the FoodItem model,
		 * especially the calculateTotalCalories method.
		 */
        public class FoodItemModelTest {
		
            @Test
            public void testCalculateTotalCalories() {
                // Arrange
                FoodItem foodItem = new FoodItem();
                foodItem.setCarbohydrates(10);
                foodItem.setProteins(10);
                foodItem.setFats(10);
                foodItem.setSugars(10);
                System.out.println(foodItem);
                System.out.println(foodItem.calculateTotalCalories());
    
                // Act
                char[] actualCalories = foodItem.calculateTotalCalories();
                System.out.println(actualCalories);
    
                // Assert
                double expectedCalories = (10 * 4) + (10 * 4) + (10 * 9);
                assertEquals(expectedCalories, foodItem.calculateTotalCalories());
                // ... add more test cases...
    
            }
    
        }
    
    
