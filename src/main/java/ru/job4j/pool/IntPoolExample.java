package ru.job4j.pool;

public class IntPoolExample {
    public static void main(String[] args) {
        Integer pool1 = 127;
        Integer pool2 = 127;
        System.out.println(pool1 == pool2); /*true Integer pool*/
        Integer heap1 = -129;
        Integer heap2 = -129;
        System.out.println(heap1 == heap2); /*false*/

        /*
        @Deprecated
        Integer poop1 = new Integer(127);
        Integer poop2 = new Integer(127);
        System.out.println(pool1 == pool2); /*false*/

    }
}
