package ru.job4j.bank;

import java.util.Objects;
/**
 * Класс описывает работу банковского счёта.
 * @author KATYA
 * @version 1.01
 * @since 26.04.2023
 */

public class Account {
    private String requisite;
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * @return Метод возвращает реквизиты счёта.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод устанавливает реквизиты счёта.
     * @param requisite реквизиты, которые передаются в метод.
     */

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод возвращает баланс счёта
     * @return balance возвращает баланс счёта
     */

    public double getBalance() {
        return balance;
    }

    /**
     * Метод уcтанавливает баланс счёта.
     * @param balance баланс, который передаётся в метод.
     */

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
