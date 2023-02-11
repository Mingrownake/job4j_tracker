package ru.job4j.record;

public record PersonRecord(String name, int age) {
    public static int maxAge = 100;

    public record PersonRecord2(String name, int age) {
        public PersonRecord2 {
            if (age > 100) {
                throw new IllegalArgumentException("Возраст должен быть менее 101");
            }
        }
    }

    public static int getMaxAge() {
        return maxAge;
    }

    public void info() {
        System.out.println("Print info");
    }
}
