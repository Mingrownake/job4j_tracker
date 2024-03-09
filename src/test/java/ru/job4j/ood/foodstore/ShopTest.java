package ru.job4j.ood.foodstore;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ShopTest {
    @Test
    void whenFoodIsAddedToShopThenItIsInShop() {

        LocalDateTime createdDate = LocalDateTime.now().minusDays(8);
        LocalDateTime expiryDate = LocalDateTime.now().plusDays(7);

        AbstractStore warehouse = new Warehouse();
        AbstractStore shop = new Shop();
        AbstractStore trash = new Trash();
        Food cheese = new DairyProducts("cheese", createdDate, expiryDate, 490.85f, 0);

        ControlQuality controlQuality
                = new ControlQuality(List.of(shop, warehouse, trash));

        controlQuality.distributeFood(cheese);

        assertThat(shop.getFoods()).contains(cheese);
    }

    @Test
    void whenFoodIsAddedToShopThenItIsInShopWithDiscount() {

        LocalDateTime createdDate = LocalDateTime.now().minusDays(10);
        LocalDateTime expiryDate = LocalDateTime.now().plusDays(1);

        AbstractStore warehouse = new Warehouse();
        AbstractStore shop = new Shop();
        AbstractStore trash = new Trash();
        Food cheese = new DairyProducts("cheese", createdDate, expiryDate, 500f, 0);

        ControlQuality controlQuality
                = new ControlQuality(List.of(shop, warehouse, trash));

        controlQuality.distributeFood(cheese);

        assertThat(shop.getFoods()).contains(cheese);
        assertThat(cheese.getPrice()).isEqualTo(400);
        assertThat(cheese.getDiscount()).isEqualTo(20);
    }

}