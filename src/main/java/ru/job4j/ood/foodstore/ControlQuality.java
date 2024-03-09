package ru.job4j.ood.foodstore;

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
        List<Food> allFoodsFromStores = new ArrayList<>();
        for (AbstractStore store : stores) {
            allFoodsFromStores.addAll(store.getFoods());
        }
        return allFoodsFromStores;
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

