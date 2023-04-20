package ru.job4j.queue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeTry {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.add("second");
        deque.add("first");
        deque.add("third");
      /*  deque.forEach(System.out::println);*/
        System.out.println(deque);
        System.out.println(deque.pop());
        System.out.println(deque.poll());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
    }
}
