package com.kieran.projects.haydayprofitabilityhelper.api.utils;

import com.kieran.projects.haydayprofitabilityhelper.api.entity.Item;
import com.kieran.projects.haydayprofitabilityhelper.api.entity.ItemIngredientMapping;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemUtils {

    public static double getProfitMarginPerMinute(Item item) {
        return (double) getProfitMargin(item) / item.getProductionTimeInMinutes();
    }

    private static int getTotalCostOfIngredients(Item item) {

        int cost = 0;

        for (ItemIngredientMapping itemIngredientMapping : item.getIngredients()) {
            cost += itemIngredientMapping.getIngredient().getMaxPrice();
        }

        return cost;

    }

    private static int getProfitMargin(Item item) {
        return item.getMaxPrice() - getTotalCostOfIngredients(item);
    }

}
