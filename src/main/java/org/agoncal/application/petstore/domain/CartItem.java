package org.agoncal.application.petstore.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@AllArgsConstructor
public class CartItem {

    // ======================================
    // =             Attributes             =
    // ======================================

    @NotNull
    @Getter @Setter private Item item;
    @NotNull
    @Min(1)
    @Getter @Setter private Integer quantity;

    // ======================================
    // =              Public Methods        =
    // ======================================

    public Float getSubTotal() {
        return item.getUnitCost() * quantity;
    }

    // ======================================
    // =   Methods hash, equals, toString   =
    // ======================================


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem cartItem = (CartItem) o;

        if (!item.equals(cartItem.item)) return false;
        if (!quantity.equals(cartItem.quantity)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = item.hashCode();
        result = 31 * result + quantity.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CartItem");
        sb.append("{item='").append(item).append('\'');
        sb.append(", quantity='").append(quantity).append('\'');
        sb.append('}');
        return sb.toString();
    }
}