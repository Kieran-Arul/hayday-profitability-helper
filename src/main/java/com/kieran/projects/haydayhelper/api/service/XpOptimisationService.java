package com.kieran.projects.haydayhelper.api.service;

import com.kieran.projects.haydayhelper.api.contract.OptimisationRequest;
import com.kieran.projects.haydayhelper.api.contract.OptimisationResponse;

public interface XpOptimisationService {
    OptimisationResponse getXpMaximisingResponse(OptimisationRequest optimisationRequest);
}
