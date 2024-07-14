package com.kieran.projects.haydayprofitabilityhelper.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int maxPrice;
    private int xp;
    private int productionTimeInMinutes;
    private int level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ItemSource source;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItemIngredientMapping> ingredients = new HashSet<>();

    public Item() {}

    public Item(String name, int maxPrice, int xp, int productionTimeInMinutes, int level, ItemSource source) {
        this.name = name;
        this.maxPrice = maxPrice;
        this.xp = xp;
        this.productionTimeInMinutes = productionTimeInMinutes;
        this.level = level;
        this.source = source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return maxPrice == item.maxPrice
                && xp == item.xp
                && productionTimeInMinutes == item.productionTimeInMinutes
                && level == item.level
                && Objects.equals(id, item.id)
                && Objects.equals(name, item.name)
                && Objects.equals(source, item.source)
                && Objects.equals(ingredients, item.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, maxPrice, xp, productionTimeInMinutes, level, source, ingredients);
    }

}
