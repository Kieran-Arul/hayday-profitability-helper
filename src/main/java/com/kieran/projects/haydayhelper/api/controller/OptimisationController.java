package com.kieran.projects.haydayhelper.api.controller;

import com.kieran.projects.haydayhelper.api.contract.request.OptimisationRequest;
import com.kieran.projects.haydayhelper.api.contract.response.OptimisationResponse;
import com.kieran.projects.haydayhelper.api.service.optimisation.profit.ProfitabilityOptimisationService;
import com.kieran.projects.haydayhelper.api.service.optimisation.xp.XpOptimisationService;
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

    // TODO add validation of request body using @Valid

    @PostMapping(value = "/profit", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<OptimisationResponse> getProfitableItems(@RequestBody OptimisationRequest request) {
        return ResponseEntity.ok(profitabilityOptimisationService.getProfitMaximisingResponse(request));
    }

    @PostMapping(value = "/xp", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<OptimisationResponse> getOptimalXpItems(@RequestBody OptimisationRequest request) {
        return ResponseEntity.ok(xpOptimisationService.getXpMaximisingResponse(request));
    }

}
