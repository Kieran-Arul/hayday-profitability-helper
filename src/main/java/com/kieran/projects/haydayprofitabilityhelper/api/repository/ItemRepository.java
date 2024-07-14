package com.kieran.projects.haydayprofitabilityhelper.api.repository;

import com.kieran.projects.haydayprofitabilityhelper.api.entity.Item;
import com.kieran.projects.haydayprofitabilityhelper.api.entity.ItemSource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findByName(String name);
    List<Item> findBySource(ItemSource source);
    List<Item> findBySourceAndLevelLessThanEqual(ItemSource source, int level);
    List<Item> findBySourceAndProductionTimeInMinutesLessThanEqual(ItemSource source, int maxProductionTime);
    List<Item> findBySourceAndProductionTimeInMinutesGreaterThanEqual(ItemSource source, int minProductionTime);
    List<Item> findBySourceAndProductionTimeInMinutesLessThanEqualAndLevelLessThanEqual(ItemSource source, int maxProductionTime, int level);
    List<Item> findBySourceAndProductionTimeInMinutesGreaterThanEqualAndLevelLessThanEqual(ItemSource source, int minProductionTime, int level);

}
