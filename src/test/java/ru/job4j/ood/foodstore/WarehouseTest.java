package ru.job4j.ood.foodstore;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WarehouseTest {
    @Test
    void whenFoodIsAddedToWarehouseThenItIsInWarehouse() {

        LocalDateTime createdDate = LocalDateTime.now().minusDays(30);
        LocalDateTime expiryDate = LocalDateTime.now().plusDays(360);

        AbstractStore warehouse = new Warehouse();
        AbstractStore shop = new Shop();
        AbstractStore trash = new Trash();
        Food tinnedMeat = new TinnedFood("tinnedmeat", createdDate, expiryDate, 100, 0);

        ControlQuality controlQuality
                = new ControlQuality(List.of(shop, warehouse, trash));

        controlQuality.distributeFood(tinnedMeat);
        assertThat(warehouse.getFoods()).contains(tinnedMeat);
    }
}