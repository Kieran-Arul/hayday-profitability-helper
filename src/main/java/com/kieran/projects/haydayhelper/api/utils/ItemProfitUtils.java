package com.kieran.projects.haydayhelper.api.utils;

import com.kieran.projects.haydayhelper.api.entity.Item;
import com.kieran.projects.haydayhelper.api.entity.ItemIngredientMapping;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemProfitUtils {

    public static double getProfitMarginPerMinute(Item item) {
        return (double) getProfitMargin(item) / item.getProductionTimeInMinutes();
    }

    private static int getProfitMargin(Item item) {
        return item.getMaxPrice() - getTotalCostOfIngredients(item);
    }

    private static int getTotalCostOfIngredients(Item item) {

        int cost = 0;

        for (ItemIngredientMapping itemIngredientMapping : item.getIngredients()) {
            cost += itemIngredientMapping.getIngredient().getMaxPrice();
        }

        return cost;

    }

}
