package com.cbfacademy.foodcatalogue;

/**
 * Represents the general characteristics of food items in the catalogue.
 * This class is abstract because it provides a base for other food-related
 * classes
 * but should not be instantiated on its own.
 */
public abstract class FoodCatalogue {

    private String category;

    // Constructor (no-argument constructor)
    public FoodCatalogue() {
        // initialization code for common attributes this.category = category;
        // //Parameterized constructor useful for creating instances of subclasses
    }

    // Parameterized constructor useful for creating instances of subclasses
    /**
     * @param category
     */
    public FoodCatalogue(String category) {
        this.category = category; // Common attributes apply to all food items such as fruits, vegetables, grains,
    }

    // Common methods or abstract methods that the other subclasses can inherit or
    // should implement
    public abstract void displayDetails();

    public abstract void calculateNutrition(); // Useful if methods in subclasses are different

    // Getters and setters for category (if needed)
    // Common Attributes apply to all food items such as fruits, vegetables, grains,
    // etc.
    public String getCategory() {
        return category;
    }
}
