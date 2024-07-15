package com.kieran.projects.haydayhelper.api.service;

import com.kieran.projects.haydayhelper.api.client.dao.OptimisationH2Client;
import com.kieran.projects.haydayhelper.api.contract.OptimisationRequest;
import com.kieran.projects.haydayhelper.api.contract.OptimisationResponse;
import com.kieran.projects.haydayhelper.api.entity.Item;
import com.kieran.projects.haydayhelper.api.entity.ItemSource;
import com.kieran.projects.haydayhelper.api.utils.ItemProfitUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProfitabilityOptimisationServiceImpl implements ProfitabilityOptimisationService {

    private final OptimisationH2Client optimisationH2Client;

    @Override
    public OptimisationResponse getProfitMaximisingResponse(OptimisationRequest optimisationRequest) {
        return null;
    }

    private Set<Item> getProfitMaximisingItems(OptimisationRequest optimisationRequest) {

        Set<ItemSource> unlockedSources = optimisationH2Client.getUnlockedSources(optimisationRequest.getLevel());

        RequestPreference requestPreference = getRequestPreference(optimisationRequest);

        return getRelevantItems(requestPreference, unlockedSources, optimisationRequest);

    }

    private Set<Item> getRelevantItems(RequestPreference requestPreference, Set<ItemSource> unlockedSources, OptimisationRequest optimisationRequest) {

        Set<Item> relevantItems = new HashSet<>();

        switch (requestPreference) {

            case NO_PRODUCTION_TIME -> {
                for (ItemSource itemSource : unlockedSources) {
                    Optional<Item> item = getMostProfitableItemFromSource(itemSource, optimisationRequest.getLevel());
                    item.ifPresent(relevantItems::add);
                }
            }

            case MIN_PRODUCTION_TIME -> {
                for (ItemSource itemSource : unlockedSources) {
                    Optional<Item> item = getMostProfitableItemFromSourceWithMinProductionTime(itemSource,
                            optimisationRequest.getMinProductionTime(), optimisationRequest.getLevel());
                    item.ifPresent(relevantItems::add);
                }
            }

            case MAX_PRODUCTION_TIME -> {
                for (ItemSource itemSource : unlockedSources) {
                    Optional<Item> item = getMostProfitableItemFromSourceWithMaxProductionTime(itemSource,
                            optimisationRequest.getMaxProductionTime(), optimisationRequest.getLevel());
                    item.ifPresent(relevantItems::add);
                }
            }

            case MIN_MAX_PRODUCTION_TIME -> {
                for (ItemSource itemSource : unlockedSources) {
                    Optional<Item> item = getMostProfitableItemFromSourceWithMinMaxProductionTime(itemSource,
                            optimisationRequest.getMinProductionTime(), optimisationRequest.getMaxProductionTime(), optimisationRequest.getLevel());
                    item.ifPresent(relevantItems::add);
                }
            }

        }

        return relevantItems;

    }

    private RequestPreference getRequestPreference(OptimisationRequest optimisationRequest) {

        if (optimisationRequest.getMinProductionTime() == null && optimisationRequest.getMaxProductionTime() == null) {
            return RequestPreference.NO_PRODUCTION_TIME;
        }

        else if (optimisationRequest.getMinProductionTime() != null && optimisationRequest.getMaxProductionTime() == null) {
            return RequestPreference.MIN_PRODUCTION_TIME;
        }

        else if (optimisationRequest.getMinProductionTime() == null) {
            return RequestPreference.MAX_PRODUCTION_TIME;
        }

        return RequestPreference.MIN_MAX_PRODUCTION_TIME;

    }

    private Optional<Item> getMostProfitableItem(Set<Item> items) {
        return items.stream()
                .max(Comparator.comparing(ItemProfitUtils::getProfitMarginPerMinute));
    }

    private Optional<Item> getMostProfitableItemFromSource(ItemSource itemSource, int level) {

        Set<Item> unlockedItems = optimisationH2Client.getUnlockedItemsOfSource(itemSource, level);

        return getMostProfitableItem(unlockedItems);

    }

    private Optional<Item> getMostProfitableItemFromSourceWithMinProductionTime(ItemSource itemSource, Integer minProductionTime, int level) {

        Set<Item> unlockedItems = optimisationH2Client.getUnlockedItemsOfSourceAndMinProductionTime(itemSource, minProductionTime, level);

        return getMostProfitableItem(unlockedItems);

    }

    private Optional<Item> getMostProfitableItemFromSourceWithMaxProductionTime(ItemSource itemSource, Integer maxProductionTime, int level) {

        Set<Item> unlockedItems = optimisationH2Client.getUnlockedItemsOfSourceAndMaxProductionTime(itemSource, maxProductionTime, level);

        return getMostProfitableItem(unlockedItems);

    }

    public Optional<Item> getMostProfitableItemFromSourceWithMinMaxProductionTime(ItemSource itemSource, Integer minProductionTime, Integer maxProductionTime, int level) {

        Set<Item> unlockedItems = optimisationH2Client.getUnlockedItemsOfSourceAndMinMaxProductionTime(itemSource, minProductionTime, maxProductionTime, level);

        return getMostProfitableItem(unlockedItems);

    }

}
