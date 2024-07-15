package com.kieran.projects.haydayhelper.api.service.optimisation.profit;

import com.kieran.projects.haydayhelper.api.contract.request.OptimisationRequest;
import com.kieran.projects.haydayhelper.api.contract.response.OptimisationResponse;

public interface ProfitabilityOptimisationService {

    OptimisationResponse getProfitMaximisingResponse(OptimisationRequest optimisationRequest);

}
