package com.kieran.projects.haydayhelper.api.service.optimisation.profit;

import com.kieran.projects.haydayhelper.api.entity.Item;
import com.kieran.projects.haydayhelper.api.entity.ItemSource;
import com.kieran.projects.haydayhelper.api.service.optimisation.OptimisationServiceHelper;
import com.kieran.projects.haydayhelper.api.utils.ItemProfitUtils;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@SuperBuilder
public class ProfitabilityServiceHelper extends OptimisationServiceHelper {

    public Optional<Item> getMostProfitableItem(Set<Item> items) {
        return items.stream()
                .max(Comparator.comparing(ItemProfitUtils::getProfitMarginPerMinute));
    }

    public Optional<Item> getMostProfitableItemFromSource(ItemSource itemSource, int level) {

        Set<Item> unlockedItems = getOptimisationH2Client().getUnlockedItemsOfSource(itemSource, level);

        return getMostProfitableItem(unlockedItems);

    }

    public Optional<Item> getMostProfitableItemFromSourceWithMinProductionTime(ItemSource itemSource, Integer minProductionTime, int level) {

        Set<Item> unlockedItems = getOptimisationH2Client().getUnlockedItemsOfSourceAndMinProductionTime(itemSource, minProductionTime, level);

        return getMostProfitableItem(unlockedItems);

    }

    public Optional<Item> getMostProfitableItemFromSourceWithMaxProductionTime(ItemSource itemSource, Integer maxProductionTime, int level) {

        Set<Item> unlockedItems = getOptimisationH2Client().getUnlockedItemsOfSourceAndMaxProductionTime(itemSource, maxProductionTime, level);

        return getMostProfitableItem(unlockedItems);

    }

    public Optional<Item> getMostProfitableItemFromSourceWithMinMaxProductionTime(ItemSource itemSource, Integer minProductionTime, Integer maxProductionTime, int level) {

        Set<Item> unlockedItems = getOptimisationH2Client().getUnlockedItemsOfSourceAndMinMaxProductionTime(itemSource, minProductionTime, maxProductionTime, level);

        return getMostProfitableItem(unlockedItems);

    }

}
