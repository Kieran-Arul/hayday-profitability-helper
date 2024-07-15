package com.kieran.projects.haydayhelper.api.contract.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OptimisationResponse extends AbstractResponse {
    private Set<OptimalItem> items;
}
