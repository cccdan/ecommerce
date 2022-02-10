package org.cccdan.ecommerce.controller;

import org.cccdan.ecommerce.persistence.Item;
import org.cccdan.ecommerce.persistence.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ItemRepositoryLoader {

    @Bean
    CommandLineRunner initialize(ItemRepository itemRepository) {
        return args -> {
          itemRepository.save(new Item("Asus Laptop 14 inch", 499));
          itemRepository.save(new Item("USB memory stick 32GB", 18.99));
          itemRepository.save(new Item("Samsung LED TV 108 cm", 759));
          itemRepository.save(new Item("LG headphones", 120));
          itemRepository.save(new Item("Dell Laptop 15 inch", 899));
        };
    }
}
