package com.kieran.projects.haydayhelper.api.service.optimisation.xp;

import com.kieran.projects.haydayhelper.api.contract.request.OptimisationRequest;
import com.kieran.projects.haydayhelper.api.contract.response.OptimisationResponse;

public interface XpOptimisationService {
    OptimisationResponse getXpMaximisingResponse(OptimisationRequest optimisationRequest);
}
