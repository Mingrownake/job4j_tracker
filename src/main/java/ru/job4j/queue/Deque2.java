package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Deque2 {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.add("second");
        deque.addFirst("first");
        deque.addLast("third");
        deque.addLast("forth");

        Iterator<String> iterator = deque.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
