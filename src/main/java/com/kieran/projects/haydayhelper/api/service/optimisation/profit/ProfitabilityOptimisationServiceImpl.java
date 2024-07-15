package com.kieran.projects.haydayhelper.api.service.optimisation.profit;

import com.kieran.projects.haydayhelper.api.contract.request.OptimisationRequest;
import com.kieran.projects.haydayhelper.api.contract.response.OptimisationResponse;
import com.kieran.projects.haydayhelper.api.entity.Item;
import com.kieran.projects.haydayhelper.api.entity.ItemSource;
import com.kieran.projects.haydayhelper.api.mapper.OptimisationResponseMapper;
import com.kieran.projects.haydayhelper.api.service.RequestPreference;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProfitabilityOptimisationServiceImpl implements ProfitabilityOptimisationService {

    private final ProfitabilityServiceHelper profitabilityServiceHelper;
    private final OptimisationResponseMapper optimisationResponseMapper;

    @Override
    public OptimisationResponse getProfitMaximisingResponse(OptimisationRequest optimisationRequest) {
        return optimisationResponseMapper.mapOptimisationResponse(optimisationRequest, getProfitMaximisingItems(optimisationRequest));
    }

    private Set<Item> getProfitMaximisingItems(OptimisationRequest optimisationRequest) {

        Set<ItemSource> unlockedSources = profitabilityServiceHelper.getUnlockedSourcesAtLevel(optimisationRequest.getLevel());

        RequestPreference requestPreference = getRequestPreference(optimisationRequest);

        return getRelevantItemsBasedOnRequestPreference(optimisationRequest, requestPreference, unlockedSources);

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

    private Set<Item> getRelevantItemsBasedOnRequestPreference(OptimisationRequest optimisationRequest, RequestPreference requestPreference, Set<ItemSource> unlockedSources) {

        Set<Item> relevantItems = new HashSet<>();

        switch (requestPreference) {

            case NO_PRODUCTION_TIME -> {
                for (ItemSource itemSource : unlockedSources) {
                    Optional<Item> item = profitabilityServiceHelper.getMostProfitableItemFromSource(itemSource,
                            optimisationRequest.getLevel());
                    item.ifPresent(relevantItems::add);
                }
            }

            case MIN_PRODUCTION_TIME -> {
                for (ItemSource itemSource : unlockedSources) {
                    Optional<Item> item = profitabilityServiceHelper.getMostProfitableItemFromSourceWithMinProductionTime(itemSource,
                            optimisationRequest.getMinProductionTime(), optimisationRequest.getLevel());
                    item.ifPresent(relevantItems::add);
                }
            }

            case MAX_PRODUCTION_TIME -> {
                for (ItemSource itemSource : unlockedSources) {
                    Optional<Item> item = profitabilityServiceHelper.getMostProfitableItemFromSourceWithMaxProductionTime(itemSource,
                            optimisationRequest.getMaxProductionTime(), optimisationRequest.getLevel());
                    item.ifPresent(relevantItems::add);
                }
            }

            case MIN_MAX_PRODUCTION_TIME -> {
                for (ItemSource itemSource : unlockedSources) {
                    Optional<Item> item = profitabilityServiceHelper.getMostProfitableItemFromSourceWithMinMaxProductionTime(itemSource,
                            optimisationRequest.getMinProductionTime(), optimisationRequest.getMaxProductionTime(), optimisationRequest.getLevel());
                    item.ifPresent(relevantItems::add);
                }
            }

        }

        return relevantItems;

    }

}
