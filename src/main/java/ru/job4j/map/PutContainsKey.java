package ru.job4j.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PutContainsKey {

    public static Map<Integer, User> addNewElementWithoutCheck(List<User> list) {
        Map<Integer, User> rsl = new HashMap<>();
                for (User user : list) {
            rsl.put(user.id, user);
        }
        return rsl;
    }

    public static Map<Integer, User> addNewElementWithCheck(List<User> list) {
        Map<Integer, User> rsl = new HashMap<>();
        for (User user : list) {
            if (!rsl.containsKey(user.id)) {
                rsl.put(user.id, user);
            }
        }
        return rsl;
    }

    public record User(int id, String name) {
    }
}