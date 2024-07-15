package com.kieran.projects.haydayhelper.api.contract.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class AbstractRequest {
    private int level;
    private Integer minProductionTime;
    private Integer maxProductionTime;
}
