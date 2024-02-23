package com.cbfacademy.foodcatalogue.subclassfooditem.model;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value 
//@Builder(toBuilder = true) 
@Data
public class Meat extends FoodItem {
    MeatType meatType;
       
}
