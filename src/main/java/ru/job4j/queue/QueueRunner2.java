package ru.job4j.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueRunner2 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        queue.offer("2");
        queue.forEach(System.out::println);
        System.out.println(queue.peek());
        System.out.println(queue.element());
    }
}
