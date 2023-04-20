package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeTry1 {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.add("second");
        deque.addFirst("first");
        deque.addLast("third");

        Iterator<String> iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
