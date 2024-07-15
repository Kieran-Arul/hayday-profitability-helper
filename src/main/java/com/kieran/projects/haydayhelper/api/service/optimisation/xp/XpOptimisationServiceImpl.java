package com.kieran.projects.haydayhelper.api.service.optimisation.xp;

import com.kieran.projects.haydayhelper.api.contract.request.OptimisationRequest;
import com.kieran.projects.haydayhelper.api.contract.response.OptimisationResponse;
import com.kieran.projects.haydayhelper.api.repository.ItemRepository;
import com.kieran.projects.haydayhelper.api.repository.ItemSourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class XpOptimisationServiceImpl implements XpOptimisationService {

    private final ItemRepository itemRepository;
    private final ItemSourceRepository itemSourceRepository;

    @Override
    public OptimisationResponse getXpMaximisingResponse(OptimisationRequest optimisationRequest) {
        return null;
    }

}
