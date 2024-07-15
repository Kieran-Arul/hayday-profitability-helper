package com.kieran.projects.haydayhelper.api.service.optimisation.xp;

import com.kieran.projects.haydayhelper.api.entity.Item;
import com.kieran.projects.haydayhelper.api.service.optimisation.OptimisationServiceHelper;
import com.kieran.projects.haydayhelper.api.utils.ItemXpUtils;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@SuperBuilder
public class XpServiceHelper extends OptimisationServiceHelper {

    public Optional<Item> getOptimalXpItem(Set<Item> items) {
        return items.stream()
                .max(Comparator.comparing(ItemXpUtils::getXpPerMinute));
    }

}
