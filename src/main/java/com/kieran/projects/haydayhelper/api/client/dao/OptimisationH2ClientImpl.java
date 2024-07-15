package com.kieran.projects.haydayhelper.api.client.dao;

import com.kieran.projects.haydayhelper.api.entity.Item;
import com.kieran.projects.haydayhelper.api.entity.ItemSource;
import com.kieran.projects.haydayhelper.api.repository.ItemRepository;
import com.kieran.projects.haydayhelper.api.repository.ItemSourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OptimisationH2ClientImpl implements OptimisationH2Client {

    private final ItemRepository itemRepository;
    private final ItemSourceRepository itemSourceRepository;

    @Override
    public Set<ItemSource> getUnlockedSources(int level) {
        return itemSourceRepository.findByLevelLessThanEqual(level);
    }

    @Override
    public Set<Item> getUnlockedItemsOfSource(ItemSource itemSource, int level) {
        return itemRepository.findBySourceAndLevelLessThanEqual(itemSource, level);
    }

    @Override
    public Set<Item> getUnlockedItemsOfSourceAndMinProductionTime(ItemSource itemSource, Integer minProductionTime, int level) {
        return itemRepository.findBySourceAndProductionTimeInMinutesGreaterThanEqualAndLevelLessThanEqual(itemSource, minProductionTime, level);
    }

    @Override
    public Set<Item> getUnlockedItemsOfSourceAndMaxProductionTime(ItemSource itemSource, Integer maxProductionTime, int level) {
        return itemRepository.findBySourceAndProductionTimeInMinutesLessThanEqualAndLevelLessThanEqual(itemSource, maxProductionTime, level);
    }

    @Override
    public Set<Item> getUnlockedItemsOfSourceAndMinMaxProductionTime(ItemSource itemSource, Integer minProductionTime, Integer maxProductionTime, int level) {
        return itemRepository.findBySourceAndProductionTimeInMinutesBetweenAndLevelLessThanEqual(itemSource, minProductionTime, maxProductionTime, level);
    }

}
