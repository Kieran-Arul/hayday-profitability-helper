package com.kieran.projects.haydayhelper.api.repository;

import com.kieran.projects.haydayhelper.api.entity.Item;
import com.kieran.projects.haydayhelper.api.entity.ItemSource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Set<Item> findBySourceAndLevelLessThanEqual(ItemSource itemSource, int level);
    Set<Item> findBySourceAndProductionTimeInMinutesGreaterThanEqualAndLevelLessThanEqual(ItemSource itemSource, Integer minProductionTime, int level);
    Set<Item> findBySourceAndProductionTimeInMinutesLessThanEqualAndLevelLessThanEqual(ItemSource itemSource, Integer maxProductionTime, int level);
    Set<Item> findBySourceAndProductionTimeInMinutesBetweenAndLevelLessThanEqual(ItemSource itemSource, Integer minProductionTime, Integer maxProductionTime, int level);

}
