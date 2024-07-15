package com.kieran.projects.haydayhelper.api.client.dao;

import com.kieran.projects.haydayhelper.api.entity.Item;
import com.kieran.projects.haydayhelper.api.entity.ItemSource;

import java.util.Set;

public interface OptimisationH2Client {

    Set<ItemSource> getUnlockedSources(int level);
    Set<Item> getUnlockedItemsOfSource(ItemSource itemSource, int level);
    Set<Item> getUnlockedItemsOfSourceAndMinProductionTime(ItemSource itemSource, Integer minProductionTime, int level);
    Set<Item> getUnlockedItemsOfSourceAndMaxProductionTime(ItemSource itemSource, Integer maxProductionTime, int level);
    Set<Item> getUnlockedItemsOfSourceAndMinMaxProductionTime(ItemSource itemSource, Integer minProductionTime, Integer maxProductionTime, int level);

}
