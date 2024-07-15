package com.kieran.projects.haydayhelper.api.contract;

import com.kieran.projects.haydayhelper.api.entity.Item;
import com.kieran.projects.haydayhelper.api.entity.Source;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OptimalItem {
    private Source itemSource;
    private Item item;
}
