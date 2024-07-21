package com.kieran.projects.haydayhelper.api.contract.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OptimisationRequest {

    @NotNull
    private Integer level;

    private Integer minProductionTime;
    private Integer maxProductionTime;

}
