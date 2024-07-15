package com.kieran.projects.haydayhelper.api.utils;

import com.kieran.projects.haydayhelper.api.entity.Item;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemXpUtils {

    public static double getXpPerMinute(Item item) {
        return (double) item.getXp() / item.getProductionTimeInMinutes();
    }

}
