package ru.job4j.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<Account>());
    }

    public boolean deleteUser(String passport) {
        boolean rsl = false;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                users.remove(user);
                rsl = true;
            }
        }
        return rsl;
    }

    public void addAccount(String passport, Account account) {
        if (findByPassport(passport) != null) {
            User user = findByPassport(passport);
            List<Account> allUserAccounts = users.get(user);
            if (!allUserAccounts.contains(account)) {
                allUserAccounts.add(account);
            }
        }
    }

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

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        if (findByPassport(passport) != null) {
            User user = findByPassport(passport);
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        if (findByRequisite(destPassport, destRequisite) != null
                && findByRequisite(srcPassport, srcRequisite) != null
                && amount <= findByRequisite(srcPassport, srcRequisite).getBalance()) {
            double srcBalance = findByRequisite(srcPassport, srcRequisite).getBalance();
            double destBalance = findByRequisite(destPassport, destRequisite).getBalance();
            findByRequisite(srcPassport, srcRequisite).setBalance(srcBalance - amount);
            findByRequisite(destPassport, destRequisite).setBalance(destBalance + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}