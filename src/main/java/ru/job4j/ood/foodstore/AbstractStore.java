package ru.job4j.ood.foodstore;

/*Абстрактный класс частично реализует логику хранилищ,
чтобы его наследники не дублировали логику;*/

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    private final List<Food> foods = new ArrayList<>();

    abstract boolean checkIfFoodExpired(Food food);

    public List<Food> getFoods() {
        return foods;
    }

    public void addExpiredFood(Food food) {
        foods.add(food);
    }
}
