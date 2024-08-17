package ru.job4j.lombok;

import java.util.ArrayList;

public class LombokUsage {
    public static void main(String[] args) {
        Permission permission = Permission.of()
                .id(5)
                .name("Admin")
                .roles("Create")
                .roles("Delete")
                .build();
        System.out.println(permission.toString());
    }
}
