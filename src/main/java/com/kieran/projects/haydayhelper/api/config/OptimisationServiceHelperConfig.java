package com.kieran.projects.haydayhelper.api.config;

import com.kieran.projects.haydayhelper.api.client.dao.OptimisationH2Client;
import com.kieran.projects.haydayhelper.api.contract.OptimisationTarget;
import com.kieran.projects.haydayhelper.api.service.optimisation.OptimisationServiceHelper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OptimisationServiceHelperConfig {

    private final OptimisationH2Client optimisationH2Client;

    @Bean
    @Qualifier("profitOptimisationServiceHelper")
    public OptimisationServiceHelper profitOptimisationServiceHelper() {
        return new OptimisationServiceHelper(optimisationH2Client, OptimisationTarget.PROFIT);
    }

    @Bean
    @Qualifier("xpOptimisationServiceHelper")
    public OptimisationServiceHelper xpOptimisationServiceHelper() {
        return new OptimisationServiceHelper(optimisationH2Client, OptimisationTarget.XP);
    }

}
