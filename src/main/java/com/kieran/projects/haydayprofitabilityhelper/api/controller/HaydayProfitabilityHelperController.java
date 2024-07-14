package com.kieran.projects.haydayprofitabilityhelper.api.controller;

import com.kieran.projects.haydayprofitabilityhelper.api.contract.ProfitabilityRequest;
import com.kieran.projects.haydayprofitabilityhelper.api.contract.ProfitabilityResponse;
import com.kieran.projects.haydayprofitabilityhelper.api.service.ProfitabilityHelperServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.BASE_PATH)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HaydayProfitabilityHelperController {

    private final ProfitabilityHelperServiceImpl profitabilityHelperServiceImpl;

    @GetMapping(value = "/getProfitableItems", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ProfitabilityResponse> getProfitableItems(@RequestBody ProfitabilityRequest request) {
        return null;
    }

}
