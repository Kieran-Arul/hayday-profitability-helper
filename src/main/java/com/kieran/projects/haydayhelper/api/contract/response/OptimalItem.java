package com.kieran.projects.haydayhelper.api.contract.response;

import com.kieran.projects.haydayhelper.api.entity.Source;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OptimalItem {
    private Source itemSource;
    private String itemName;
}
