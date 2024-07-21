package com.kieran.projects.haydayhelper.api.contract.response;

import com.kieran.projects.haydayhelper.api.contract.request.OptimisationRequest;
import lombok.*;

import java.util.Set;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OptimisationResponse {
    private OptimisationRequest request;
    private Set<OptimalItem> items;
}
