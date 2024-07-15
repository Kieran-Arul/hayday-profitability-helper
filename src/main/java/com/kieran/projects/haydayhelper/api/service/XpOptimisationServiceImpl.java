package com.kieran.projects.haydayhelper.api.service;

import com.kieran.projects.haydayhelper.api.contract.OptimisationRequest;
import com.kieran.projects.haydayhelper.api.contract.OptimisationResponse;
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
