package com.cbfacademy.foodcatalogue.subclassfooditem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import com.cbfacademy.foodcatalogue.FoodCatalogue;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Represents a specific food item in the catalogue.
 */
@Entity
public class FoodItem extends FoodCatalogue {
    // FoodItem specific attributes, constructors, methods
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Unique identifier for each food item (check if private is needed?)

    @NotNull(message = "Name cannot be null") // Ensures field not null
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters") // Filed size within range private
                                                                                     // String name;
    @Column(name = "food_name", nullable = false, length = 100)
    private String name; // Name of the food item

    @NotNull(message = "Serving size cannot be null")
    private String servingSize; // Describes the serving size of the food (e.g.,"100g","1 cup")

    @NotNull(message = "Calories per serving cannot be null")
    private Integer caloriesPerServing; // Number of calories per serving (e.g. 100, 1000)
    // If we got extra time more attributes like price, category will be added

    public FoodItem() {
        // No argument constructor
    }

    // Constructor with all the attributes
    public FoodItem(Long id, String name, String servingSize, Integer caloriesPerServing) {
        this.id = id;
        this.name = name;
        this.servingSize = servingSize;
        this.caloriesPerServing = caloriesPerServing;
    }

    // Getters and setters for all attributes

    @Override
    public String toString() {
        return "FoodItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", servingSize='" + servingSize + '\'' +
                ", caloriesPerServing=" + caloriesPerServing +
                '}';

    }

    @Override
    public void displayDetails() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayDetails'");
    }

    @Override
    public void calculateNutrition() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateNutrition'");
    }

    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    public void setName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setName'");
    }

    public Integer getCalories() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCalories'");
    }

    public void setCalories(Integer calories) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCalories'");
    }

    public String getServingSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getServingSize'");
    }

    public void setServingSize(String servingSize2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setServingSize'");
    }

}
