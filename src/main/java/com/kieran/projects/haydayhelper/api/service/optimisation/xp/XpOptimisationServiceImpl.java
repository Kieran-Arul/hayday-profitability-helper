package com.kieran.projects.haydayhelper.api.service.optimisation.xp;

import com.kieran.projects.haydayhelper.api.contract.request.OptimisationRequest;
import com.kieran.projects.haydayhelper.api.contract.response.OptimisationResponse;
import com.kieran.projects.haydayhelper.api.entity.Item;
import com.kieran.projects.haydayhelper.api.entity.ItemSource;
import com.kieran.projects.haydayhelper.api.mapper.OptimisationResponseMapper;
import com.kieran.projects.haydayhelper.api.contract.ProductionTimePreference;
import com.kieran.projects.haydayhelper.api.service.optimisation.OptimisationServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class XpOptimisationServiceImpl implements XpOptimisationService {

    private final OptimisationServiceHelper optimisationServiceHelper;
    private final OptimisationResponseMapper optimisationResponseMapper;

    @Autowired
    public XpOptimisationServiceImpl(@Qualifier("xpOptimisationServiceHelper") OptimisationServiceHelper optimisationServiceHelper,
                                     OptimisationResponseMapper optimisationResponseMapper) {
        this.optimisationServiceHelper = optimisationServiceHelper;
        this.optimisationResponseMapper = optimisationResponseMapper;
    }

    @Override
    public OptimisationResponse getXpMaximisingResponse(OptimisationRequest optimisationRequest) {
        return optimisationResponseMapper.mapOptimisationResponse(optimisationRequest, getXpMaximisingItemsBasedOnRequest(optimisationRequest));
    }

    private Set<Item> getXpMaximisingItemsBasedOnRequest(OptimisationRequest optimisationRequest) {

        Set<ItemSource> unlockedSources = optimisationServiceHelper.getUnlockedSourcesAtLevel(optimisationRequest.getLevel());

        ProductionTimePreference productionTimePreference = optimisationServiceHelper.getOptimisationPreference(optimisationRequest);

        return optimisationServiceHelper.getOptimisedItems(optimisationRequest, productionTimePreference, unlockedSources);

    }

}
