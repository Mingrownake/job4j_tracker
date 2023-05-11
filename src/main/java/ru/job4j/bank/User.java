package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка.
 * @author KATYA
 * @version 1.01
 * @since 24.06.2023
 */
public class User {
    /**
     * Паспорт пользователя.
     */
    private String passport;
    /**
     * Имя пользователя.
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить паспорт пользователя.
     * @return номер паспорта.
     */

    public String getPassport() {
        return passport;
    }

    /**
     * Метод позволяет записать номер паспорта пользователя.
     * @param passport номер паспорта, который передаётся в методе.
     */

    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить имя пользователя.
     * @return возвращает имя пользователя.
     */

    public String getUsername() {
        return username;
    }

    /**
     * Метод позволяет записать имя пользователя.
     * @param username имя пользователя, которое передаётся в методе.
     */

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}