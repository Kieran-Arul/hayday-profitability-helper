package com.kieran.projects.haydayprofitabilityhelper.api.service;

import com.kieran.projects.haydayprofitabilityhelper.api.entity.Item;

import java.util.List;

public interface ProfitabilityHelperService {

    List<Item> getMostProfitableItemsByLevel(int level);
    List<Item> getMostProfitableItemsByLevelAndMinProductionTime(int level, int minProductionTime);
    List<Item> getMostProfitableItemsByLevelAndMaxProductionTime(int level, int maxProductionTime);

}
