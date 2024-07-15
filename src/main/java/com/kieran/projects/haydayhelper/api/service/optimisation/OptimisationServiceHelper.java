package com.kieran.projects.haydayhelper.api.service.optimisation;

import com.kieran.projects.haydayhelper.api.client.dao.OptimisationH2Client;
import com.kieran.projects.haydayhelper.api.entity.ItemSource;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Getter
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@SuperBuilder
public class OptimisationServiceHelper {

    private OptimisationH2Client optimisationH2Client;

    public Set<ItemSource> getUnlockedSourcesAtLevel(int level) {
        return optimisationH2Client.getUnlockedSources(level);
    }

}
