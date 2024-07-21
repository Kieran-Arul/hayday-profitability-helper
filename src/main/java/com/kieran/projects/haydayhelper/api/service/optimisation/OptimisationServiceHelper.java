package com.kieran.projects.haydayhelper.api.service.optimisation;

import com.kieran.projects.haydayhelper.api.client.dao.OptimisationH2Client;
import com.kieran.projects.haydayhelper.api.contract.OptimisationTarget;
import com.kieran.projects.haydayhelper.api.contract.request.OptimisationRequest;
import com.kieran.projects.haydayhelper.api.entity.Item;
import com.kieran.projects.haydayhelper.api.entity.ItemSource;
import com.kieran.projects.haydayhelper.api.contract.ProductionTimePreference;
import com.kieran.projects.haydayhelper.api.utils.ItemProfitUtils;
import com.kieran.projects.haydayhelper.api.utils.ItemXpUtils;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record OptimisationServiceHelper(OptimisationH2Client optimisationH2Client,
                                        OptimisationTarget optimisationTarget) {

    public Set<ItemSource> getUnlockedSourcesAtLevel(int level) {
        return optimisationH2Client.getUnlockedSources(level);
    }

    public ProductionTimePreference getOptimisationPreference(OptimisationRequest optimisationRequest) {

        if (optimisationRequest.getMinProductionTime() == null && optimisationRequest.getMaxProductionTime() == null) {
            return ProductionTimePreference.NO_PRODUCTION_TIME;
        } else if (optimisationRequest.getMinProductionTime() != null && optimisationRequest.getMaxProductionTime() == null) {
            return ProductionTimePreference.MIN_PRODUCTION_TIME;
        } else if (optimisationRequest.getMinProductionTime() == null) {
            return ProductionTimePreference.MAX_PRODUCTION_TIME;
        }

        return ProductionTimePreference.MIN_MAX_PRODUCTION_TIME;

    }

    public Set<Item> getOptimisedItems(OptimisationRequest optimisationRequest, ProductionTimePreference productionTimePreference, Set<ItemSource> unlockedSources) {

        Set<Item> optimisedItems = new HashSet<>();

        switch (productionTimePreference) {

            case NO_PRODUCTION_TIME -> {
                for (ItemSource itemSource : unlockedSources) {
                    Optional<Item> item = getOptimisedItemFromSource(itemSource,
                            optimisationRequest.getLevel());
                    item.ifPresent(optimisedItems::add);
                }
            }

            case MIN_PRODUCTION_TIME -> {
                for (ItemSource itemSource : unlockedSources) {
                    Optional<Item> item = getOptimisedItemFromSourceWithMinProductionTime(itemSource,
                            optimisationRequest.getMinProductionTime(), optimisationRequest.getLevel());
                    item.ifPresent(optimisedItems::add);
                }
            }

            case MAX_PRODUCTION_TIME -> {
                for (ItemSource itemSource : unlockedSources) {
                    Optional<Item> item = getOptimisedItemFromSourceWithMaxProductionTime(itemSource,
                            optimisationRequest.getMaxProductionTime(), optimisationRequest.getLevel());
                    item.ifPresent(optimisedItems::add);
                }
            }

            case MIN_MAX_PRODUCTION_TIME -> {
                for (ItemSource itemSource : unlockedSources) {
                    Optional<Item> item = getOptimisedItemFromSourceWithMinMaxProductionTime(itemSource,
                            optimisationRequest.getMinProductionTime(), optimisationRequest.getMaxProductionTime(), optimisationRequest.getLevel());
                    item.ifPresent(optimisedItems::add);
                }
            }

        }

        return optimisedItems;

    }

    private Optional<Item> getOptimisedItem(Set<Item> items) {

        switch (optimisationTarget) {

            case PROFIT -> {
                return items.stream()
                        .max(Comparator.comparing(ItemProfitUtils::getProfitMarginPerMinute));
            }

            case XP -> {
                return items.stream()
                        .max(Comparator.comparing(ItemXpUtils::getXpPerMinute));
            }

        }

        return Optional.empty();

    }

    private Optional<Item> getOptimisedItemFromSource(ItemSource itemSource, int level) {

        Set<Item> unlockedItems = optimisationH2Client.getUnlockedItemsOfSource(itemSource, level);

        return getOptimisedItem(unlockedItems);

    }

    private Optional<Item> getOptimisedItemFromSourceWithMinProductionTime(ItemSource itemSource, Integer minProductionTime, int level) {

        Set<Item> unlockedItems = optimisationH2Client.getUnlockedItemsOfSourceAndMinProductionTime(itemSource, minProductionTime, level);

        return getOptimisedItem(unlockedItems);

    }

    private Optional<Item> getOptimisedItemFromSourceWithMaxProductionTime(ItemSource itemSource, Integer maxProductionTime, int level) {

        Set<Item> unlockedItems = optimisationH2Client.getUnlockedItemsOfSourceAndMaxProductionTime(itemSource, maxProductionTime, level);

        return getOptimisedItem(unlockedItems);

    }

    private Optional<Item> getOptimisedItemFromSourceWithMinMaxProductionTime(ItemSource itemSource, Integer minProductionTime, Integer maxProductionTime, int level) {

        Set<Item> unlockedItems = optimisationH2Client.getUnlockedItemsOfSourceAndMinMaxProductionTime(itemSource, minProductionTime, maxProductionTime, level);

        return getOptimisedItem(unlockedItems);

    }

}
