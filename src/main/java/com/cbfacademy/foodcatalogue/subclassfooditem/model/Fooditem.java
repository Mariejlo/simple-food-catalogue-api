package com.cbfacademy.foodcatalogue.subclassfooditem.model;

import lombok.Builder;
import lombok.Data;

 
@Builder
@Data
public class FoodItem {  
    private final String name;
    private final int calories; 
    private final String category;
    private final int weight;
    private final NutritionalInfo nutritionalInfo;    
}
