package com.github.pbciesla.cookbook;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NutritionInformation {
    double energy;
    double fat;
    double carbohydrate;
    double protein;

}
