package com.cbfacademy.foodcatalogue.subclassfooditem.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodcatalogue.model.FoodItem;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodItemRepository {

    private static final String FILE_NAME = "src/main/resources/fooditems.json";
    private static List<FoodItem> foodItemList;

    static {
        try {
            foodItemList = readFoodItemsFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<FoodItem> readFoodItemsFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(FILE_NAME);
        return mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, FoodItem.class));
    }

    private static void writeFoodItemsToFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(FILE_NAME);
        mapper.writeValue(file, foodItemList);
    }

    public List<FoodItem> getAllFoodItems() {
        return foodItemList;
    }

    public FoodItem getFoodItemById(long id) {
        return foodItemList.stream().filter(foodItem -> foodItem.getId() == id).findFirst().orElse(null);
    }

    public FoodItem saveFoodItem(FoodItem foodItem) {
        foodItemList.add(foodItem);
        try {
            writeFoodItemsToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return foodItem;
    }

    public FoodItem updateFoodItem(FoodItem foodItem) {
        FoodItem existingFoodItem = getFoodItemById(foodItem.getId());
        if (existingFoodItem != null) {
            int index = foodItemList.indexOf(existingFoodItem);
            foodItemList.set(index, foodItem);
            try {
                writeFoodItemsToFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return foodItem;
    }

    public void deleteFoodItem(long id) {
        FoodItem foodItem = getFoodItemById(id);
        if (foodItem != null) {
            foodItemList.remove(foodItem);
            try {
                writeFoodItemsToFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

