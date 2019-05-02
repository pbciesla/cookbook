package com.github.pbciesla.cookbook;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CookbookConfig.class)
public class RecipeTest {

    @Autowired
    private Recipe someRecipe;

    @Test
    public void nutritionInformationShouldNotBeNull() {
        assertThat(someRecipe.getNutritionInformation()).isNotNull();
    }

    @Test
    public void getNutritionInformationShouldReturnCorrectValues() {
        NutritionInformation expectedInformation = new NutritionInformation(525, 15, 60, 30);
        assertThat(someRecipe.getNutritionInformation()).isEqualTo(expectedInformation);
    }
}
