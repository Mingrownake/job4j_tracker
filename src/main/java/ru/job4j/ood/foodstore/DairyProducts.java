package ru.job4j.ood.foodstore;

import java.time.LocalDateTime;

public class  DairyProducts extends Food {

    public DairyProducts(String name, LocalDateTime createDate,
                         LocalDateTime expiryDate, float price, float discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}
