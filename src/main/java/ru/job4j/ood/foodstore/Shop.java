package ru.job4j.ood.foodstore;

import java.time.Duration;
import java.time.LocalDateTime;
public class Shop extends AbstractStore {

    @Override
    public boolean checkIfFoodExpired(Food food) {
        boolean foodExpired = false;
        LocalDateTime now = LocalDateTime.now();
        Duration durationFood = Duration.between(food.getCreateDate(), food.getExpiryDate()); /* весь срок годности */
        Duration timeSinceCreation = Duration.between(food.getCreateDate(), now); /*Использованный срок */
        long timeSinceCreationPercent = timeSinceCreation.toMinutes()  * 100 / durationFood.toMinutes();

        if (timeSinceCreationPercent >= 25 && timeSinceCreationPercent < 75) {
            foodExpired = true;
        }
        if (timeSinceCreationPercent >= 75 && timeSinceCreationPercent < 100) {
            food.setDiscount(20);
            food.setPrice(food.getPrice() - (food.getPrice() * food.getDiscount() / 100));
            foodExpired = true;
        }
        return foodExpired;
    }
}
