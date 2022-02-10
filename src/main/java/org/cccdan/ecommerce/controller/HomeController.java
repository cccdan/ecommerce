package org.cccdan.ecommerce.controller;

import org.cccdan.ecommerce.persistence.ItemRepository;
import org.cccdan.ecommerce.persistence.ShoppingCart;
import org.cccdan.ecommerce.persistence.ShoppingCartRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private ItemRepository itemRepository;
    private ShoppingCartRepository shoppingCartRepository;

    public HomeController(ItemRepository itemRepository, ShoppingCartRepository shoppingCartRepository) {
        this.itemRepository = itemRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @GetMapping
    String home(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        model.addAttribute("cart", shoppingCartRepository.findById("My Cart")
                .orElseGet(() -> new ShoppingCart("My Cart")));

        return "home";
    }

}
