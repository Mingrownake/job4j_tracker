package ru.job4j.map;

import java.util.Objects;

public final class Student {
    private final String name;
    private final String account;
    private final String group;

    public Student(String name, String account, String group) {
        this.name = name;
        this.account = account;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public String group() {
        return group;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (Student) obj;
        return Objects.equals(this.name, that.name)
                && Objects.equals(this.account, that.account)
                && Objects.equals(this.group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, account, group);
    }

    @Override
    public String toString() {
        return "Student["
                + "name=" + name + ", "
                + "account=" + account + ", "
                + "group=" + group + ']';
    }
}