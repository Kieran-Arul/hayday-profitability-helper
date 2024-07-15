package com.kieran.projects.haydayhelper.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
public class ItemSource {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Source source;

    private int level;

    public ItemSource() {}

    public ItemSource(Source source, int level) {
        this.source = source;
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemSource that)) return false;
        return level == that.level && Objects.equals(id, that.id) && source == that.source;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, source, level);
    }

}
