package ru.job4j.ood.foodstore;

/* Продукт попадает в сервис ControlQuality.

Сервис ControlQuality в зависимости от срока годности
перекладывает продукты в хранилища: Trash, Warehouse, Shop.

Класс Aggregate содержит ссылку на другой класс и считается владельцем этого класса.
Каждый класс, на который есть ссылка, считается частью класса Aggregate.
ControlQuality может работать с 0 и более хранилищами.
Причем состояние ControlQuality не зависит от Store;
- Store и ControlQuality имеют связь в виде агрегации.
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ControlQuality {

    private List<AbstractStore> stores;

    public ControlQuality(List<AbstractStore> storeList) {
        this.stores = storeList;
    }

    public void distributeFood(Food food) {
        for (AbstractStore store : stores) {
            if (store.checkIfFoodExpired(food)) {
                store.addExpiredFood(food);
            }
        }
    }

    public List<Food> retrieveAllFoods() {
        List<Food> allFoodFromStores = new ArrayList<>();
        for (AbstractStore store : stores) {
            allFoodFromStores.addAll(store.getFoods());
        }
        return allFoodFromStores;
    }

    public void deleteAllFoods() {
        for (AbstractStore store : stores) {
            Iterator<Food> foodIterator = store.getFoods().iterator();
            while (foodIterator.hasNext()) {
                Food food = foodIterator.next();
                foodIterator.remove();
            }
        }
    }
}

