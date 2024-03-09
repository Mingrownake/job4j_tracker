package ru.job4j.ood.foodstore;

import java.time.Duration;
import java.time.LocalDateTime;

public class Trash extends AbstractStore {

    @Override
    public boolean checkIfFoodExpired(Food food) {
        LocalDateTime now = LocalDateTime.now();
        Duration durationFood = Duration.between(food.getCreateDate(), food.getExpiryDate()); /* весь срок годности */
        Duration timeSinceCreation = Duration.between(food.getCreateDate(), now); /*Использованный срок */

        return durationFood.toMinutes() <= timeSinceCreation.toMinutes();
    }
}
