package org.cccdan.ecommerce.persistence;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ShoppingCart {
    @Id
    private String id;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShoppingCartItem> shoppingCartItems;

    protected ShoppingCart() { }

    public ShoppingCart(String id, List<ShoppingCartItem> shoppingCartItems) {
        this.id = id;
        this.shoppingCartItems = shoppingCartItems;
    }

    public ShoppingCart(String id) {
        this(id, new ArrayList<>());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ShoppingCartItem> getShoppingCartItems() {
        return shoppingCartItems;
    }

    public void setShoppingCartItems(List<ShoppingCartItem> shoppingCartItems) {
        this.shoppingCartItems = shoppingCartItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingCart)) return false;
        ShoppingCart cart = (ShoppingCart) o;
        return shoppingCartItems.equals(cart.shoppingCartItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shoppingCartItems);
    }
}
