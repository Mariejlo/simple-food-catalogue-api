package com.cbfacademy.apiassessment.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.cbfacademy.foodcatalogue.subclassfooditem.service.FoodItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cbfacademy.foodcatalogue.subclassfooditem.controller.FoodItemController;
import com.cbfacademy.foodcatalogue.subclassfooditem.model.FoodItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebMvcTest(FoodItemController.class) // Focus only on the FoodItemController
public class FoodItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FoodItemService foodItemService; // Mock the service layer used by the controller

    private FoodItem testFoodItem;

    @BeforeEach
    public void setup() {
        // Initialize your test data here
        testFoodItem = new FoodItem(1L, "Test Food", 100, 5, 10, 20);
        Arrays.asList(testFoodItem);
       
    }

    // Test GET All FoodItems
    @SuppressWarnings("null")
    @Test
    public void whenGetAllFoodItems_thenReturnJsonArray() throws Exception {
        List<FoodItem> foodItemList = new ArrayList<>();
        foodItemList.add(testFoodItem);

        when(foodItemService.getAllFoodItems()).thenReturn(foodItemList);

        mockMvc.perform(get("/api/v1/foodItems")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(testFoodItem.getName())));
        
    }

    // Test GET FoodItem by ID
    @SuppressWarnings("null")
    @Test
    public void whenGetFoodItemById_thenReturnJson() throws Exception {
        when(foodItemService.getFoodItemById(testFoodItem.getId())).thenReturn(testFoodItem);

        mockMvc.perform(get("/api/v1/foodItems/{id}", testFoodItem.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(testFoodItem.getName())));
        
    }

    // Test POST Create FoodItem
    @SuppressWarnings("null")
    @Test
    public void whenPostFoodItem_thenCreateFoodItem() throws Exception {
        when(foodItemService.saveFoodItem(any(FoodItem.class))).thenReturn(testFoodItem);

        mockMvc.perform(post("/api/v1/foodItems")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(testFoodItem)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is(testFoodItem.getName())));
       
    }

    // Test PUT Update FoodItem
    @SuppressWarnings("null")
    @Test
    public void whenPutFoodItem_thenUpdateFoodItem() throws Exception {
        when(foodItemService.updateFoodItem(eq(testFoodItem.getId()), any(FoodItem.class))).thenReturn(testFoodItem);

        mockMvc.perform(put("/api/v1/foodItems/{id}", testFoodItem.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(testFoodItem)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(testFoodItem.getName())));
        
    }

    // Test DELETE FoodItem
    @SuppressWarnings("null")
    @Test
    public void whenDeleteFoodItem_thenRemoveFoodItem() throws Exception {
        doNothing().when(foodItemService).deleteFoodItem(testFoodItem.getId());

        mockMvc.perform(delete("/api/v1/foodItems/{id}", testFoodItem.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
        
    }

    // Convert object to JSON string for request bodies
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
