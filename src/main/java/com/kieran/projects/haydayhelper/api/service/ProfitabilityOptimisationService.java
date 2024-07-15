package com.kieran.projects.haydayhelper.api.service;

import com.kieran.projects.haydayhelper.api.contract.OptimalItem;
import com.kieran.projects.haydayhelper.api.contract.OptimisationRequest;
import com.kieran.projects.haydayhelper.api.contract.OptimisationResponse;
import com.kieran.projects.haydayhelper.api.entity.Item;

import java.util.Set;

public interface ProfitabilityOptimisationService {

    OptimisationResponse getProfitMaximisingResponse(OptimisationRequest optimisationRequest);

}
