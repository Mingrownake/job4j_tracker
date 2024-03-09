package ru.job4j.ood.foodstore;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    void whenControlQualityGetsAllFoodsFromOneStoreItReceivesAll() {
        LocalDateTime createdDate1 = LocalDateTime.now().minusDays(30);
        LocalDateTime expiryDate1 = LocalDateTime.now().plusDays(360);

        Food tinnedMeat = new TinnedFood("tinned meat", createdDate1, expiryDate1, 100, 0);
        Food butter = new DairyProducts("butter", createdDate1, expiryDate1, 100, 0);
        Food sourCream = new DairyProducts("sour cream", createdDate1, expiryDate1, 100, 0);

        AbstractStore warehouse = new Warehouse();
        AbstractStore shop = new Shop();
        AbstractStore trash = new Trash();

        ControlQuality controlQuality
                = new ControlQuality(List.of(shop, warehouse, trash));

        controlQuality.distributeFood(tinnedMeat);
        controlQuality.distributeFood(butter);
        controlQuality.distributeFood(sourCream);

        assertThat(controlQuality.retrieveAllFoods()).containsAll(List.of(tinnedMeat, butter, sourCream));
    }

    @Test
    void whenControlQualityGetsAllFoodsFromAllStoresItReceivesAll() {

        LocalDateTime createdDate1 = LocalDateTime.now().minusDays(30);
        LocalDateTime expiryDate1 = LocalDateTime.now().plusDays(360);
        Food tinnedMeat = new TinnedFood("tinned meat", createdDate1, expiryDate1, 100, 0);

        LocalDateTime createdDate2 = LocalDateTime.now().minusDays(10);
        LocalDateTime expiryDate2 = LocalDateTime.now().plusDays(1);
        Food cheese = new DairyProducts("cheese", createdDate2, expiryDate2, 500, 0);

        LocalDateTime createdDate3 = LocalDateTime.now().minusDays(30);
        LocalDateTime expiryDate3 = LocalDateTime.now().minusDays(15);
        Food butter = new DairyProducts("butter", createdDate3, expiryDate3, 100, 0);

        AbstractStore warehouse = new Warehouse();
        AbstractStore shop = new Shop();
        AbstractStore trash = new Trash();

        ControlQuality controlQuality
                = new ControlQuality(List.of(shop, warehouse, trash));

        controlQuality.distributeFood(tinnedMeat);
        controlQuality.distributeFood(cheese);
        controlQuality.distributeFood(butter);

        assertThat(controlQuality.retrieveAllFoods()).containsAll(List.of(tinnedMeat, cheese, butter));
    }

    @Test
    void whenControlQualityDeletesAllFoodThenIthasNothing() {

        LocalDateTime createdDate1 = LocalDateTime.now().minusDays(30);
        LocalDateTime expiryDate1 = LocalDateTime.now().plusDays(360);
        Food tinnedMeat = new TinnedFood("tinned meat", createdDate1, expiryDate1, 100, 0);

        LocalDateTime createdDate2 = LocalDateTime.now().minusDays(10);
        LocalDateTime expiryDate2 = LocalDateTime.now().plusDays(1);
        Food cheese = new DairyProducts("cheese", createdDate2, expiryDate2, 500, 0);

        LocalDateTime createdDate3 = LocalDateTime.now().minusDays(30);
        LocalDateTime expiryDate3 = LocalDateTime.now().minusDays(15);
        Food butter = new DairyProducts("butter", createdDate3, expiryDate3, 100, 0);

        AbstractStore warehouse = new Warehouse();
        AbstractStore shop = new Shop();
        AbstractStore trash = new Trash();

        ControlQuality controlQuality
                = new ControlQuality(List.of(shop, warehouse, trash));

        controlQuality.distributeFood(tinnedMeat);
        controlQuality.distributeFood(cheese);
        controlQuality.distributeFood(butter);

        controlQuality.deleteAllFoods();

        assertThat(controlQuality.retrieveAllFoods()).isEmpty();
    }
}