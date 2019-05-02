package com.github.pbciesla.cookbook;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class Ingredient {
    final Unit unit;
    NutritionInformation nutritionInformation;
}
