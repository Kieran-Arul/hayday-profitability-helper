package com.kieran.projects.haydayprofitabilityhelper.api.contract;

import com.kieran.projects.haydayprofitabilityhelper.api.entity.Source;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProfitabilityRequest extends AbstractRequest {
    private Source type;
    private boolean maximumProductionTime;
    private int productionTime;
}
