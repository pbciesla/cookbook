package com.github.pbciesla.cookbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
class Recipe {

    private Map<Ingredient, Double> ingredients = new HashMap<>();
    @Setter
    private int rating;
    @Setter
    private ExecutionTime executionTime;
    @Setter
    private MealKind mealKind;

    Recipe(int rating, ExecutionTime executionTime, MealKind mealKind) {
        this.rating = rating;
        this.executionTime = executionTime;
        this.mealKind = mealKind;
    }

    void addIngredient(Ingredient food, double quantity) {
        ingredients.put(food, quantity);
    }

    public NutritionInformation getNutritionInformation() {
        int energy = 0;
        int fat = 0;
        int carbohydrate = 0;
        int protein = 0;
        for (Map.Entry<Ingredient, Double> food: ingredients.entrySet()) {
            energy += food.getValue()*food.getKey().getNutritionInformation().getEnergy();
            fat += food.getValue()*food.getKey().getNutritionInformation().getFat();
            carbohydrate += food.getValue()*food.getKey().getNutritionInformation().getCarbohydrate();
            protein += food.getValue()*food.getKey().getNutritionInformation().getProtein();
        }
        return new NutritionInformation(energy, fat, carbohydrate, protein);
    }
}
