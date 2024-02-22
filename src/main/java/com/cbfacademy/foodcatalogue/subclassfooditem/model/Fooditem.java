package com.cbfacademy.foodcatalogue.subclassfooditem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import com.cbfacademy.foodcatalogue.FoodCatalogue;

import java.text.DecimalFormat;
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

    public FoodItem(long l, String string, int i, int j, int k, int m) {
        //TODO Auto-generated constructor stub
    }

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

        System.out.println("Name: " + name);
        System.out.println("Serving size: " + servingSize);
        System.out.println("Calories: " + caloriesPerServing);

    }

    @Override
    public void calculateNutrition() {

        double calories = caloriesPerServing.doubleValue();
        double fat = 0.0;
        double carbohydrates = 0.0;
        double protein = 0.0;

        // Calculate the nutrients based on the calories
        fat = calories * 0.2;
        carbohydrates = calories * 0.55;
        protein = calories * 0.25;

        // Print the nutrition information
        System.out.println("Fat: " + new DecimalFormat("#.##").format(fat) + "g");
        System.out.println("Carbohydrates: " + new DecimalFormat("#.##").format(carbohydrates) + "g");
        System.out.println("Protein: " + new DecimalFormat("#.##").format(protein) + "g");

    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;

    }

    public Integer getCalories() {
        return caloriesPerServing;

    }

    public void setCalories(Integer calories) {
        this.caloriesPerServing = calories;

    }

    public String getServingSize() {
        return servingSize;

    }

    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;

    }

    public long getId() {

        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    public Object getDescription() {

        throw new UnsupportedOperationException("Unimplemented method 'getDescription'");
    }

    public void setDescription(Object description) {

        throw new UnsupportedOperationException("Unimplemented method 'setDescription'");
    }

    public void setId(long l) {

        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    public void setFats(int i) {

        throw new UnsupportedOperationException("Unimplemented method 'setFats'");
    }

    public void setProteins(int i) {

        throw new UnsupportedOperationException("Unimplemented method 'setProteins'");
    }

    public void setCarbohydrates(int i) {

        throw new UnsupportedOperationException("Unimplemented method 'setCarbohydrates'");
    }

    public void setSugars(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSugars'");
    }

    public char[] calculateTotalCalories() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateTotalCalories'");
    }
}