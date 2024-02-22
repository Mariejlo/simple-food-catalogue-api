package com.cbfacademy.foodcatalogue.subclassfooditem.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.cbfacademy.foodcatalogue.subclassfooditem.service.FoodItemService;
import com.cbfacademy.foodcatalogue.subclassfooditem.model.FoodItem;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FoodItemController.class) // Focus only on the FoodItemController
public class FoodItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FoodItemService foodItemService; // Mock the service layer used by the controller

    private List<FoodItem> foodItemList;
    private FoodItem testFoodItem;

    @BeforeEach
    public void setup() {
        // Initialize your test data here
        testFoodItem = new FoodItem(/* parameters */);
        foodItemList = Arrays.asList(testFoodItem);
        // Other setup actions...
    }

    // Test GET All FoodItems
    @Test
    public void whenGetAllFoodItems_thenReturnJsonArray() throws Exception {
        when(foodItemService.getAllFoodItems()).thenReturn(foodItemList);

        mockMvc.perform(get("/api/v1/foodItems")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(testFoodItem.getName())));
        // Add more assertions as needed
    }

    // Test GET FoodItem by ID
    @Test
    public void whenGetFoodItemById_thenReturnJson() throws Exception {
        when(foodItemService.getFoodItemById(testFoodItem.getId())).thenReturn(testFoodItem);

        mockMvc.perform(get("/api/v1/foodItems/{id}", testFoodItem.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(testFoodItem.getName())));
        // Add more assertions as needed
    }

    // Test POST Create FoodItem
    @Test
    public void whenPostFoodItem_thenCreateFoodItem() throws Exception {
        when(foodItemService.saveFoodItem(any(FoodItem.class))).thenReturn(testFoodItem);

        mockMvc.perform(post("/api/v1/foodItems")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(testFoodItem)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is(testFoodItem.getName())));
        // Add more assertions as needed
    }

    // Test PUT Update FoodItem
    @Test
    public void whenPutFoodItem_thenUpdateFoodItem() throws Exception {
        when(foodItemService.updateFoodItem(eq(testFoodItem.getId()), any(FoodItem.class))).thenReturn(testFoodItem);

        mockMvc.perform(put("/api/v1/foodItems/{id}", testFoodItem.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(testFoodItem)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(testFoodItem.getName())));
        // Add more assertions as needed
    }

    // Test DELETE FoodItem
    @Test
    public void whenDeleteFoodItem_thenRemoveFoodItem() throws Exception {
        doNothing().when(foodItemService).deleteFoodItem(testFoodItem.getId());

        mockMvc.perform(delete("/api/v1/foodItems/{id}", testFoodItem.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
        // Add more assertions as needed
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
