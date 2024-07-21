package com.kieran.projects.haydayhelper.api.controller;

import com.kieran.projects.haydayhelper.api.contract.request.OptimisationRequest;
import com.kieran.projects.haydayhelper.api.contract.response.OptimisationResponse;
import com.kieran.projects.haydayhelper.api.service.optimisation.profit.ProfitabilityOptimisationService;
import com.kieran.projects.haydayhelper.api.service.optimisation.xp.XpOptimisationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.OPTIMISE_PATH)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OptimisationController {

    private final ProfitabilityOptimisationService profitabilityOptimisationService;
    private final XpOptimisationService xpOptimisationService;

    // TODO: go through data flow, find areas of possible failure,
    //  For areas of possible failure, throw custom exceptions defined in the exception package
    //  Handle such exceptions in the advice package
    //  Implement Response and ResponseHandler classes
    //  Use those classes to make the code more readable and generic

    @GetMapping(value = "/profit", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<OptimisationResponse> getProfitableItems(@Valid @ModelAttribute OptimisationRequest request) {
        return ResponseEntity.ok(profitabilityOptimisationService.getProfitMaximisingResponse(request));
    }

    @GetMapping(value = "/xp", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<OptimisationResponse> getOptimalXpItems(@Valid @ModelAttribute OptimisationRequest request) {
        return ResponseEntity.ok(xpOptimisationService.getXpMaximisingResponse(request));
    }

}
