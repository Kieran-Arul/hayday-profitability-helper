package com.kieran.projects.haydayprofitabilityhelper.api.repository;

import com.kieran.projects.haydayprofitabilityhelper.api.entity.ItemSource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemSourceRepository extends JpaRepository<ItemSource, Long> {
    List<ItemSource> findByLevelLessThanEqual(int level);
}
