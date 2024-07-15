package com.kieran.projects.haydayhelper.api.repository;

import com.kieran.projects.haydayhelper.api.entity.ItemSource;
import com.kieran.projects.haydayhelper.api.entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ItemSourceRepository extends JpaRepository<ItemSource, Long> {
    Set<ItemSource> findByLevelLessThanEqual(int level);
}
