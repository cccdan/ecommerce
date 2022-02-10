package org.cccdan.ecommerce.persistence;

import javax.persistence.*;

@Entity
public class ShoppingCartItem {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private ShoppingCart shoppingCart;

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;
    private int quantity;

}
