package com.kieran.projects.haydayprofitabilityhelper.api.contract;

import com.kieran.projects.haydayprofitabilityhelper.api.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfitabilityResponse {

    private ProfitabilityRequest request;
    private Item item;

}
