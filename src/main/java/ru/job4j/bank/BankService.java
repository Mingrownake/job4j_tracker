package ru.job4j.bank;

import java.util.*;
/**
 * Класс описывает работу модели для банковской системы, которая позволяет:
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счёта на другой счёт.
 * @author KATYA
 * @version 1.01
 * @since 26.04.2023
 */

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя и создаёт ему новый счёт при условии,
     * что такого пользователя ещё не существует.
     * @param user пользователь, который передаётеся в методе.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаляет пользователя, которого находит по паспорту.
     * @param passport номер паспорта, который передаётся в методе.
     * @return возвращает true или false в зависимости от того, был удалён пользователь или нет.
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод создаёт счёт для пользователя при условии, что
     * пользователь уже создан, и такого счёта ещё нет у пользователя.
     * @param passport номер паспорта, который передаётся в методе.
     * @param account номер будущего счёта, который передаётся в методе.
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> allUserAccounts = users.get(user);
            if (!allUserAccounts.contains(account)) {
                allUserAccounts.add(account);
            }
        }
    }

    /**
     * Метод находит пользователя по номеру паспорта.
     * @param passport номер паспорта, который передаётся в методе.
     * @return возвращает пользователя.
     */

    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод находит счёт пользователя по паспорту и реквизитам,
     * при условии, что пользователь существует в системе.
     * @param passport номер паспорта, который передаётся в методе.
     * @param requisite реквизиты, которые передаются в методе.
     * @return возвращает аккаунт.
     */

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод выполняет перевод денег с одного счёта на другой при условии, что оба счёта есть в системе.
     * @param srcPassport номер паспорта для счёта, с которого осуществляется перевод.
     * @param srcRequisite реквизиты счёта, с которого осуществляется перевод.
     * @param destPassport номер паспорта для счёта, на который осуществляется перевод.
     * @param destRequisite реквизиты счёта, на который осуществляется перевод.
     * @param amount сумма перевода.
     * @return результат перевода денег, true или false в зависимости от результата операции.
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (destAccount != null && srcAccount != null
                && amount <= srcAccount.getBalance()) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод выполняет поиск счетов пользователей.
     * @param user список пользователей.
     * @return список всех счетов в системе.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
