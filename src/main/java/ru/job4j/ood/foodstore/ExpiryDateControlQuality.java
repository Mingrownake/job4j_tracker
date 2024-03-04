package ru.job4j.ood.foodstore;

/* Класс Aggregate содержит ссылку на другой класс и считается владельцем этого класса.
Каждый класс, на который есть ссылка, считается частью класса Aggregate.
ControlQuality может работать с 0 и более хранилищами.
Причем состояние ControlQuality не зависит от Store;
*/

public class ExpiryDateControlQuality implements ControlQuality {

    private Warehouse warehouse;
    private Shop shop;
    private Trash trash;

    @Override
    public void sortProduct() {

    }
}
