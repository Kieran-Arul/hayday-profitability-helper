package com.kieran.projects.haydayhelper.api.mapper;

import com.kieran.projects.haydayhelper.api.contract.response.OptimalItem;
import com.kieran.projects.haydayhelper.api.contract.request.OptimisationRequest;
import com.kieran.projects.haydayhelper.api.contract.response.OptimisationResponse;
import com.kieran.projects.haydayhelper.api.entity.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OptimisationResponseMapper {

    public OptimisationResponse mapOptimisationResponse(OptimisationRequest optimisationRequest, Set<Item> items) {

        return OptimisationResponse.builder()
                .request(optimisationRequest)
                .items(mapItemsToOptimalItems(items))
                .build();

    }

    private Set<OptimalItem> mapItemsToOptimalItems(Set<Item> items) {

        Set<OptimalItem> optimalItems = new HashSet<>();

        for (Item item : items) {
            optimalItems.add(mapItemToOptimalItem(item));
        }

        return optimalItems;

    }

    private OptimalItem mapItemToOptimalItem(Item item) {

        return OptimalItem.builder()
                .itemName(item.getName())
                .itemSource(item.getSource().getSource())
                .build();

    }

}
