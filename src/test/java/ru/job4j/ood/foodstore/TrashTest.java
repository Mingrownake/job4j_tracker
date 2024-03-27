package ru.job4j.ood.foodstore;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class TrashTest {

    @Test
    void whenFoodIsAddedToTrashThenItIsInTrash() {

        LocalDateTime createdDate = LocalDateTime.now().minusDays(30);
        LocalDateTime expiryDate = LocalDateTime.now().minusDays(15);

        AbstractStore warehouse = new Warehouse();
        AbstractStore shop = new Shop();
        AbstractStore trash = new Trash();
        Food milk = new DairyProducts("milk", createdDate, expiryDate, 90.95f, 0);

        ControlQuality controlQuality
                = new ControlQuality(List.of(shop, warehouse, trash));

        controlQuality.distributeFood(milk);
        assertThat(trash.getFoods()).contains(milk);
    }

    @Test
    void whenFoodExpiredTodayThenIsAddedToTrashThenItIsInTrash() {

        LocalDateTime createdDate = LocalDateTime.now().minusDays(30);
        LocalDateTime expiryDate = LocalDateTime.now();

        AbstractStore warehouse = new Warehouse();
        AbstractStore shop = new Shop();
        AbstractStore trash = new Trash();
        Food milk = new DairyProducts("milk", createdDate, expiryDate, 90.95f, 0);

        ControlQuality controlQuality
                = new ControlQuality(List.of(shop, warehouse, trash));

        controlQuality.distributeFood(milk);
        assertThat(trash.getFoods()).contains(milk);
    }

    @Test
    void whenControlQualityUsesResortThenFoodIsSendToTrashAnew() {

        LocalDateTime createdDate = LocalDateTime.now().minusDays(1800);
        LocalDateTime expiryDate = LocalDateTime.now();

        AbstractStore warehouse = new Warehouse();
        AbstractStore shop = new Shop();
        AbstractStore trash = new Trash();

        Food cheese = new DairyProducts("cheese", createdDate, expiryDate, 490.85f, 0);
        Food beef = new TinnedFood("beef", createdDate, expiryDate, 120.00f, 0);

        ControlQuality controlQuality
                = new ControlQuality(List.of(shop, warehouse, trash));

        controlQuality.distributeFood(cheese);
        controlQuality.distributeFood(beef);

        controlQuality.resort();

        assertThat(trash.getFoods()).contains(cheese, beef);
    }
}