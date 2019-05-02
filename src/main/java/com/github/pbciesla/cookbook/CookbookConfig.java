package com.github.pbciesla.cookbook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class CookbookConfig {

    private static final Random random = new Random(System.currentTimeMillis());

    @Bean
    private List<Ingredient> ingredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        for(int i=0; i<3; i++) {
            NutritionInformation nutritionInformation = new NutritionInformation(350, 10, 40, 20);
            Unit randomUnit = Unit.values()[random.nextInt(Unit.values().length)];
            ingredients.add(new Ingredient(randomUnit, nutritionInformation));
        }
        return ingredients;
    }

    @Bean
    public Recipe recipe() {
        Recipe recipe = new Recipe(5, ExecutionTime.MEDIUM, MealKind.BREAKFAST);
        for (Ingredient food: ingredients()) {
            recipe.addIngredient(food, 0.5);
        }
        return recipe;
    }
}
