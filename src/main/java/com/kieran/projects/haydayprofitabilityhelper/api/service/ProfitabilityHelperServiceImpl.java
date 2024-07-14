package com.kieran.projects.haydayprofitabilityhelper.api.service;

import com.kieran.projects.haydayprofitabilityhelper.api.entity.Item;
import com.kieran.projects.haydayprofitabilityhelper.api.repository.ItemRepository;
import com.kieran.projects.haydayprofitabilityhelper.api.repository.ItemSourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfitabilityHelperServiceImpl implements ProfitabilityHelperService {

    private final ItemRepository itemRepository;
    private final ItemSourceRepository itemSourceRepository;

    @Override
    public List<Item> getMostProfitableItemsByLevel(int level) {
        return List.of();
    }

    @Override
    public List<Item> getMostProfitableItemsByLevelAndMinProductionTime(int level, int minProductionTime) {
        return List.of();
    }

    @Override
    public List<Item> getMostProfitableItemsByLevelAndMaxProductionTime(int level, int maxProductionTime) {
        return List.of();
    }

}
