package ru.job4j.pool;

public class StringPoolExample {
    public static void main(String[] args) {
        /* String string1 = new String("Hello");
        String string2 = new String("Hello");
        String string3 = "Hello";
        String string4 = "Hello";
        System.out.println(string1 == string2);
        System.out.println(string3 == string4);
        System.out.println(string1 == string3);
        System.out.println(string2 == string4); */
        /*
        String string1 = "Hello, world";
        String string2 = "Hello, " + "world";
        System.out.println(string1 == string2); */

        String string1 = "Hello"; /*Strings pool*/
        String string2 = new String("Hello"); /*heap*/
        String string3 = string2.intern();
        /*string3 теперь ссылается на соответствующий объект из пула строк, а не на такой же объект в куче.*/
        System.out.println(string1 == string3);

        System.out.println(new String("New string") == new String("New string")); /*false*/
        System.out.println(new String("Interned string").intern() == new String("Interned string").intern()); /*true*/
    }
}