package com.kieran.projects.haydayprofitabilityhelper.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Objects;

@Entity
@Getter
@Setter
public class ItemIngredientMapping {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Item ingredient;

    private int quantity;

    public ItemIngredientMapping() {}

    public ItemIngredientMapping(Item item, Item ingredient, int quantity) {
        this.item = item;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemIngredientMapping that)) return false;
        return quantity == that.quantity
                && Objects.equals(id, that.id)
                && Objects.equals(item, that.item)
                && Objects.equals(ingredient, that.ingredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item, ingredient, quantity);
    }

}
